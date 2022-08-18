package leetcode.linkedlist;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class DeleteDuplicates82 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{1, 2,2});
        ListNode node = new DeleteDuplicates82().deleteDuplicates(listR);
        ListNode.print(node);
    }

    //思路：遍历链表，判断当前节点是否和下一个节点值一致，如果一致跳过所有改值
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);

        ListNode pre = newHead;
        while (head!= null) {
            int val = head.next == null? 0:head.next.val;
            //和下一个节点一致
            if (head.val == val) {
                while (head!= null && head.val == val) {
                    head = head.next;
                }
            } else {
                //不相同则加入
                pre.next = head;
                pre = head;
                head = head.next;
            }
        }
        //这里要置空
        pre.next = null;
        return newHead.next;

    }
}
