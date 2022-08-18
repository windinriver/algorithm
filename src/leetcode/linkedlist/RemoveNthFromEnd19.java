package leetcode.linkedlist;

/**
 * 删除倒数第n个节点
 */
public class RemoveNthFromEnd19 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{1, 2, 3, 4, 5});
        ListNode node = new RemoveNthFromEnd19().removeNthFromEnd(listR, 5);
        ListNode.print(node);
    }

    //思路: 先遍历一次得到链表长度，然后找到倒数的n个节点的前一个节点，指向下一个节点就可以了
    public ListNode removeNthFromEndMy(ListNode head, int n) {
        //链表长度
        int len = 0;
        ListNode cur = head;
        while (cur!=null) {
            len++;
            cur = cur.next;
        }
        //计算正数的第n-1个节点
        len = len - n;

        ListNode newHead =  new ListNode(0);
        newHead.next = head;

        ListNode pre = newHead;
        //找到第n-1个节点,循环结束，pre指向前一个节点，而head指向要删除的节点
        while (len > 0) {
            pre = head;
            head = head.next;
            len--;
        }

        pre.next = head.next;
        return newHead.next;
    }

    //采用两个间隔为n的指针，同时向前移动。当快指针的下一个节点为最后一个节点时，要删除的节点就是慢指针的下一个节点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode end = newHead;
        //让快指针先走n   个
        while (n-- > 0) {
            end = end.next;
        }
        //快指针走到最后，那么pre此时走到要删除的节点的前一个
        while (end.next!= null) {
            end = end.next;
            pre = pre.next;
        }
        //执行删除即可
        pre.next = pre.next.next;
        return newHead.next;


    }
}
