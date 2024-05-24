package Backtracking;

// https://leetcode.com/problems/subsets-ii/solutions/5179959/subsets-2-java-approach-explanation/

// Medium
// Backtracking
// DFS
// Processed/Unprocessed

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsWithDuplicates {
    public List<List<Integer>> subsetsWithDuplicates(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrackHelper(new ArrayList<>(), nums, 0, answer);
        return answer;
    }

    public void backtrackHelper(List<Integer> processed, int[] unprocessed, int index, List<List<Integer>> answer){
        answer.add(new ArrayList<>(processed));

        for(int i=index; i<unprocessed.length; i++){
            if(i>index && unprocessed[i-1]==unprocessed[i]) continue;
            processed.add(unprocessed[i]);
            backtrackHelper(processed, unprocessed, i + 1, answer);
            processed.remove(processed.size()-1);
        }
    }
}
