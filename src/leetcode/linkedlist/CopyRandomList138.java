package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 已知一个复杂的链表，节点中有一个指向本链表任意某个节点的随机指
 * 针(也可以为空)，求这个链表的深度拷贝
 */
public class CopyRandomList138 {

    //思路：使用map作为辅助构造链表
    public Node copyRandomList(Node head) {

        //地址-- id编号的映射
        HashMap<Node, Integer> map = new HashMap();

        //保存新链表的头
        Node newHead = new Node(0);

        //指针变量,指向新链表的上一个节点
        Node preNode = newHead;

        //指针变量，指向旧链表当前节点
        Node curNode = head;
        //自带id跟node的关系
        List<Node> list = new ArrayList<>();
        int i = 0;
        while (curNode != null) {
            map.put(curNode, i++);
            //深拷贝
            Node node = new Node(curNode.val);
            preNode.next = node;
            preNode = node;
            list.add(node);

            curNode = curNode.next;
        }
        //构造random指针
        //指针变量,指向新链表的当前节点
        curNode = newHead.next;
        while (head != null) {
            Integer id = map.get(head.random);
            if (id != null) {
                Node random = list.get(id);
                curNode.random = random;
            }
            head = head.next;
            curNode = curNode.next;
        }
        return newHead.next;
    }
}
