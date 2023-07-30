/*
Valid Parentheses

PROBLEM STATEMENT:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'
*/
//My Code
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch==')' && !stack.isEmpty() && stack.peek()=='(')
                stack.pop();
            else if(ch=='}' && !stack.isEmpty() && stack.peek()=='{')
                stack.pop();
            else if(ch==']' && !stack.isEmpty() && stack.peek()=='[')
                stack.pop();
            else stack.push(ch);
        }
        return (stack.isEmpty()) ? true : false;
    }
}
