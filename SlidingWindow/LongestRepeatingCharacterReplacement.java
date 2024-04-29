package SlidingWindow;

// https://leetcode.com/problems/longest-repeating-character-replacement/solutions/5007467/longest-repeating-character-replacement-java-approach-o-n-time-o-1-space-explanation/

// Medium
// Arrays
// Sliding Window
// T:O(N), S:O(1)
// Window is valid substr, shrink till non max chars < k

class LongestRepeatingCharacterReplacement {
    public int longestRepeatingCharacterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int most_freq_char = 0;
        int max_len = 0;
        int left = 0;
        for(int right=0; right<s.length(); right++){
            charCount[s.charAt(right) - 'A']++;
            most_freq_char = Math.max(most_freq_char, charCount[s.charAt(right) - 'A']);
            while(right-left+1 - most_freq_char > k){
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}