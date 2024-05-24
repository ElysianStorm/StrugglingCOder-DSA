package Backtracking;

// https://leetcode.com/problems/permutations/solutions/5179938/permutations-java-approach-explanation/

// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrackHelper(new ArrayList<Integer>(), nums, answer);
        return answer;
    }

    public void backtrackHelper(List<Integer> processed, int[] unprocessed, List<List<Integer>> answer){
        if(processed.size() == unprocessed.length){
            answer.add(new ArrayList<Integer>(processed));
            return;
        }    
        
        for(int i=0; i<unprocessed.length; i++){
            if(!processed.contains(unprocessed[i])){
                processed.add(unprocessed[i]);
                backtrackHelper(processed, unprocessed, answer);
                processed.remove(processed.size()-1);
            }
        }
    }
}