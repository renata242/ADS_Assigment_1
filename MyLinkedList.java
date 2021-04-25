package com.company;

public class MyLinkedList<T>{
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){}

    public void add(T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if(head == null){
            head =tail = newNode;
        } else{
            tail.next = newNode;
            tail= newNode;
        }
        size++;
    }
    public T get (int index){
        MyNode<T> current = head;
        for(int i=0; i< index; i++){
            current= current.next;
        }
        return current.data;
    }

    private static class MyNode<E>{
        E data;
        MyNode<E> next;

        MyNode(E data){
            this.data=data;
        }
    }
    public int getSize() {
        return size;
    }
    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    public T remove(int index) {
        T element = get(index);
        if (index == 0) {
            head = head.next;
        } else {
            MyNode node = getNode(index-1);
            node.next = node.next.next;
        }
        size--;
        return element;
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Is");
        list.add("ocean");
        list.add("blue");

        for(int i=0; i< list.getSize(); i++){
            System.out.println(list.get(i)+" ");
        }

        list.remove(1);

        System.out.println(list);

    }
}

