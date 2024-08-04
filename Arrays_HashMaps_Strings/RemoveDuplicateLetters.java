package Arrays_HashMaps_Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/solutions/5545235/remove-duplicate-letters-java-pseudocode-explanation/
// Medium/Hard
// Arrays/Hashmaps/Stacks
// T:O(N), S:O(N)
// Stack and set for lexicographical Order
// Save the largest char for last in stack until last index is less than curr index

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> last_index_map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            last_index_map.put(s.charAt(i), i);
        }

        HashSet<Character> seen_set = new HashSet<>();
        Stack<Character> result = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(seen_set.contains(s.charAt(i)))
                continue;
            
            while(!result.isEmpty() && s.charAt(i) < result.peek() && last_index_map.get(result.peek()) > i){
                seen_set.remove(result.pop());
            }

            seen_set.add(s.charAt(i));
            result.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()){
            sb.append(result.pop());
        }

        return sb.reverse().toString();
    }
}
