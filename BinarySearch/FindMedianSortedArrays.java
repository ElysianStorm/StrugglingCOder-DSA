package BinarySearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/4978899/median-of-two-sorted-arrays-java-approach-o-log-n-m-time-o-1-space-explanation/

// HARD!!!
// Arrays (2 Arrays)
// Binary Search
// T:O(log(N+M)), S:O(1)
// Find elem before median, 4 pointers within 2 arrays, BS with those 4 pointers

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len_1 = nums1.length;
        int len_2 = nums2.length;

        // Ensure smaller array is nums1
        if(len_1 > len_2){
            return findMedianSortedArrays(nums2, nums1);
        }

        // Calculate total length of combined array and length of left part before median
        int len = len_1 + len_2;
        int left_part = (len_1 + len_2 + 1)/2;

        int low = 0;
        int high = len_1;

        while(low<=high){
            int mid1 = low + (high - low)/2;

            // Mid 2 is the remaining elements on left after Mid 1
            int mid2 = left_part - mid1;

            // Declare the 4 pointers
            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;

            // Initialise 4 pointers based on size conditions
            if(mid1 < len_1){
                right1 = nums1[mid1];               //If mid1 is not the last element in nums1, then right1 is mid1
            }
            if(mid2 < len_2){
                right2 = nums2[mid2];               //If mid2 is not the last element in nums2, then right2 is mid2
            }
            if(mid1 - 1 >= 0){
                left1 = nums1[mid1 - 1];            //If mid1 is not the first element in nums1, then left1 is mid1-1
            }
            if(mid2 - 1 >= 0){
                left2 = nums2[mid2 - 1];            //If mid2 is not the first element innums2, then left2 is mid2-1
            }

            // Binary Search starts
            if(left1 <= right2 && left2 <= right1){         //Valid sorted cond.
                if(len%2 == 1){
                    return Math.max(left1, left2);          //ODD scenario
                }
                else{
                    return ((double)(Math.max(left1, left2) + Math.min(right1, right2))) / 2.0;     //EVEN scenario
                }
            }
            else if(left1 > right2){                        //nums1 needs to have less elements in combined array before middle 
                high = mid1 - 1;
            }
            else{                                           //nums1 needs to have more elements in combined array before middle
                low = mid1 + 1;
            }
        }

        return 0;
    }
}
