package com.test;

import java.util.Scanner;

public class HuanXingDuiLie {
    public static void main(String[] args) {
        CirleQueue queey = new CirleQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queey.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入添加的号码");
                    int code = scanner.nextInt();
                    queey.addQueue(code);
                    break;
                case 'g':
                    try {
                        int res = queey.getQueue();
                        System.out.println("取出的数据是："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queey.headQueue();
                        System.out.println("头位数据是："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("退出程序");
    }
}

class CirleQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arrs;

    public CirleQueue(int maxSize){
        this.maxSize = maxSize;
        arrs = new int[maxSize];
    }
    //判断队列是否空了
    public boolean isEmpty(){
        return front==rear;
    }
    //判断队列是否满了
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    //往队列里面添加数
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列满了");
            return;
        }

        arrs[rear] = num;
        rear = (rear+1)%maxSize;
    }
    //取出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空了");
        }
        int res = arrs[front];
        front = (front+1)%maxSize;
        return res;
    }
    //展示所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空了");
            return;
        }
        for(int i=front;i<front+size();i++){
            System.out.println(arrs[i%maxSize]);
        }
    }
    //取出头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空了");
        }
        return arrs[front];
    }
    //得出队列总数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
