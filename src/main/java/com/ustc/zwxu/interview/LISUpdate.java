package com.ustc.zwxu.interview;

import java.util.Arrays;
import java.util.Random;

public class LISUpdate {

    public static void main(String[] args){

        System.out.println("Generating a random array...");
        LISUpdate lisUpdate=new LISUpdate();
        int[] oldArray=new int[10];
        oldArray=lisUpdate.randomArray();
        System.out.println(Arrays.toString(oldArray)); //输出生成的随机数组
        System.out.println("each LIS array:"); //输出每次计算时arrayOut数组的内容，便于观察
        System.out.println("LIS length nlogn is:"+lisUpdate.getLength(oldArray)); //输出最长递增子序列的长度
    }

    public int[] randomArray(){ //生成一个10以内的数组，长度为10
        Random random=new Random();
        int[] randomArray=new int[10];
        for (int i = 0; i < 10; i++) {
            randomArray[i]=random.nextInt(10);
        }

        return randomArray;
    }

    public int BinarySearchPosition(int arrayOut[],int left,int right,int key){ //二分查找要替换的位置

        int mid;

        if (arrayOut[right]<key) {
            return right+1;
        }else {
            while(left<right){
                mid=(left+right)/2;
                if (arrayOut[mid]<key) {
                    left=mid+1;
                }else {
                    right=mid;
                }       
            }
                return left;
        }

    }

    public int getLength(int[] arrayIn){ //获取最长递增子序列的长度

        int position;
        int len=1;

        int[] arrayOut=new int[arrayIn.length+1];//arrayOut[0]没有存放数据
        arrayOut[1]=arrayIn[0]; //初始化，长度为1的LIS末尾为arrayIn[0]
        for (int i = 1; i < arrayIn.length; i++) {
            position=BinarySearchPosition(arrayOut, 1, len, arrayIn[i]);
            System.out.println("position is "+position);
            arrayOut[position]=arrayIn[i];
            System.out.println(Arrays.toString(arrayOut));
            if (len<position) {
                len=position;
            }
        }

        return len;
    }

}
