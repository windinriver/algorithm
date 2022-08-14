package leetcode.linkedlist;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists23 {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode listR = ListNode.createListR(new int[]{1, 4, 5});
        ListNode listR1 = ListNode.createListR(new int[]{1, 3, 4});
        ListNode listR2 = ListNode.createListR(new int[]{2, 6});
        listNodes[0] = listR;
        listNodes[1] = listR1;
        listNodes[2] = listR2;
        ListNode listNode = new MergeKLists23().mergeKLists(listNodes);
        ListNode.print(listNode);

    }

    //解法一： 做排序，然后构造链表，复杂度knlognk
    //解法二：两两合并，分治思想，复杂度kn(logk)
    public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            if (lists.length == 2) {
                return mergeTwoLists(lists[0], lists[1]);
            }

            int mid = lists.length /2;
            ListNode[] list1 = new ListNode[mid];
            ListNode[] list2 = new ListNode[lists.length - mid];
            //拆分成两个链表
            for (int i = 0; i < mid; i++) {
                list1[i] = lists[i];
            }
            for (int i = 0, j = mid; j < lists.length; j++, i++) {
                list2[i] = lists[j];
            }
            //分治
           ListNode part1 = mergeKLists(list1);
            ListNode part2 = mergeKLists(list2);
            return mergeTwoLists(part1,part2);
    }

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
