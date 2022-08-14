package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetIntersectionNode160 {

    public static void main(String[] args) {

        ListNode listR1 = ListNode.createListR(new int[]{1, 2, 3, 4, 5});
        ListNode listR = ListNode.createListR(new int[]{1, 2, 3, 4, 5});
        ListNode intersectionNode = new GetIntersectionNode160().getIntersectionNode(listR, listR1);
        ListNode.print(intersectionNode);
    }


    //思路：先算出长度差，然后让长的节点走长度差，然后两个链表同时走，走到相同节点则有相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p = headA;
        ListNode q = headB;
        //求A的长度
        while (p != null) {
            lenA++;
            p = p.next;
        }
        //求B的长度
        while (q != null) {
            lenB++;
            q = q.next;
        }
        if (lenA < lenB) {
            int len = lenB - lenA;
            for(int i = 0; i < len; i++) {
                headB = headB.next;
            }
        } else {
            int len = lenA - lenB;
            for (int i = 0; i < len; i++) {
                headA = headA.next;
            }
        }
        //同时走
        while (headA!= null && headB!= null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    //方式二:直接使用set集合
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
