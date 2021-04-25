package com.company;
import java.util.Scanner;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
    }

    public void add(T newItem) {
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        MyNode<T> cursor = tail;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T nextItem = cursor.data;
            cursor = cursor.next;
            return nextItem;
        }
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public T remove(int index) {
        T element = get(index);
        if (index == 0) {
            head = head.next;
        } else {
            MyNode node = getNode(index - 1);
            node.next = node.next.next;
        }
        size--;
        return element;
    }

    public int find(T keyItem) {
        MyNode node = head;
        for (int i = 0; i < size; i++) {
            if (keyItem == node.data) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Is");//add
        list.add("ocean");
        list.add("blue");
        list.add("?");
//        Scanner my = new Scanner(System.in);
//        int n= my.nextInt();
//        for(int i=0;i<n;i++){//add
//            list.add(i);
//        }

        for (int i = 0; i < list.getSize(); i++) {//simple output
            System.out.println(list.get(i) + " ");
        }
        System.out.println("the index of word blue is:");
        System.out.println(list.find("blue"));//find

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
        for(int i=list.getSize()-1;i>=0;i--){//reverse
            System.out.println(list.get(i)+" ");
        }
    }

    }

