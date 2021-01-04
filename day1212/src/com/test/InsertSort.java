package com.test;
//插入排序

import javax.sound.midi.Soundbank;

/**
 * 插入排序（Insertion Sorting）的基本思想是：把 n 个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有 序表中只包含一个元素，无序表中包含有 n-1 个元素，排序过程中每次从无序表中取出第一个元素，
 * 把它的排 序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*800000);
        }

        long beginTime = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            doInsertSort(arr);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }

    public static void doInsertSort(int[] arr){
        int index = 0;
        int insertValue = 0;

        for(int i=1;i<arr.length;i++){
            index = i-1;
            insertValue = arr[i];
            //15  19  13  21
            while (index>=0&&insertValue>arr[index]){
                arr[index+1] = arr[index];
                index--;
            }

            if(index+1!=i){
                arr[index+1] = insertValue;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


}
