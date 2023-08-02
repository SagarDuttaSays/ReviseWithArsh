/*
Evaluation of Postfix Expression

PROBLEM STATEMENT

Given a postfix expression, the task is to evaluate the postfix expression.

Postfix expression: The expression of the form “a b operator” (ab+) i.e., when a pair of operands is followed by an operator.

Examples:

Input: str = “2 3 1 * + 9 -“
Output: -4
Explanation: If the expression is converted into an infix expression, it will be 2 + (3 * 1) – 9 = 5 – 9 = -4.

Input: str = “100 200 + 2 / 5 * 7 +”
Output: 757
*/
//My Code
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        for(char ch: S.toCharArray()){
            if('0'<=ch && ch<='9')
                stack.push((int)(ch-'0'));
            else {
                if(ch=='+'){
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                }
                else if(ch=='-'){
                    int diff = (0-stack.pop()) + stack.pop();
                    stack.push(diff);
                }
                else if(ch=='*'){
                    int prod = stack.pop() * stack.pop();
                    stack.push(prod);
                }
                else if(ch=='/'){
                    int top = stack.pop();
                    int bottom = stack.pop();
                    int div = bottom / top;
                    stack.push(div);
                }
            }
        }
        return stack.pop();
    }
}
