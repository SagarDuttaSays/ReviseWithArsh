/*
Subarray Sums Divisible by K

PROBLEM STATMENT
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, c= 0;
        map.put(0,0);
        for(int n: nums){
            sum += n;
            int remainder = (sum % k + k) % k;;
            if(!map.containsKey(remainder))
                map.put(remainder, 0);
            else {
                int freq = map.get(remainder);
                c = c + (freq+1);
                map.put(remainder, freq+1); 
            }
        }
        return c;
    }
}
