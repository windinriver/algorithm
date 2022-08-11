package base.struct.list.test;

import base.struct.list.SqList;

public class SqListTest {

    public static void main(String[] args) {
        SqList sqList = new SqList();
        int[] data = {14,1,3,5,7,3,10,15,0,20};
        sqList.createList(data, data.length);
        sqList.printList();
        sqList.move();
        sqList.printList();



        //测试讲两个有序列表合并
        SqList sqList2 = new SqList();
        int[] data2 = {1, 2, 3, 4, 5, 6, 7};
        sqList2.createList(data2, data2.length);
        SqList newlist =  SqList.hbSortList(sqList2, sqList2);
        newlist.printList();
    }
}
