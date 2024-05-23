package Backtracking;

// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIntuitive {
    public List<List<Integer>> combinationSumIntuitive(int[] candidates, int target) {
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

        processed.add(unprocessed[index]);
        backtrackHelper(processed, unprocessed, target - unprocessed[index], index, answer);
        processed.remove(processed.size()-1);
        backtrackHelper(processed, unprocessed, target, index+1, answer);
    }
}
