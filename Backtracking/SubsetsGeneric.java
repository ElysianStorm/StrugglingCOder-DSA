package Backtracking;

// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.List;

public class SubsetsGeneric {
    public List<List<Integer>> subsetsGeneric(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrackHelper(new ArrayList<>(), nums, 0, answer);
        return answer;
    }

    public void backtrackHelper(List<Integer> processed, int[] unprocessed, int index, List<List<Integer>> answer){
        answer.add(new ArrayList<>(processed));

        for(int i=index; i<unprocessed.length; i++){
            processed.add(unprocessed[i]);
            backtrackHelper(processed, unprocessed, i + 1, answer);
            processed.remove(processed.size()-1);
        }
    }
}