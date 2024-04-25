package TwoPointers;
// https://www.interviewbit.com/problems/pick-from-both-sides/discussion/p/pick-from-both-sides-java-approach-o-b-time-o-1-space-explanation/502379/2021/

// Easy
// Arrays
// Two Pointers
// T: O(N), S: O(1)
// Start and end, calculate sum start, swap and compare sum from end

import java.util.ArrayList;

public class PickFromBothSIdes {
    public int pickFromBothSIdes(ArrayList<Integer> A, int B) {
        int sum = Integer.MIN_VALUE;
        int first_B_Sum = 0;
        
        for(int i=0; i<B; i++){
            first_B_Sum = first_B_Sum + A.get(i);
        }
        
        int index = B;
        int curr_sum;
        
        while(index>0){
            curr_sum = first_B_Sum - A.get(index-1) + A.get(A.size() - (B - index + 1));
            sum = Math.max(curr_sum, sum);
            first_B_Sum = curr_sum;
            index--;
        }
        
        return sum;
    }
}
