package leetcode.linkedlist;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 */
public class SwapPairs24 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{1, 2, 3, 4});
        ListNode node = new SwapPairs24().swapPairs2(listR);
        ListNode.print(node);
    }

    //思路：双指针移动即可
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);

        //特判
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode tail = newHead;
        while (first!= null && second!= null) {
            //备份第二个节点的下一个节点
            ListNode next = second.next;

            //连接上第二个节点
            tail.next = second;
            //第二个连上第一个
            second.next = first;

            //新链表最后一个节点变成first
            tail = first;

            //双指针移动
            first = next;
            if (first!= null) {
                second = first.next;
            }
        }
        //first有可能是空，也可能是最后一个节点
        tail.next = first;
        return newHead.next;
    }

    //思路二: 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode pair = swapPairs2(next.next);
        head.next = pair;
        next.next = head;
        return next;
    }

    //别人的代码
    public ListNode swapPairs3(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

}
