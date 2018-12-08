package com.flow.test;

/**
 * 优先级队列（从大到小排序）
 *
 * @author FangChao
 * @date 2018/12/6 11:46
 */
public class PriorityQueue {
    private long[] a;
    private int size;
    private int nItems; //元素个数

    public PriorityQueue (int maxSize) {
        size = maxSize;
        nItems = 0;
        a = new long[size];
    }

    public void insert(long value){
        if(isFull()){
            System.out.println("列队已满！");
            return;
        }
        int j;
        // 空队列直接添加
        if (nItems == 0){
            a[nItems++] = value;
        } else {
            // 将value值按数组中数字的下标从大到小进行比对，并将它放到合适的位置
            for (j = nItems -1; j >= 0; j--){
                if (value > a[j]){
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
            nItems++;
        }
    }

    public long remove(){
        if (isEmpty()){
            System.out.println("队列为空！");
            return 0;
        }
        return a[--nItems];
    }

    public long peekMin(){
        if (isEmpty()){
            System.out.println("队列为空！");
            return 0;
        }
        return a[nItems-1];
    }

    public boolean isFull() {
        return (nItems == size);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public void display(){
        for (int i = nItems - 1; i >= 0; i--){
            System.out.println(a[i] + " ");
        }
        System.out.println(" ");
    }

}
