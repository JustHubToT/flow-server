package com.flow.test;

/**
 * 栈
 *
 * @author FangChao
 * @date 2018/12/5 21:03
 */
public class ArrayStack {
    private long[] a;
    private int size; // 栈数组的大小
    private int top; // 栈顶

    public ArrayStack(int maxSize) {
        this.size = maxSize;
        this.a = new long[maxSize];
        this.top = -1; // 表示空栈
    }

    // 入栈
    public void push(long value) {
        if (isFull()) {
            System.out.println("栈已满！");
            return;
        }
        a[++top] = value;
    }

    // 返回栈顶的内容，但不删除
    public long peek() {
        if (isEmpty()) {
            System.out.println("栈中没有数据！");
            return 0;
        }
        return a[top];
    }

    // 弹出栈顶内容，删除
    public long pop() {
        if (isEmpty()) {
            System.out.println("栈中没有数据！");
            return 0;
        }
        return a[top--];
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(a[i] + " ");
        }
        System.out.println(" ");
    }
}
