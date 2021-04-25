package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayList<T> {
    private int size = 0;
    private int capacity ;
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

//    public void print() {
//        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
//        }
//    }

    public int getSize() {
        return size;
    }
    public static void main(String[] args){
        MyArrayList<String> list = new MyArrayList<String>();

        list.add("Is");
        list.add("ocean");
        list.add("blue");

        for(int i=0; i< list.getSize(); i++){
            System.out.println(list.get(i)+" ");
        }
    }
}

