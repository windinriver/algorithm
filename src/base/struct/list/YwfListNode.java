package base.struct.list;

/**
 * 单链表节点实现..带有不带数据的头节点
 */
public class YwfListNode {

    //指向下个节点的指针
    public YwfListNode next;

    //数据项使用整形
    public int item;

    //使用头插法创建链表
    public static YwfListNode createListF(int []nums) {
        YwfListNode head = new YwfListNode();
        for (int i = 0; i < nums.length; i++) {
            YwfListNode node = new YwfListNode(nums[i]);
            //新建的节点指向头指针指向的下一个节点
            node.next = head.next;
            //头指针指向下一个当前数据节点
            head.next = node;
        }
        return head;
    }

    //尾插法
    public static YwfListNode createListR(int nums[]) {
        YwfListNode head = new YwfListNode();
        YwfListNode last = head;
        for (int i = 0; i < nums.length; i++) {
            YwfListNode node = new YwfListNode(nums[i]);
            //最后的节点指向当前创建的节点
            last.next = node;
            //last始终指向最好的节点
            last = node;

        }
        return head;
    }

    //
    public void print() {
        YwfListNode p = this.next;
        while (p != null) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    //找到最好的节点，然后加进去
    public boolean add(int item) {
        YwfListNode p = this.next;
        while (p.next != null) {
            p = p.next;
        }
        YwfListNode node = new YwfListNode(item);
        p.next = node;
        return true;
    }

    //移除第一个等于item的值
    public boolean removeitem(int item) {
        YwfListNode p = this;
        YwfListNode q = this.next;
        while (q != null) {
            if (q.item == item) {
                p.next = q.next;
                return true;
            }
            p = q;
            q = q.next;
        }
        return false;

    }

    public YwfListNode() {
        this.item =0;
    }

    public YwfListNode(int item) {
        this.item = item;
    }

    public YwfListNode getNext() {
        return next;
    }

    public void setNext(YwfListNode next) {
        this.next = next;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
}
