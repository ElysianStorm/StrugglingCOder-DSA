package SlidingWindow;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/5007972/find-all-anagrams-in-a-string-java-approach-o-n-time-o-1-space-explanation/

// Medium/Approaching Hard
// Arrays/Hashmaps
// Sliding Window
// T:O(N), S:O(1)
// Window checks isAnagram, store char counts for pattern and string in map/array

import java.util.*;

class FindAllAnagramsInString {
    public List<Integer> findAllAnagramsInString(String s, String p) {
        if(p.length()>s.length()){
            ArrayList<Integer> result = new ArrayList<>();
            return result;
        }
        HashMap<Character, Integer> pattern_map = new HashMap<>();
        HashMap<Character, Integer> string_map = new HashMap<>();

        // Put characters of pattern in map with count
        for(Character c: p.toCharArray()){
            pattern_map.put(c, pattern_map.getOrDefault(c, 0) + 1);
        }

        // Put characters of string till length of pattern in map with count
        for(int i=0; i<p.length(); i++){
            string_map.put(s.charAt(i), string_map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = p.length() - 1;
        ArrayList<Integer> result = new ArrayList<>();

        // Start Sliding Window
        while(right<s.length()-1){
            // Check if anagram and add starting index
            if(isAnagram(pattern_map, string_map)){
                result.add(left);
            }
            
            // Update window and correspondingly the string map
            string_map.put(s.charAt(left), string_map.get(s.charAt(left)) - 1);
            left++;
            right++;
            string_map.put(s.charAt(right), string_map.getOrDefault(s.charAt(right), 0) + 1);
        }
        // Check for last window
        if(isAnagram(pattern_map, string_map)){
            result.add(left);
        }

        return result;
    }

    public boolean isAnagram(Map<Character, Integer> pattern, Map<Character, Integer> stringP){
        for(Map.Entry<Character, Integer> entry : pattern.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(stringP.containsKey(key) && stringP.get(key) == value){
                continue;
            }
            else{
                return false;
            }
        } 
        return true;
    }
}