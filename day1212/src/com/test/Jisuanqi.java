package com.test;

import java.util.Stack;

public class Jisuanqi {

    public static void main(String[] args) {
        Stack<Object> numStack = new Stack<>();
        Stack<Object> operaStack = new Stack<>();

        String expression = "5*6+18*9-18";
        int index = 0;
        char ch = ' ';
        char opera = ' ';
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        String key = "";

        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if(judgeNum(ch)){
                if(operaStack.isEmpty()){
                    operaStack.push(ch);
                }else{
                    char peek = (char) operaStack.peek();
                    if(getPro(ch)<=getPro(peek)){
                        num1 = (int) numStack.pop();
                        num2 = (int) numStack.pop();
                        opera = (char) operaStack.pop();
                        res = jisuan(num1,num2,opera);
                        numStack.push(res);
                        operaStack.push(ch);
                    }else{
                        operaStack.push(ch);
                    }
                }
            }else{
                key+=ch;
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(key));
                    break;
                }
                if(judgeNum(expression.substring(index+1,index+2).charAt(0))){
                    numStack.push(Integer.parseInt(key));
                    key = "";
                }
            }

            index++;
            if(index>=expression.length()){
                break;
            }
        }

        while (true){
            if(operaStack.isEmpty()){
                break;
            }

            num1 = (int) numStack.pop();
            num2 = (int) numStack.pop();
            opera = (char) operaStack.pop();
            res = jisuan(num1,num2,opera);
            numStack.push(res);
        }

        System.out.println(numStack.pop());

    }
    //判断运算符优先级
    public static int getPro(char ch){
        if(ch=='*'||ch=='/'){
            return 1;
        }

        if(ch=='+'||ch=='-'){
            return 0;
        }

        return -1;
    }

    //判断是否为数字
    public static boolean judgeNum(char ch){
        return '*'==ch||'-'==ch||'+'==ch||'/'==ch;
    }

    //计算
    public static int jisuan(int num1,int num2,char ch){
        int res = 0;
        switch (ch){
            case '-':
                res = num2-num1;
                break;
            case '+':
                res = num1+num2;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }
}


