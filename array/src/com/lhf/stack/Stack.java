package com.lhf.stack;

/**
 * 栈规范
 */
public interface Stack<E> {

    void push (E e);

    E pop();

    E peek();

    boolean isEmpty();

    int getSize();
}
