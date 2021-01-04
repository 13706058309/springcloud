package com.test;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTables hashTables = new HashTables(10);
        Emp emp1 = new Emp(1,"123");
        Emp emp2 = new Emp(2,"123");
        Emp emp3 = new Emp(3,"123");
        Emp emp4 = new Emp(4,"123");
        Emp emp5 = new Emp(5,"123");
        Emp emp6 = new Emp(6,"123");
        Emp emp7 = new Emp(7,"123");
        Emp emp8 = new Emp(8,"123");
        Emp emp9 = new Emp(9,"123");

        hashTables.add(emp1);
        hashTables.add(emp2);
        hashTables.add(emp3);
        hashTables.add(emp4);
        hashTables.add(emp5);
        hashTables.add(emp6);
        hashTables.add(emp7);
        hashTables.add(emp8);

        Emp emp = hashTables.findbyID(8);
        System.out.println(emp);

    }
}

class HashTables{
    private int max;
    private EmpLinked[] empLinkeds;

    public HashTables(int max){
        this.max = max;
        empLinkeds = new EmpLinked[max];
        for(int i=0;i<max;i++){
            empLinkeds[i] = new EmpLinked();
        }
    }

    public int hasFun(int id){
        return id%max;
    }

    public void add(Emp emp){
        int id = hasFun(emp.no);
        empLinkeds[id].addEmp(emp);
    }

    public void list(){
        for(int i=0;i<max;i++){
            empLinkeds[i].list();
        }
    }

    public Emp findbyID(int no){
        int id = hasFun(no);
        Emp emp = null;
        try {
            emp = empLinkeds[id].findByID(id);
        } catch (Exception e) {
            e.getMessage();
        }
        return emp;
    }
}

class Emp{
    public int no;
    public String name;
    public Emp next;

    public Emp() {
    }

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinked{
    public Emp head;

    public void addEmp(Emp emp){
        if(head==null){
            head = emp;
            return;
        }

        Emp curEmp = head.next;
        while (true){
           if(curEmp==null){
               curEmp = emp;
               break;
           }
           curEmp = curEmp.next;
        }
    }

    public void list(){
        if(head==null){
            System.out.println("链表为空");
            return;
        }

        Emp temp = head;
        while (true){
            System.out.println(temp);
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
    }

    public Emp findByID(int id){
        if(head==null){
            throw new RuntimeException("链表为空");
        }

        Emp temp = head;
        while (true){
            if(temp.no==id){
                break;
            }
            if(temp.next==null){
                temp = null;
                break;
            }
            temp = temp.next;
        }

        if(temp==null){
            throw new RuntimeException("链表不存在查找的emp");
        }
        return temp;

    }
}
