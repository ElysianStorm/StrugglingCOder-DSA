package Backtracking;

// https://leetcode.com/problems/combination-sum-ii/solutions/5179985/combination-sum-2-java-approach-explanation/

// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackHelper(new ArrayList<>(), candidates, target, 0, answer);
        return answer;
    }

    public void backtrackHelper(List<Integer> processed, int[] unprocessed, int target, int index, List<List<Integer>> answer){
        if(target<0) return;

        if(target==0){
            answer.add(new ArrayList<>(processed));
        }

        for(int i=index; i<unprocessed.length; i++){
            if(i>index && unprocessed[i-1]==unprocessed[i]) continue;
            processed.add(unprocessed[i]);
            backtrackHelper(processed, unprocessed, target - unprocessed[i], i+1, answer);
            processed.remove(processed.size()-1);
        }
    }
}