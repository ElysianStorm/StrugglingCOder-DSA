package Backtracking;
// https://leetcode.com/problems/combination-sum/solutions/5179919/combination-sum-java-approach-explanation/
// 
// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.List;

public class CombinationSumGeneric {
    public List<List<Integer>> combinationSumGeneric(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrackHelper(new ArrayList<>(), candidates, target, 0, answer);
        return answer;
    }

    public void backtrackHelper(List<Integer> processed, int[] unprocessed, int target, int index, List<List<Integer>> answer){
        if(target<0 || index >= unprocessed.length) return;

        if(target==0){
            answer.add(new ArrayList<>(processed));
            return;
        }

        for(int i=index; i<unprocessed.length; i++){
            processed.add(unprocessed[i]);
            backtrackHelper(processed, unprocessed, target - unprocessed[i], i, answer);
            processed.remove(processed.size()-1);
        }
    }
}