package base.struct.list.test;

import base.struct.list.YwfListNode;

public class YwfListNodeTest {
    public static void main(String[] args) {
        YwfListNode listR = YwfListNode.createListR(new int[]{1, 2, 3, 4, 5, 6});
        YwfListNode listl = YwfListNode.createListF(new int[]{1, 2, 3, 4, 5, 6});
        listl.add(7);
        listl.removeitem(2);
        listR.print();
        listl.print();
    }
}
