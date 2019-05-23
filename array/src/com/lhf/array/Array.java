package com.lhf.array;

/**
 * Created by Liuhongfei on 2019/5/21 21:51
 *
 * 基于jdk的静态数组封装一个动态数据
 * 类中的属性均为private，不想通过外接直接访问到属性，避免一些操作导致类中的属性出现不一致性
 *
 * 总体而言（时间复杂度分析）：
 *      增、删 操作时间复杂度是O(n)
 *      改、查 如果已知索引，则O(1)，否则O(n)
 *
 * 建议使用数组时，下表有实际含义，这样可以根据下标操作，改查的时间复杂度就是O(1)
 */
public class Array<E> {

    //实际存放数据的数组
    private E[] data;
    //数组中目前元素的个数
    private int size;
    //数组初始化容量
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 初始化动态数组，入参为容量
     * @param capacity
     */
    public Array(int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException("init Array failed. capacity must > 0");
        }
        data = (E[])new Object[capacity];
        this.size = 0;
    }

    /**
     * 初始化动态数组，不指定容量时，使用默认容量
     */
    public Array(){
        this(Array.DEFAULT_CAPACITY);
    }

    /**
     * 获取数组中当前有多少个元素
     * O(1)
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * O(1)
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组是否为空
     * O(1)
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 尾部添加元素
     * O(1)
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 首部添加元素
     * O(n)
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向数组中添加元素（默认从末尾添加）
     * O(1)
     * @param e
     */
    public void add(E e){
        this.addLast(e);
    }

    /**
     * 向指定位置添加元素
     * O(n/2) = O(n)
     * @param index
     * @param e
     */
    public void add(int index,E e){

        //valid capacity
        if (size == data.length){
            //扩容
            reCapacity(2*data.length);
        }
        //valid index
        if (index<0||index>size){
            throw new IllegalArgumentException("add failed. Required index>=0 && index<=size");
        }

        //将指定index后面的元素都统一后移一位，然后用e覆盖原来index位置的元素，元素个数+1
        for (int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 从数组中取出指定下标的元素
     * O(1)
     * @param index
     * @return
     */
    public E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    /**
     * 设置index索引位置的元素值为e
     * O（1）
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找指定元素在数组中的索引如果不存在返回-1
     * O(n)
     * @param e
     * @return
     */
    public int index(E e){
        for (int i=0;i<size;i++){
            if (data[i] .equals(e) ){
                return i;
            }
        }

        return -1;
    }

    /**
     * 删除指定索引位置的元素
     * O(n/2) = O(n)
     * @param index
     * @return
     */
    public E remove(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("remove failed. index is illegal.");
        }

        E removeEle = data[index];

        for (int i=index;i<size-1;i++){
            data[i] = data[i+1];
        }

        size--;
        //有利于GC
        data[size] = null;

        //四分之一时再缩容，有利于算法的性能，避免到达临界值是出现每次都需要更改容量的情况
        if (size<=data.length/4 && data.length/2 !=0){
            reCapacity(data.length/2);
        }

        return removeEle;
    }

    /**
     * 删除第一个元素
     * O(n)
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * O(1)
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 取出第一个元素
     * O(1)
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 取出最后一个元素
     * O(1)
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 动态扩容
     * O(n)
     * @param newCapacity
     */
    private void reCapacity(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }

        data = newData;
    }


    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        stringBuffer.append("[");
        for (int i=0;i<size;i++){
            stringBuffer.append(data[i]);
            if (i!=size-1){
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");

        return stringBuffer.toString();
    }
}
