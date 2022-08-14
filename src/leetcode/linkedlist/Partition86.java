package leetcode.linkedlist;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition86 {

    public static void main(String[] args) {

        ListNode listR = ListNode.createListR(new int[]{1, 4, 3, 2, 5, 2});

        ListNode partition = new Partition86().partition(listR, 3);
        ListNode.print(partition);
    }

    //思路：巧用临时节点，用一个节点记录小于x的头，用另外一个节点记录大于等于x的头,最后让小链表跟大链表连接即可
    public ListNode partitionMy(ListNode head, int x) {
        ListNode smallHead = null;
        ListNode bigHead = null;

        ListNode preSmall = null;
        ListNode preBig = null;
        while (head != null) {
            if (head.val < x) {
                if (smallHead == null) {
                    smallHead = head;
                }
                if (preSmall != null) {
                    preSmall.next = head;
                }
                preSmall = head;

            } else {
                if (bigHead == null) {
                    bigHead = head;
                }
                if (preBig != null) {
                    preBig.next = head;
                }
                preBig = head;
            }
            head = head.next;
        }
        //让小链表跟大链表连接即可
        if (preSmall!= null){
            preSmall.next = bigHead;
        }
        if (preBig != null) {
            preBig.next = null;
        }
        if( smallHead== null) {
            return bigHead;
        } else return smallHead;

    }

    //思路：巧用临时节点，用一个节点记录小于x的头，用另外一个节点记录大于等于x的头,最后让小链表跟大链表连接即可
    //确实代码就简洁多了
    public ListNode partition(ListNode head, int x) {
        //可以防止这两个时空的，那后面就好判断了
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);

        ListNode preSmall = smallHead;
        ListNode preBig = bigHead;
        while (head != null) {
            if (head.val < x) {
                preSmall.next = head;
                preSmall = head;
            } else {
                preBig.next = head;
                preBig = head;
            }
            head = head.next;
        }
        //让小链表跟大链表连接即可
        preSmall.next = bigHead.next;
        preBig.next = null;
        return smallHead.next;

    }

}
