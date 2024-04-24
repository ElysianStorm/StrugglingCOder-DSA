package BitManipulation;
// https://leetcode.com/problems/single-number/solutions/5044983/single-number-java-approach-o-n-time-o-1-space-explanation/

// Easy/Medium (Intuition)
// Bit Manipulation
// XOR
// T:O(N), S:O(1)
// XOR number and running XOR value

public class SingleNumber {
    public static int singleNumber(int[] A) {
        int res = A[0];
        
        for(int i=1; i<A.length; i++){
            res = res^A[i];
        }
        
        return res;
    }
}
