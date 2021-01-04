package com.test;

import java.util.ArrayList;
import java.util.List;

//插入查找法
public class InsertSearch {

    public static void main(String[] args) {
        int arr[] = {12,23,34,45,56,56,56,89,100};
//        int i = doInsertSearch(arr, 0, arr.length - 1, 45);
        List<Integer> list = doMoreInsertSearch(arr, 0, arr.length - 1, 56);
        for (Integer integer : list) {
            System.out.println(integer);
        }

//        System.out.println(i);
    }

    public static int doInsertSearch(int[] arr,int left, int right, int target){
        if(left>right||target<arr[left]||target>arr[right]){
            return -1;
        }

        int mid = left+(right-left)*(target-arr[left])/(arr[right]-arr[left]);
        int midValue = arr[mid];

        if(target>midValue){
            return doInsertSearch(arr,mid+1,right,target);
        }else if(target<midValue){
            return doInsertSearch(arr,left,mid-1,target);
        }else{
            return mid;
        }
    }

    public static List<Integer> doMoreInsertSearch(int[] arr, int left, int right, int target){
        if(left>right||target<arr[left]||target>arr[right]){
            return new ArrayList<>();
        }

        int mid = left+(right-left)*(target-arr[left])/(arr[right]-arr[left]);
        int midValue = arr[mid];

        if(target>midValue){

            return doMoreInsertSearch(arr,mid+1,right,target);
        }else if(target<midValue){

            return doMoreInsertSearch(arr,left,mid-1,target);
        }else{

            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp = mid-1;
            while (true){
                if(temp<0||arr[temp]!=midValue){
                    break;
                }
                list.add(temp);
                temp--;
            }

            temp = mid+1;
            while (!(temp>right||arr[temp]!=midValue)){
                list.add(temp);
                temp++;
            }

            return list;
        }
    }

}
