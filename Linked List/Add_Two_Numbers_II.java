/*
Add Two Numbers II

PROBLEM STATEMENT
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
*/

//My Code:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode curr = l1;
        while(curr!=null){
            s1.push(curr.val);
            curr = curr.next;
        }
        curr = l2;
        while(curr!=null){
            s2.push(curr.val);
            curr = curr.next;
        }
        Stack<Integer> s3 = new Stack<>();
        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int sum = s1.pop() + s2.pop() + carry;
            s3.push(sum%10);
            carry = sum/10;
        }
        while(!s1.isEmpty()){
            int sum = s1.pop() + carry;
            s3.push(sum%10);
            carry = sum/10;
        }
        while(!s2.isEmpty()){
            int sum = s2.pop() + carry;
            s3.push(sum%10);
            carry = sum/10;
        }
        while(carry>0){
            s3.push(carry%10);
            carry = carry/10;
        }
        ListNode dummy = new ListNode(0);
        curr = dummy;
        while(!s3.isEmpty()){
            ListNode newNode = new ListNode(s3.pop());
            curr.next = newNode;
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }
}
