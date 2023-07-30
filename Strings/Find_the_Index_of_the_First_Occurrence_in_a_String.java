/*
Find the Index of the First Occurrence in a String

PROBLEM STATEMENT:
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 10^4
haystack and needle consist of only lowercase English characters.
*/
//My Code:
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(n<m)
            return -1;
        int hashN = needle.hashCode();
        for(int i = 0; i<(n-m+1); i++){
            if(haystack.substring(i, i+m).hashCode()==hashN)
                return i;
        }
        return -1;
    }
}
