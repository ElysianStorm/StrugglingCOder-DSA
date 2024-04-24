package BitManipulation;
// https://leetcode.com/problems/number-of-1-bits/solutions/5044922/number-of-1-bits-java-approach-o-1-time-o-1-space-explanation/

// Easy
// Bit Manipulation
// AND
// T:O(1), S:O(1)
// AND with n-1 for getting rightmost set bit

public class HammingWeight {
    public static int hammingWeight(int a) {
        int count = 0;
        while(a!=0){
            a = a&(a-1);
            count++;
        }
        
        return count;
    }
}
