package SlidingWindow;

// https://leetcode.com/problems/minimum-window-substring/solutions/5009541/minimum-window-substring-java-python-approach-o-n-time-o-1-space-explanation/

// Hard
// Arrays/Hashmaps
// Sliding Window
// T:O(N), S:O(1)
// Window checks pattern in window, decr window size till window becomes invalid

import java.util.*;

public class MinimumWindowSubstring {
    public String minimumWindowSubstring(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        int left = 0;
        int right = t.length()-1;

        int final_left = 0;
        int final_right = Integer.MAX_VALUE;

        HashMap<Character, Integer> t_map = new HashMap<>();
        for(Character c : t.toCharArray()){
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> s_map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            s_map.put(s.charAt(i), s_map.getOrDefault(s.charAt(i), 0) + 1);
        }

        while(right<s.length()-1){
            while(doesContain(s_map, t_map)){
                if(final_right - final_left > right - left){
                    final_right = right;
                    final_left = left;
                }
                s_map.put(s.charAt(left), s_map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
            s_map.put(s.charAt(right), s_map.getOrDefault(s.charAt(right), 0) + 1);            
        }
        
        while(doesContain(s_map, t_map)){
            if(final_right - final_left > right - left){
                final_right = right;
                final_left = left;
            }
            s_map.put(s.charAt(left), s_map.get(s.charAt(left)) - 1);
            left++;
        }

        if(final_right-final_left > s.length()){
            return "";
        }else{
            return s.substring(final_left, final_right+1);
        }
    }

    public boolean doesContain(Map<Character, Integer> s, Map<Character, Integer> p){
        for(Map.Entry<Character, Integer> entry : p.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(s.containsKey(key) && s.get(key) >= value){
                continue;
            }
            else{
                return false;
            }
        }
    return true;
    } 
}
