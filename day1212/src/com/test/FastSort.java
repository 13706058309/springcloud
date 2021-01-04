package com.test;

public class FastSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*800000);
        }

        long beginTime = System.currentTimeMillis();
        int[] ints = doFastSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(endTime-beginTime);
    }

    public static int[] doFastSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int temp = 0;

        int mindValue = arr[(left+right)/2];

        while (l<r){

            while (arr[l]>mindValue){
                l++;
            }

            while (arr[r]<mindValue){
                r--;
            }

            if(l>=r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l]==mindValue){
                r--;
            }
            if(arr[r]==mindValue){
                l++;
            }
        }

        if(l==r){
            l++;
            r--;
        }

        if(left<r){
            doFastSort(arr,left,r);
        }

        if(right>l){
            doFastSort(arr,l,right);
        }

        return arr;
    }
}
