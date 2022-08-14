package leetcode.linkedlist;

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween92 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode listNode = new ReverseBetween92().reverseBetween(listR, 2, 6);
        ListNode.print(listNode);
    }


    //思路：01 关键在于关注四个重要的节点，反转段前后两个，以及反转段的前驱和后继
    // 02 注意返回的头节点就行了

    //反转段的前驱，以及反转后的第一个节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode result = head;

            //反转段前驱
            ListNode preRever = null;

            //先找到第一个需要反转的节点
            for (int i = 1; i < left && head!= null; i++) {
                preRever = head;
                head = head.next;
            }

            //反转后的最后一个节点
            ListNode tailRever = head;

            //对反转端进行反转
            int len = right - left + 1;

            //反转头
            ListNode reverHead = null;
            while (head!= null && len > 0) {
                //先备份
                ListNode next = head.next;

                //反转
                head.next = reverHead;

                //上一个节点指向当前节点
                reverHead = head;

                //遍历
                head = next;
                len--;

            }
            //连接
            tailRever.next = head;

            //如果第一个节点非空，说明不是从第一个节点逆转（表头还是原来的head）
            if (preRever != null) {
                preRever.next = reverHead;
            } else {
                //否则就是反转后的头节点
                result = reverHead;
            }
            return result;
    }
}
