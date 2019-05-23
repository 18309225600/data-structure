package com.lhf.queue;

/**
 * 队列规范
 * @param <E>
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E front();

    boolean isEmpty();

    int getSize();
}
