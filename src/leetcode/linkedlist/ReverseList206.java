package leetcode.linkedlist;

/**
 * 反转链表
 */
public class ReverseList206 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{1, 2, 3, 4, 5});
        ListNode reverseList = new ReverseList206().reverseList(listR);
        ListNode.print(reverseList);
    }

    //思路： 本题关键在于保存一下节点
    //新建一个节点指向前一个节点，然后遍历链表，将当前节点指向上一个节点
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            //保存下一个节点
            ListNode next = head.next;

            //当前节点指向上一个节点
            head.next = pre;

            //更新上一个节点为当前节点
            pre =head;

            //遍历
            head = next;

        }
        return pre;
    }

}
