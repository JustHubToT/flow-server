package com.flow.test;

/**
 * 单向链表
 *
 * @author FangChao
 * @date 2018/12/6 11:27
 */
public class LinkedList {
    private Link first;
    private int nElem; // 链表中节点数量

    public LinkedList(){
        first = null;
        nElem = 0;
    }

    // 添加头节点
    public void insertFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
        nElem ++;
    }

    // 删除头节点
    public Link deleteFirst() {
        if(isEmpty()){
            System.out.println("链表为空");
            return null;
        }
        Link temp = first;
        first = first.next;
        nElem --;
        return temp;
    }

    public void insert(int value){
        Link newLink = new Link(value);
        Link previous = null;
        Link current = first;
        while(current != null && value > current.data){
            previous = current;
            current = current.next;
        }
        if (previous == null){
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
        nElem ++;
    }

    // 查找特定的节点
    public Link find(int value){
        Link current = first;
        while (current.data != value){
            if (current.next == null){
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    // 删除特定的节点
    public Link delete(int value){
        Link current = first;
        Link previous = first;
        while (current.data != value){
            if (current.next == null){
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        nElem --;
        return current;
    }

    public void displayList(){
        if (isEmpty()){
            System.out.println("链表为空");
            return;
        }
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    public int size(){
        return nElem;
    }

    public boolean isEmpty(){
        return (first == null);
    }
}

class Link{
    public int data;
    public Link next;

    public Link(int data){
        this.data = data;
        this.next = null;
    }

    public void displayLink() {
        System.out.println("{" + data + "}");
    }
}
