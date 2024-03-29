/*
Subarray Sum Equals K

PROBLEM STATEMENTS:
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
*/
//My Code
class Solution {
    public int subarraySum(int[] nums, int k) {
        int c = 0, sum = 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int n: nums){
            sum = sum + n;
            int diff = sum - k;
            c = c + map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return c;
    }
}
