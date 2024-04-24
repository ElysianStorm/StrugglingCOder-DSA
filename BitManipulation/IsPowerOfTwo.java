package BitManipulation;
// https://leetcode.com/problems/power-of-two/solutions/5045154/power-of-two-java-approach-o-1-time-o-1-space-explanation/

// Easy
// Bit Manipulation
// AND
// T:O(1), S:O(1)
// AND num and num-1

public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        boolean f = (n&(n-1))==0;
        if(n==-2147483648 || n==0)
            return false;
        return f;
    }
}
