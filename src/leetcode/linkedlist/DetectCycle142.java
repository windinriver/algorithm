package leetcode.linkedlist;

/**
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCycle142 {

    //思路： 难点在于如何找到环形的起始节点
    //解法一： 用set直接求
    //解法二： 快慢指针。找到相遇的点后，一个指针从头找，一个指针从相遇节点位置找，直到找到相同的节点（证明略）
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow!= null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast!= null)  {
                fast = fast.next;

                //快慢指针相遇
                if (fast == slow) {
                    while (head != fast) {
                        head = head.next;
                        fast = fast.next;
                    }
                    return fast;
                }

            } else {
                return null;
            }
        }
        return null;
    }
}
