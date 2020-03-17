package Play_with_Data_Structures.Demo05Recursive;

import sun.reflect.misc.MethodUtil;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: deleteNode " + val + " in " + head);
        if (head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = deleteNode(head.next, val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val)
            ret = res;
        else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return  ret;
    }

    public String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};

        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).deleteNode(head, 6,0);
        System.out.println(res);
    }
}
