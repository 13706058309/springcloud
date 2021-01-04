package com.test;

public class GuiBingSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];

        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*800000);
        }

        int[] temp = new int[arr.length];
        long beginTime = System.currentTimeMillis();
        int[] ints = doGuiBing(arr, 0, arr.length - 1, temp);
        long endTime = System.currentTimeMillis();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(endTime-beginTime);
    }

    public static int[] doGuiBing(int[] arr,int left,int right, int[] temp){

        if(left<right){
            int mid = (left+right)/2;
            doGuiBing(arr,left,mid,temp);
            doGuiBing(arr,mid+1,right,temp);
            int[] all = getAll(arr, left, mid, right, temp);
            return all;
        }
        return null;
    }

    public static int[] getAll(int[] arr, int left, int mid, int right, int[] temp){
        int t = 0;
        int l = left;
        int i = mid+1;

        while (l<=mid && i<=right){
            if(arr[l]<=arr[i]){
                temp[t] = arr[l];
                l+=1;
                t+=1;
            }else{
                temp[t] = arr[i];
                t+=1;
                i+=1;
            }
        }

        while (l<=mid){
            temp[t] = arr[l];
            t+=1;
            l+=1;
        }

        while (i<=right){
            temp[t] = arr[i];
            t+=1;
            i+=1;
        }

        t = 0;
        int leftTemp = left;

        while (leftTemp<=right){
            arr[leftTemp] = temp[t];
            t+=1;
            leftTemp+=1;
        }

        return arr;

    }
}
