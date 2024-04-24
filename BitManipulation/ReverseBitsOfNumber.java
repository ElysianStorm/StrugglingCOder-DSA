package BitManipulation;
// https://leetcode.com/problems/reverse-bits/solutions/5044946/reverse-bits-java-approach-o-1-time-o-1-space-explanation/

// Easy
// Bit Manipulation
// AND, OR, left/right sift
// T:O(1), S:O(1)
// Move answer right by one, num left by one and store the bit in rightmost bit of answer

public class ReverseBitsOfNumber {
    // you need treat n as an unsigned value
    public static int reverseBitsOfNumber(int a) {
        int answer = 0;
        for(int i=0; i<32; i++){
            answer = (answer<<1)|(a&1);
            a = a>>1;
        }
        return answer;
    }
}