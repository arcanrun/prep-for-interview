package hw02;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import hw02.mylinkedlist.MyLinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>("1", "2");
        mll.add("3");
        mll.add("4");
        System.out.println(mll);

        mll.remvoe("2");
        System.out.println(mll);

        mll.add("13");
        mll.add("42");
        mll.add("52");
        mll.remvoe("13");
        mll.remvoe("1");
        mll.remvoe("52");
        System.out.println(mll);

//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add()
    }
}
