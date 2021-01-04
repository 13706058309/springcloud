package com.test;
//递归解决8皇后问题
public class DiGui {
    private static int max = 8;
    private static int count = 0;
    private static int judge = 0;
    private static int[] arr = new int[max];

    public static void main(String[] args) {
        check(0);
        System.out.println("总次数"+count);
        System.out.println("测试次数"+judge);
    }

    private static void check(int n){
        if(n==max){
            print();
            return;
        }

        for(int i=0;i<max;i++){
            arr[n] = i;
            if(judges(n)){
                check(n+1);
            }
        }
    }

    private static boolean judges(int n){
        judge++;
        for(int i=0;i<n;i++){
            if(arr[i]==arr[n]||Math.abs(i-n)==Math.abs((arr[i]-arr[n]))){
                return false;
            }
        }
        return true;
    }

    private static void print(){
        count++;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
