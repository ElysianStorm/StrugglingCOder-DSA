package Arrays_HashMaps_Strings;
// https://www.interviewbit.com/problems/minimum-lights-to-activate/discussion/p/minimum-lights-to-activate-java-approach-o-n-time-o-1-space-explanation/502356/1919/

// Medium
// Arrays
// Traversal
// T: O(N), S: O(1)
// Greedy and lazy, jump and step back, take care of edge cases.

import java.util.ArrayList;

public class MinimumLightsToActivate {
    public int minimumLightsToActivate(ArrayList<Integer> A, int B) {
        int bulbs = 0;
        int last_bulb = -1;
        int curr_bulb = (B-1>=A.size()) ? A.size()-1 : B-1;
        
        while(curr_bulb<A.size()){
            while(curr_bulb > last_bulb && A.get(curr_bulb) == 0){
                curr_bulb--;
            }
            if(last_bulb==curr_bulb){
                return -1;
            }
            else{
                bulbs++;
                last_bulb = curr_bulb;
                if(curr_bulb + 2*(B-1)+1 < A.size()){
                    curr_bulb = curr_bulb + 2*(B-1)+1;
                }
                else if(curr_bulb + B-1 < A.size() - 1){
                    curr_bulb = A.size() - 1;
                }
                else{
                    return bulbs;
                }
            }
        }
        return -1;
    }
}
