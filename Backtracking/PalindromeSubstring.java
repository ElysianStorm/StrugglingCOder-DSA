package Backtracking;
// https://leetcode.com/problems/palindromic-substrings/solutions/5201454/palindromic-substrings-java-pseudocode-explanation/

// Medium
// Recursion
// DFS
// Take center of palindrome as starting point for recursion

class PalindromSubstring {
    public int countSubstrings(String s) {
        int count=0;
        if(s.length()<2)
            return 1;

        for(int i=0; i<s.length()-1; i++){
            int palindromeCount = isPalindrome(s, i, i);
            count = count + palindromeCount;
            palindromeCount = isPalindrome(s, i, i+1);
            count = count + palindromeCount;
        }
        
        return count+1;
    } 

    public int isPalindrome(String s, int left, int right){
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}