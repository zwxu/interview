package com.ustc.zwxu.arithmetic;

import java.util.ArrayList;
public class ActivitySelectDemo {
	//贪心可以自顶向下解决每一个子问题，而不是向动态规划的自底向上方式

    /**
     * //算法导论中活动选择问题动态规划求解
     * @param s 活动的开始时间
     * @param f 活动的结束时间
     * @param n 活动数目
     * @return 最大兼容的活动个数 从底向上
     */
    public static int maxCompatiableActivity(int[] s, int[] f, int n){
        int[][] c = new int[n + 2][n + 2];
        
        for(int j = 0; j <= n+1; j++)
            for(int i = n+1; i >= j; i--)
                c[i][j] = 0;//if i>=j S(i,j)是空集合
        
        int maxTemp = 0;
        for(int j = 1; j <= n+1; j++)
        {
            for(int i = 0; i < j; i++)//i < j
            {
                for(int k = i+1; k < j; k++)// i< k <j
                {
                    if(s[k] >= f[i] && f[k] <= s[j])//S(i,j)不空
                    {
                    	//c[i,j]={max{c[i,k]+c[k,j]+1}}
                        if(c[i][k] + c[k][j] + 1 > maxTemp)
                            maxTemp = c[i][k] + c[k][j] + 1;
                    }
                }//inner for
                c[i][j] = maxTemp;
                maxTemp = 0;
            }//media for
        }//outer for
        return c[0][n+1];
    }
    
    //贪心算法的递归解  从顶向下
    public static ArrayList<Integer> greedyActivitySelection(int[] s, int[] f, int i, int n, ArrayList<Integer> activities){
        //初始调用时 i = 0, 所以a(1)是必选的(注意:活动编号已经按结束时间排序)
        int m = i + 1;
        
        //s[m] < f[i] 下一个活动开始 < 上一个活动结束
        while(m <= n && s[m] < f[i])
            m++;//选择下一个活动
        
        if(m <= n){
            activities.add(m);
            greedyActivitySelection(s, f, m, n, activities);
        }
        return activities;
    }
    
    //贪心算法的非递归解, assume f[] has been sorted and actId 0/n+1 is virtually added  从底向上
    public static ArrayList<Integer> greedyActivitySelection2(int[] s, int[] f, int n, ArrayList<Integer> acitivities){
        //所有真正的活动(不包括 活动0和 活动n+1)中,结束时间最早的那个活动一定是最大兼容活动集合中的 活动.
        int m = 1;
        acitivities.add(m);
        
        for(int actId = 2; actId <= n; actId++){
            if(s[actId] >= f[m])//actId的开始时间在 m 号活动之后.--actId 与 m 没有冲突
            {
                m = actId;
                acitivities.add(m);
            }
        }
        return acitivities;
    }
    
    //for test purpose
    public static void main(String[] args) {
        //添加了 a(0) 和 a(n+1)活动. 其中s(0)=f(0)=0, s(n+1)=f(n+1)=Integer.MAX_VALUE
        int[] s = {0,1,3,0,5,3,5,6,8,8,2,12,Integer.MAX_VALUE};//start time
        int[] f = {0,4,5,6,7,8,9,10,11,12,13,14,Integer.MAX_VALUE};//finish time
        int n = 11;//活动的个数
        int result = maxCompatiableActivity(s, f, n);
        System.out.println("最大兼容活动个数: " + result);
        
        ArrayList<Integer> acts = new ArrayList<Integer>();
        greedyActivitySelection(s, f, 0, n, acts);
        for (Integer activityId : acts)
            System.out.print(activityId + " ");
        
        System.out.println();
        ArrayList<Integer> acts2 = new ArrayList<Integer>();
        greedyActivitySelection2(s, f, n, acts2);
        for (Integer activityId : acts2)
            System.out.print(activityId + " ");
    }
}