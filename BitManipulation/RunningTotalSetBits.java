package BitManipulation;
// https://www.interviewbit.com/problems/count-total-set-bits/discussion/p/count-total-set-bits-java-approach-o-n-time-o-1-space-explanation/507201/1859/

// Easy/Medium
// Bit Manipulation
// Inbuilt count bits in number function
// T:O(1), S:O(1)
// Use inbuilt function and add to running sum

public class RunningTotalSetBits {

    private static int mod = (int)1e9 + 7;

    public static int runningTotalSetBits(int A) {
        long res = 0;
        // Integer.bitCount(num) returns number of set bit in num in constant time
        for(int i = 1; i <= A; i++){
            res += Integer.bitCount(i);
        }
        return (int)(res%mod);
    }
}
