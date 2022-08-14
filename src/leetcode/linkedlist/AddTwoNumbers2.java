package leetcode.linkedlist;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode listR = ListNode.createListR(new int[]{9});
        ListNode listR1 = ListNode.createListR(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode listNode = new AddTwoNumbers2().addTwoNumbers(listR1, listR);
        ListNode.print(listNode);
    }

    //测试用例中的数字太大，导致不能使用int
    public ListNode addTwoNumbersMy(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;

        //先算出两个数
        for (int i = 0; l1 != null; i++, l1 = l1.next) {
            num1 = num1 +  getPow(i)* l1.val;
        }

        for (int i = 0; l2 != null; i++, l2 = l2.next) {
            num2 = num2+  getPow(i) * l2.val;
        }
        //得到结果
        int result = num1 + num2;
        //把结果逆序   123
        ListNode listHead = new ListNode(0);
        if (result == 0) {
            return  listHead;
        }
        ListNode preNode = listHead;
        while (result != 0) {
            int curNum = result % 10; //取出最后一位
            ListNode node = new ListNode(curNum);
            preNode.next = node;
            preNode = node;
            result = result / 10;
        }
        return listHead.next;
    }
    public int getPow(int num) {
        int result = 1;
        for (int i =0 ; i < num; i++) {
            result*=10;
        }
        return result;
    }

    //这个代码呢主要是重复逻辑太多，借鉴leetcode主要是把链表空视为0
    public ListNode addTwoNumbersMy2(ListNode l1, ListNode l2) {
        ListNode listHead = new ListNode(0);

        ListNode preNode = listHead;
        boolean flag = false;//标记是否有进位
        while (l1 != null && l2 != null) {

            int value =  l1.val + l2.val;
            if (flag) {
                value+=1;
            }


            if (value >= 10) {
                //取尾数
                value = value % 10;
                //标识有进位
                flag = true;
            } else {
                flag = false;

            }
            ListNode node = new ListNode(value);
            preNode.next = node;
            preNode = node;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = l1.val;
            if (flag) {
                value++;
            }
            if (value >= 10) {
                //取尾数
                value = value % 10;
                //标识有进位
                flag = true;
            } else {
                flag = false;

            }
            ListNode node = new ListNode(value);
            preNode.next = node;
            preNode = node;

            l1 = l1.next;
        }
        while (l2 != null) {
            int value = l2.val;
            if (flag) {
                value++;
            }
            if (value >= 10) {
                //取尾数
                value = value % 10;
                //标识有进位
                flag = true;
            } else {
                flag = false;

            }
            ListNode node = new ListNode(value);
            preNode.next = node;
            preNode = node;

            l2 = l2.next;
        }
        if (flag) {
            ListNode node = new ListNode(1);
            preNode.next = node;
        }
        return listHead.next;
    }

    //主要就是通过把空链表视为0值以及加上进位来解决
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listHead = new ListNode(0);

        ListNode preNode = listHead;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0: l1.val;
            int y = l2 == null ? 0: l2.val;
            int value =  x + y + carry;


            carry = value / 10;
            value = value % 10;
            ListNode node = new ListNode(value);
            preNode.next = node;
            preNode = node;

            if(l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry > 0) {
            ListNode node = new ListNode(1);
            preNode.next = node;
        }
        return listHead.next;
    }

}
