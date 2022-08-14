package leetcode.linkedlist;

public class ListNode {
    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    //尾插法
    public static ListNode createListR(int nums[]) {
        ListNode head = new ListNode();
        ListNode last = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            //最后的节点指向当前创建的节点
            last.next = node;
            //last始终指向最好的节点
            last = node;

        }
        return head.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}
