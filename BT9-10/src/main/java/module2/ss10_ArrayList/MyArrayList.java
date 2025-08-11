package main.java.module2.ss10_ArrayList;

public class MyArrayList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity must be non-negative");
        }
    }
    public  void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds or negative.");
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
    public E remove(int index){
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds or negative.");
        E oldValue = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return oldValue;
    }
    public int size(){
        return size;
    }
    public MyArrayList<E> clone() {
        MyArrayList<E> newList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            newList.add(this.get(i));
        }
        return newList;
    }
    public boolean contains(E element){
        return indexOf(element) >= 0;
    }
    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i;
        }
        return -1;
    }
    public boolean add (E element){
        ensureCapacity();
        elements[size++] = element;
        return true;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            Object[] newArr = new Object[newSize];
            System.arraycopy(elements, 0, newArr, 0, size);
            elements = newArr;
        }
    }
    public E get(int index){
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds or negative.");
        return (E) elements[index];
    }
    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

}
