package com.test;

import java.sql.SQLOutput;
//冒泡排序法
public class MaoPao {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*800000);
        }

        long beginTime = System.currentTimeMillis();
        maoPao(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }

    public static void maoPao(int[] arrs){
        int temp = 0;
        boolean flag = false;
        for(int i=0;i<arrs.length-1;i++){
            for(int j=0;j<arrs.length-1-i;j++){
                if(arrs[j]<arrs[j+1]){
                    flag = true;
                    temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = temp;
                }
            }
            if(flag){
                flag = !flag;
            }else{
                break;
            }
        }


        for(int i=0;i<arrs.length;i++){
            System.out.println(arrs[i]+"  ");
        }
    }
}
