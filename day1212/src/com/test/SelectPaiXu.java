package com.test;
//选择排序法
public class SelectPaiXu {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*800000);
        }
        long beginTime = System.currentTimeMillis();
        paixu(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }

    public static void paixu(int[] arrs){
        int index = 0;
        int minValue = 0;
        for(int i=0;i<arrs.length-1;i++){
            index = i;
            minValue = arrs[i];

            for(int j=i+1;j<arrs.length;j++){
                if(arrs[j]<minValue){
                    minValue = arrs[j];
                    index = j;
                }
            }

            if(index != i){
                arrs[index] = arrs[i];
                arrs[i] = minValue;
            }
        }

        for(int i=0;i<arrs.length;i++){
            System.out.println(i);
        }

    }
}
