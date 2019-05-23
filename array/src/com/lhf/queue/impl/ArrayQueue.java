package com.lhf.queue.impl;

import com.lhf.array.Array;
import com.lhf.queue.Queue;

/**
 * Created by Liuhongfei on 2019/5/23 22:04
 *
 * 用动态数组实现的队列，有一个方法存在时间性能问题：即出队，出队时间复杂度为O（n) 后面用循环队列解决这个问题使得时间复杂度变为O(1)
 */
public class ArrayQueue<E> implements Queue<E> {

    protected Array<E> array;

    public ArrayQueue(){
        this.array = new Array<>();
    }

    public ArrayQueue(int capacity){
        this.array = new Array<>(capacity);
    }


    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E front() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer("ArrayQueue: front [");

        for (int i=0;i<array.getSize();i++){
            stringBuffer.append(array.get(i));
            if (i!=array.getSize()-1){
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("] tail.");
        return stringBuffer.toString();
    }
}
