package com.lhf.stack.impl;

import com.lhf.array.Array;
import com.lhf.stack.Stack;

/**
 * Created by Liuhongfei on 2019/5/23 19:37
 *
 * 使用动态数组实现的栈
 */
public class ArrayStack<E> implements Stack<E> {

    protected Array<E> array;

    public ArrayStack(){
        this.array = new Array<>();
    }

    public ArrayStack(int capacity){
        this.array = new Array<>(capacity);
    }

    /**
     * 推送一个元素到栈顶
     * O(1)
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 从栈顶取出一个元素
     * O(1)
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获得栈顶元素的值
     * O(1)
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 查看栈是否为空
     * O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 查看栈中元素的个数
     * O(1)
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ArrayStack:[");
        for (int i=0;i<array.getSize();i++){
            stringBuffer.append(array.get(i));
            if (i!=array.getSize()-1){
                stringBuffer.append(",");
            }
        }

        stringBuffer.append("] top");
        return stringBuffer.toString();
    }
}
