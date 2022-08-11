package base.struct.list;


//双向链表
public class YwfLinkedList<E>{

    transient int size = 0;

    //头指针
    transient YwfLinkedList.Node<E> first;

    //尾指针
    transient YwfLinkedList.Node<E> last;

    //链表节点
    private static class Node<E> {
        E item;
        YwfLinkedList.Node<E> next;
        YwfLinkedList.Node<E> prev;

        Node(YwfLinkedList.Node<E> prev, E element, YwfLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    //01-添加元素
    public boolean add(E e) {
        linkLast(e);
        //头插法和尾插法
      return true;
    };

    //尾插法
    void linkLast(E e) {
        Node<E> l = last;
        Node<E> node = new Node<>(l, e, null);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    // 头插法
    void linkFirst(E e) {
        Node<E> f = first;
        Node<E> node = new Node<>(null, e, f);
        first = node;
        if (f == null) {
            last = node;
        } else {
            f.prev = node;
        }
        size++;
    }

    //02-移除元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return unlink(node(index));


    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        //处理节点的前指针
        if (x.prev == null) {
            first  = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        //处理节点的后指针
        if (x.next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    //03-获取元素
    public E get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return node(index).item;
    };


     Node<E> node(int index) {
        //从前往后找
        if (index < size / 2) {
            Node p = first;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p;
        } else {
            Node p = last;
            for (int i = size - 1; i > index; i--) {
                p = p.prev;
            }
            return  p;
        }
    }

    public int size() {
        return size;
    }

    public void print() {
         for (int i = 0; i < size; i++) {
             System.out.print(node(i).item+",");
         }
        System.out.println();
    }

    //应用--------------------------------------------------------------
    //01--将链表拆分成两个链表L = （a1,b1,a2,b2....） 拆分成L1(a1,a2,a3...) L2(bn,bn-1..b1)
    //思路：遍历链表L： 链表1采用头插法，链表2采用尾插法。（L1和L采用相同头节点?）
    public YwfLinkedList<E> spilt() {
         return null;
    }
    //02--删除最大节点
    public void delmaxNode() {

    }

    //02--删除最大和次最大
    public void delMaxAndSecondNode() {}

    //03--链表排序
    public void sort(){}

    //04-链表反转

    //05-.实现求链表的中间结点

    //06--两个链表合成有序链表
}

