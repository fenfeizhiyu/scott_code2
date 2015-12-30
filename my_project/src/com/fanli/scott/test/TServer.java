package com.fanli.scott.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TServer {

	private static int port=8431;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(port);
		Socket socket=server.accept();
		OutputStream socketOut=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(socketOut,true);
		
	}

}
