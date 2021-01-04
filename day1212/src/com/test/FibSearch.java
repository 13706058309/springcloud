package com.test;

public class FibSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {

    }

    public static int[] getFib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<f.length;i++){
            f[i] = f[i-1]+ f[i-2];
        }

        return f;
    }
}
