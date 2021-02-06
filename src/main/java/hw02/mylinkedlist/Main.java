package hw02.mylinkedlist;

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

        System.out.println(mll);
        System.out.println(
                mll.get(4)
        );

//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add()
    }
}
