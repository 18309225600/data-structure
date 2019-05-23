package com.lhf.queue.impl;

import com.lhf.queue.Queue;

/**
 * Created by Liuhongfei on 2019/5/23 23:00
 *
 * 循环队列实现
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E front() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
