package Play_with_Data_Structures.Demo04LinkedList;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null){
            if (prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};

        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).deleteNode(head, 6);
        System.out.println(res);
    }
}
