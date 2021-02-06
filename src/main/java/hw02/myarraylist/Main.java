package hw02.myarraylist;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.remove("4");
        arr.add(2, "10");
        arr.add(0, "-10");
        arr.add(5, "-101");
        arr.add(1, "-121");
        System.out.println(arr);
    }
}
