package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class DuiLie {
    public static void main(String[] args) {
        Queey queey = new Queey(3);
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

class Queey{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arrs;

    public Queey(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arrs = new int[maxSize];
    }
    //判断队列是否满了
    public boolean isFull(){
        return rear == maxSize-1;
    }
    //判断队列是否是空的
    public boolean isEmpty(){
        return front == rear;
    }
    //添加队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满了，无法添加");
            return;
        }

        rear++;
        arrs[rear] = n;
    }

    //出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法出队列");
        }
        front++;
        return arrs[front];
    }
    //展示所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列已空");
            return;
        }
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }

    //展示第一条数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }

        return arrs[front+1];
    }


}
