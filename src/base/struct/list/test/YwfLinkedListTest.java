package base.struct.list.test;

import base.struct.list.YwfLinkedList;

public class YwfLinkedListTest {

    public static void main(String[] args) {
        YwfLinkedList linkedList = new YwfLinkedList();

        for (int i = 0; i < 20; i++) {
            linkedList.add(i+"");
        }
        linkedList.remove(10);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        linkedList.print();

    }
}
