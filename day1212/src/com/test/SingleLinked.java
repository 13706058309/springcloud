package com.test;

import java.util.Stack;

/**
 * 单向链表
 */
public class SingleLinked {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"dage1","dageda1");
        HeroNode heroNode2 = new HeroNode(2,"dage2","dageda2");
        HeroNode heroNode3 = new HeroNode(3,"dage3","dageda3");
        HeroNode heroNode4 = new HeroNode(4,"dage4","dageda4");
        HeroNode heroNode5 = new HeroNode(5,"dage5","dageda5");

        LinkedSingle linkedSingle = new LinkedSingle();

        linkedSingle.add(heroNode1);
        linkedSingle.add(heroNode2);
        linkedSingle.add(heroNode3);
        linkedSingle.add(heroNode4);
        linkedSingle.add(heroNode5);

        linkedSingle.showAll();
        System.out.println("----------------");
        linkedSingle.del(1);
        linkedSingle.showAll();
        HeroNode heroNode6 = new HeroNode(5,"dage6","dageda6");
        linkedSingle.update(heroNode6);
        System.out.println("---------------");
        linkedSingle.showAll();
        HeroNode heroNode9 = new HeroNode(9,"dage9","dageda9");
        HeroNode heroNode8 = new HeroNode(8,"dage8","dageda9");
        linkedSingle.addHeroByID(heroNode9);
        System.out.println("---------------");
        linkedSingle.showAll();
        linkedSingle.addHeroByID(heroNode8);
        System.out.println("---------------");
        linkedSingle.showAll();
        linkedSingle.addHeroByID(heroNode8);
        System.out.println("---------------");
        linkedSingle.reverseLinked();
        linkedSingle.showAll();
        System.out.println("---------------");
        linkedSingle.reservePrint();
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

class LinkedSingle{
    private HeroNode head = new HeroNode(0,"","");
    //添加节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                temp.next = heroNode;
                break;
            }
            temp  = temp.next;
        }
    }
    //根据ID添加节点
    public void addHeroByID(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if(temp.next==null){
                break;
            }

            if(temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no==heroNode.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            System.out.println("改编号已经存在");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //根据ID跟新节点
    public void update(HeroNode heroNode){
        if(head.next==null){
            System.out.println("链表为空的");
            return;
        }

        boolean flag = false;
        HeroNode temp = head;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else{
            System.out.println("链表中不存再改数据，无法跟新");
        }
    }
    //删除节点
    public void del(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        boolean flag = false;
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                break;
            }

            if(temp.next.no==no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("要删除的节点不存在");
        }
    }

    //遍历节点
    public void showAll(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;

        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //求单链表有效头节点
    public int getAllNode(){
        if(head.next==null){
            return 0;
        }

        int sum = 0;
        HeroNode temp = head.next;
        while (temp!=null){
            sum++;
            temp = temp.next;
        }

        return sum;
    }

    //求导数第k个节点
    public HeroNode getBackNumNode(int index){
        if(head.next==null){
            throw new RuntimeException("该链表为空，不存再改节点");
        }

        int length = getAllNode();
        if(index<0){
            throw new RuntimeException("该链表不存在倒数第"+index+"个节点");
        }
        if((length-index)<0){
            throw new RuntimeException("该链表不存在倒数第"+index+"个节点");
        }

        HeroNode temp = head.next;
        for(int i=0;i<length-index;i++){
            temp = temp.next;
        }
        return temp;

    }

    //反转链表
    public void reverseLinked(){
        if(head.next==null||head.next.next==null){
            return;
        }

        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverse = new HeroNode(0,"","");

        while (temp!=null){
            next = temp.next;
            temp.next = reverse.next;
            reverse.next = temp;
            temp = next;
        }

        head.next = reverse.next;
    }

    //从头到尾打印链表
    public void reservePrint(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
