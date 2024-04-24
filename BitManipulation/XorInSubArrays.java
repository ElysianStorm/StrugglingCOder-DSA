package BitManipulation;
// https://www.interviewbit.com/problems/xor-ing-the-subarrays/discussion/p/xor-ing-the-subarrays-java-approach-o-n-time-o-1-space-explanation/507203/2015/

// Easy/Medium
// Bit Manipulation
// Pattern recognition
// T:O(1), S:O(1)
// XOR even index numbers

import java.util.ArrayList;

public class XorInSubArrays {
    public static int xorInSubArrays(ArrayList<Integer> A) {
        int xorf = 0;
        if((A.size()&1)==0)
            return 0;
        else{
            for(int i=0; i<A.size(); i+=2){
                xorf = xorf^A.get(i);
            }
            return xorf;
        }     
    }
}