package BitManipulation;
// https://leetcode.com/problems/single-number-ii/solutions/5045053/single-number-ii-java-approach-o-n-time-o-1-space-explanation/

// Medium/Hard (Intuition)
// Bit Manipulation
// XOR, AND, NOT
// T:O(N), S:O(1)
// Set ones and twos, XOR with set -> AND with NOT of other set

public class SingleNumber2 {
    public static int singleNumber2(int[] A) {
        int ones = 0;
        int twos = 0;
        
        for(int i=0; i<A.length; i++){
            ones = (ones^A[i]) & (~twos);
            twos = (twos^A[i]) & (~ones);
        }
        return ones;
    }
}
