package com.test;

public class DoubleLinked {

    public static void main(String[] args) {

    }


}

class LinkedDouble{
    public Hero head = new Hero(0,"","");
    public Hero getHead(){
        return head;
    }
    //遍历输出所有数据
    public void showAll(){
        if(head.next==null){
            System.out.println("该链表为空");
        }

        Hero temp = head.next;
        while (temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点
    public void addNode(Hero hero){
        Hero temp = head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = hero;
        hero.pre = temp;
    }

    //跟新节点
    public void updateNode(Hero hero){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        boolean flag = false;
        Hero temp = head.next;
        while (true){
            if(temp==null){
                break;
            }

            if(temp.no==hero.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.name = hero.name;
            temp.nickName = hero.nickName;
        }else{
            System.out.println("跟新的节点在链表中不存在");
        }
    }

    //删除节点
    public void del(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        boolean flag = false;
        Hero temp = head.next;
        while(true){
            if(temp==null){
                break;
            }

            if(temp.no==no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.pre.next = temp.next;
            //要删除的节点可能是最后一个节点，所以需要判断下
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.println("要删除的节点不存在");
        }
    }
}

class Hero{
    public int no;
    public String name;
    public String nickName;
    public Hero next;
    public Hero pre;

    public Hero(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
