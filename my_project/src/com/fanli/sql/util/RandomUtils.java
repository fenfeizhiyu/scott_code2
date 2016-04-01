package com.fanli.sql.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtils {
    
    
    private static char[] ch=new char[]{'a','b','c','d','e','f','g','h','i'};
    /**
     * 获取一个指定范围内的随机整数
     */
     public static int getRandNumber(int start,int end){
	 if(end<=start) return 0;
	 else
	    return start+(int)Math.round((end-start)*Math.random());
     }
   
    
    
     /**
      * r 1-10
      * @return
      */
     public static boolean getBoolean(int r){
	 return getRandNumber(1,10)<r;
     }
     
    /**
     *获取指定长度的随机数
     * @param args
     */
    public static String getRandNumStr(int length){
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<length;i++){
	    sb.append(getRandNumber(0,9));
	}
	return sb.toString();
    }
    
     /**
      * true daxiei
      * 获取指定长度的随机字母
      * @return
      */
    public static String getRandLetterStr(int length,boolean type){
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<length;i++){
	    if(type)
	    sb.append(getAletter(1));
	    else
	    sb.append(getAletter(2));
	}
	return sb.toString();
    }
    
    /**
     * 1 大写   2小写 3混合
     * @param type
     * @return
     */
    public static char  getAletter(int type){
	if(type==1)
	    return (char)getRandNumber(65,90);
	else if(type==2)
	   return  (char)getRandNumber(97,122);
	else{
	   if(getBoolean(5))
	      return getAletter(1);
	   else
	      return getAletter(2);
	}
    }
    
    
    /**
     * 创建递增的数字
     * @return
     */
    public static int[] getlongNums(int min,int range,int length){
	int[] nums=new int[length];
	nums[0]=getRandNumber(min,min+range);
	for(int i=1;i<length;i++){
	   nums[i]=getRandNumber(nums[i-1],nums[i-1]+range);
	}
	return nums;
    }
    
    /**
     * before now
     * @return
     */
    private static long getRandTime(boolean before,long time){
	int s=getRandNumber(360000,360000*24*10);
	if(before)
	    return time-s;
	else
	    return time+s;
	//
    }
    
    public static String getRandDate(boolean before){
	Date d=new Date();
	d.setTime(getRandTime(before,d.getTime()));
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf.format(d);
    }
   
    
    
    /**
     * 创建递增或递减时间
     * @param before
     * @return
     */
    public static String[] getRandDates(boolean before,int length){
	String[] strs=new String[length];
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	for(int i=0;i<length;i++){
	    d.setTime(getRandTime(before,d.getTime()));
	    strs[i]=sdf.format(d);
	}
	return strs;
    }
    
    
    
    
    public static void main(String[] args) {
	String[] strs=getRandDates(false,10);
	for(int i=0;i<10;i++)
	 System.out.println(strs[i]);
	
    }

}
