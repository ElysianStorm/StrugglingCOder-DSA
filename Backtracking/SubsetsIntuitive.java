package Backtracking;
// https://leetcode.com/problems/subsets/solutions/5179904/subsets-java-approach-explanation/
// 
// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.List;

public class SubsetsIntuitive {
    public List<List<Integer>> subsetsIntuitive(int[] nums) {
        List<Integer> processed = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        backtrackHelper(processed, nums, 0, answer);
        return answer;
    }

    public void backtrackHelper(List<Integer> processed, int[] unprocessed, int index, List<List<Integer>> answer){
        if(index == unprocessed.length){
            answer.add(new ArrayList<>(processed));
            return;
        }

        processed.add(unprocessed[index]);
        backtrackHelper(processed, unprocessed, index + 1, answer);
        processed.remove(processed.size()-1);
        backtrackHelper(processed, unprocessed, index + 1, answer);
    }
}
