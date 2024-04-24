package BitManipulation;
// https://www.interviewbit.com/problems/min-xor-value/discussion/p/min-xor-value-java-approach-o-nlogn-time-o-1-space-explanation/507170/1068/

// Easy/Medium
// Bit Manipulation
// XOR, iteration
// T:O(1), S:O(1)
// Sort then XOR to save unnecessary comparisons

import java.util.ArrayList;
import java.util.Collections;

public class MinXorValue {
    public static int minXorValue(ArrayList<Integer> A) {
        Collections.sort(A);
        
        int minXOR = Integer.MAX_VALUE;
        
        for(int i=0; i<A.size()-1; i++){
            int currXOR = A.get(i) ^ A.get(i+1);
            if(currXOR<minXOR)
                minXOR = currXOR;
        }
        
        return minXOR;
    }
}
