package main.java.module2.ss10_ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        System.out.println("Is empty? " + list.isEmpty());

        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println("Size: " + list.size());
        System.out.println("Element at 1: " + list.get(1));

        list.add(1, "JavaScript");
        System.out.println("Element at 1 after insert: " + list.get(1));

        list.remove(2);
        System.out.println("Element at 2 after remove: " + list.get(2));

        System.out.println("Contains Java? " + list.contains("Java"));
        System.out.println("Index of Java: " + list.indexOf("Java"));

        MyArrayList<String> clonedList = list.clone();
        System.out.println("Original: " + list.get(0));
        System.out.println("Cloned: " + clonedList.get(0));
    }
}
