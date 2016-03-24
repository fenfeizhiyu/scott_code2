package com.fanli.test;

import java.util.Scanner;

public class ScanWork implements Runnable{

    public static Scanner scanner=null;
    public static String curr_line=null;
    @Override
    public void run() {
	if(scanner==null){
	    scanner=new Scanner(System.in);
	}
	if(Context.console_sign==1){
	    System.out.println("输入命令:");
	    curr_line=scanner.nextLine();
	}
    }

}
