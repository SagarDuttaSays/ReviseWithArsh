/*
Longest Common Prefix

PROBLEM STATEMENT:
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

//My Code
class Solution {
    static class Trie{
        Trie[] letters;
        boolean eow;
        Trie(){
            letters = new Trie[26];
            for(int i = 0; i<26; i++)
                letters[i] = null;
            eow = false;
        }
    }
    public void insert(String s, Trie root){
        Trie curr = root;
        for(int i = 0; i<s.length(); i++){
            int ch = s.charAt(i) -'a';
            if(curr.letters[ch]==null)
                curr.letters[ch] = new Trie();
            if(i==s.length()-1)
                curr.eow = true;
            curr = curr.letters[ch];
        }
    }
    public String f(Trie root){
        String str = "";
        Trie curr = root;
        int count = 0;
        for(int i = 0; i<26; i++){
            if(curr.letters[i]!=null)
                count++; 
        }
        if(count!=1)
            return str;
        int i = 0;
        for(; i<26; i++){
            if(curr.letters[i]!=null){
                str = str + (char)(i+'a');
                str += (curr.eow) ? "" : f(curr.letters[i]);
                break;
            }
            
        }
        return str;
    }
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for(int i = 0; i<strs.length; i++){
            if(strs[i].equals(""))
                return "";
            insert(strs[i], root);
        }
        String ans = f(root);
        return ans;
    }
}
