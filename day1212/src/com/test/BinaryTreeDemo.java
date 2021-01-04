package com.test;

import java.lang.reflect.Modifier;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNodes root = new HeroNodes(1,"xiaohai");
        HeroNodes node2 = new HeroNodes(2,"dakou");
        HeroNodes node3 = new HeroNodes(3,"hechi");
        HeroNodes node4 = new HeroNodes(4,"yawang");
        HeroNodes node5 = new HeroNodes(5,"laiba");

        root.left=node2;
        root.right = node3;
        node3.left = node5;
        node3.right = node4;

        BinaryTree binaryTree = new BinaryTree(root);

        System.out.println("前序");
        binaryTree.preList();
        System.out.println(binaryTree.findByPre(5));

        System.out.println("中序");
        binaryTree.midList();
        System.out.println(binaryTree.findByMid(5));

        System.out.println("后序");
        binaryTree.backList();
        System.out.println(binaryTree.findByBack(5));

    }
}

class BinaryTree{
    private HeroNodes root;
    public BinaryTree(HeroNodes root){
        this.root = root;
    }

    public void preList(){
        if(root==null){
            System.out.println("为空");
        }else{
            root.preList();
        }
    }

    public void midList(){
        if(root==null){
            System.out.println("为空");
        }else{
            root.midList();
        }
    }

    public void backList(){
        if(root==null){
            System.out.println("为空");
        }else{
            root.backList();
        }
    }

    public HeroNodes findByPre(int no){
        if(root==null){
            return null;
        }

        return root.findByPre(no);
    }

    public HeroNodes findByMid(int no){
        if(root==null){
            return null;
        }

        return root.findByMid(no);
    }

    public HeroNodes findByBack(int no){
        if(root==null){
            return null;
        }

        return root.findByBack(no);
    }

    public void delNode(int no){
        if(root!=null){
            if(root.no==no){
                root=null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("kong");
        }
    }
}

class HeroNodes{
    public int no;
    public String name;
    public HeroNodes left;
    public HeroNodes right;

    public HeroNodes(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNodes() {
    }

    @Override
    public String toString() {
        return "HeroNodes{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preList(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preList();
        }
        if(this.right!=null){
            this.right.preList();
        }
    }

    public void midList(){
        if(this.left!=null){
            this.left.midList();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midList();
        }
    }

    public void backList(){
        if(this.left!=null){
            this.left.backList();
        }
        if(this.right!=null){
            this.right.backList();
        }
        System.out.println(this);
    }

    public HeroNodes findByPre(int no){
        HeroNodes node = null;
        if(this.no==no){
            return this;
        }

        if(this.left!=null){
            node = this.left.findByPre(no);
        }
        if(node!=null){
            return node;
        }

        if(this.right!=null){
            node = this.right.findByPre(no);
        }
        return node;
    }

    public HeroNodes findByMid(int no){
        HeroNodes node = null;

        if(this.left!=null){
            node = this.left.findByMid(no);
        }

        if(node!=null){
            return node;
        }

        if(this.no==no){
            return this;
        }

        if(this.right!=null){
            node = this.right.findByPre(no);
        }
        return node;

    }

    public HeroNodes findByBack(int no){
        HeroNodes node = null;

        if(this.right!=null){
            node = this.right.findByBack(no);
        }

        if(node!=null){
            return node;
        }

        if(this.left!=null){
            node = this.left.findByBack(no);
        }

        if(node!=null){
            return node;
        }

        if(this.no==no){
            return this;
        }
        return node;
    }

    public void delNode(int no){
        if(this.left!=null&&this.left.no==no){
            this.left = null;
            return;
        }

        if(this.right!=null&&this.right.no!=no){
            this.right = null;
            return;
        }

        if(this.left!=null){
            this.left.delNode(no);
        }

        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}
