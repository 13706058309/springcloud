package com.test;

public class ArrayStack {
    private int maxSize;
    private int[] array;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize];
    }
    //判断是否已经满了
    public boolean isFull(){
        return maxSize-1==top;
    }
    //判断是否空的
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int n){
        if(isFull()){
            System.out.println("已经满了");
            return;
        }

        top++;
        array[top] = n;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈是空的");
        }
        int value = array[top];
        top--;
        return value;
    }

    //遍历栈
    public void showAll(){
        if(isEmpty()){
            throw new RuntimeException("栈是空的");
        }

        for(int i=top;i>=0;i--){
            System.out.println(array[i]);
        }
    }

}
