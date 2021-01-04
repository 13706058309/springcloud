package com.test;

import java.sql.SQLOutput;

//约瑟夫环
public class Josepfu {
    public static void main(String[] args) {
        JosepfuLinkedList list = new JosepfuLinkedList();
        list.addChild(40);
        list.out(1,10,40);
    }
}

class JosepfuLinkedList{
    private Child first = null;
    //添加数量
    public void addChild(int nums){
        if(nums<1){
            System.out.println("输入个数有误");
            return;
        }
        Child curChild = null;
        for(int i=1;i<=nums;i++){
           Child child = new Child(i);
           if(i==1){
               first = child;
               child.next = first;
               curChild = child;
           }else{
               curChild.next = child;
               child.next = first;
               curChild = child;
           }
        }
    }

    //遍历
    public void showAll(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        Child temp = first;
        while (true){
            System.out.println(temp.no);
            temp = temp.next;
            if(temp==first){
                break;
            }
        }
    }

    //约瑟夫环出队列

    /**
     *
     * @param startNo 从那里开始
     * @param count 数到第几个出列
     * @param nums 一共有都是个人玩
     */
    public void out(int startNo,int count,int nums){
        if(first==null||startNo<1||startNo>nums){
            System.out.println("请规范输入");
            return;
        }

        Child helper = first;

        //让帮助指针helper指向最后一个点
        while (true){
            if(helper.next==first){
                break;
            }
            helper = helper.next;
        }

        //让first和helper同时移动count-1次
        for(int i=0;i<startNo-1;i++){
            first = first.next;
            helper = helper.next;
        }

        while (true){

            if(helper==first){
                break;
            }

            for(int i=0;i<count-1;i++){
                first = first.next;
                helper = helper.next;
            }

            System.out.println(first.no);

            first = first.next;
            helper.next = first;
        }
        System.out.println(first.no);
    }

}

class Child{
    public int no;
    public Child next;

    public Child(int no) {
        this.no = no;
    }
}
