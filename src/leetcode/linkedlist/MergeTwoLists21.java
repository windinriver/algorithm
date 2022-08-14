package leetcode.linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists21 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{1, 2, 4});
        ListNode listR1 = ListNode.createListR(new int[]{1, 3, 4});
        ListNode listNode = new MergeTwoLists21().mergeTwoLists(listR, listR1);
        ListNode.print(listNode);
    }

    //思路：双指针指向两个排序链表,谁小就连接谁
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (list1!= null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }
        }
        //拼接剩下的链表
        if ( list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return result.next;
    }

}
