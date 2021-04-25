package com.company;

import java.util.Iterator;
import java.util.Scanner;

public class MyArrayList<T> implements Iterable<T>{
    private int size = 0;
    private int capacity;
    private Object[] array;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void add(T newItem) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    private void increaseBuffer() {
        capacity = (int) (2 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    public int getSize(){
        return size;
    }

    public int find(T keyItem) {
        for (int i = 0; i < size; i++) {
            if (keyItem == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        T element = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }
    public static<T> MyArrayList<T> reverse(MyArrayList<T> list)
    {
        MyArrayList<T> reverse = new MyArrayList<>(array.size());

        for (int i = array.size() - 1; i >= 0; i--) {
            reverse.add(list.get(i));
        }
        return reverse;
    }


    @Override
    public Iterator<T> iterator() {//no need for this part
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != getSize();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }

    public static void main(String[] args) {
//        int[] myArr = { 10,15,47,8,1,-9,0,7 };
//        Scanner myT = new Scanner(System.in);
//        System.out.println("choose the number of which index u want to know");
//        int T = myT.nextInt();
//        System.out.println("index position of "+ T +" is: "
//                + find( myArr,T));
          MyArrayList<Integer> list = new MyArrayList<>();

            list.add(1);
            list.add(2);
            list.add(3);

            for (int i = 0; i < list.getSize(); i++) {//simple output
                System.out.println(list.get(i) + " ");
            }
            System.out.println("the index of 1 is:");
            System.out.println(list.find(1));//find

            list.remove(3);
            System.out.println("the removed items' index is 3");
            for (int i = 0; i < list.getSize(); i++) {//simple output
                System.out.println(list.get(i) + " ");
            }
    //
    //        for (String item : list) {
    //            System.out.println(item + " ");
    //        }
            System.out.println("the reversed order is");
            MyArrayList<Integer> reverse = reverse(list);
            System.out.println(reverse);

//        for(int i=0; i<5; i++){
//            list.add(i);
//        }
//
//        System.out.println(array.toString(list.toArray()) + " size = " + mal.size);
//
//        list.remove(new Integer(2));
//        System.out.println(array.toString(list.toArray()) + " size = " + mal.size);
    }
}
