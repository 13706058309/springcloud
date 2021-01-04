package com.test;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*800000);
        }

        long beginTime = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            doShellSort2(arr);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);

    }
    //希尔排序交互式
    public static void doShellSort(int[] arr){
        int temp = 0;

        for(int gap = arr.length/2;gap>0;gap/=2){
            //每次对半分开
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[gap+j]){
                        temp = arr[j];
                        arr[j] = arr[gap+j];
                        arr[gap+j] = temp;
                    }
                }
            }

        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    public static void doShellSort2(int[] arr){
        int index = 0;
        int valueIndex = 0;
        for(int gap = arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                index = i;
                valueIndex = arr[i];
                if(arr[index]>arr[index-gap]){
                    while (index>=gap&&valueIndex>arr[index-gap]){
                        arr[index] = arr[index-gap];
                        index -= gap;
                    }

                    arr[index] = valueIndex;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
