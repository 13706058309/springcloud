package com.test;

import java.util.ArrayList;
import java.util.List;
//二分查找法
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,23,45,55,77,88,100,100,100,101};
        List<Integer> integers = doBinarySearch2(arr, 0, arr.length - 1, 100);
        System.out.println(integers.size());
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    //二分法不找重复的
    public static int doBinarySearch(int[] arr,int left, int right,int findValue){

        if(left>right){
            return -1;
        }

        int mid = (left+right)/2;
        int midValue = arr[mid];

        if(midValue>findValue){
            return doBinarySearch(arr,left,mid-1,findValue);
        }else if(midValue<findValue){
            return doBinarySearch(arr,mid+1,right,findValue);
        }else{
            return mid;
        }
    }

    //二分法查找重复的
    public static List<Integer> doBinarySearch2(int[] arr, int left, int right, int findValue){
        if(left>right){
            new ArrayList<Integer>();
        }

        int mid = (left+right)/2;
        int midValue = arr[mid];

        if(midValue>findValue){
            return doBinarySearch2(arr,left,mid-1,findValue);
        }else if(midValue<findValue){
            return doBinarySearch2(arr,mid+1,right,findValue);
        }else{
            List<Integer> list = new ArrayList<>();
            int temp = mid-1;
            while (true){
                if(temp<0||arr[temp]!=findValue){
                    break;
                }
                list.add(temp);
                temp--;
            }

            list.add(mid);

            temp = mid+1;

            while (true){
                if(temp>right||arr[temp]!=findValue){
                    break;
                }
                list.add(temp);
                temp++;
            }

            return list;

        }
    }
}
