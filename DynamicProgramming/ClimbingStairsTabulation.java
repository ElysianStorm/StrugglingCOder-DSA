package DynamicProgramming;
// Easy
// DP
// DFS with memoization, tabulation
// Memoization: Return answers for target, save in dp before return.
// Tabulation: Last step = Second Last Step + Third Last Step

// Recurrence: F(N) = F(N-1) +F(N-2)
public class ClimbingStairsTabulation {
    // Tabulation Approach
    public int climbingStairsTabulation(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
