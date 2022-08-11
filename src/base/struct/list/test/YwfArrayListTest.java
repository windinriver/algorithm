package base.struct.list.test;

import base.struct.list.YwfArrayList;

public class YwfArrayListTest {

    public static void main(String[] args) {
        YwfArrayList<String> list = new YwfArrayList<>();
        for(int i = 0 ; i < 20; i++) {
            list.add(i+"");
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(list.get(i));
        }
    }
}
