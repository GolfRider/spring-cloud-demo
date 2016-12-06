package com.microservices.utils;

import java.net.ServerSocket;

public class CommonUtils {
	
	public static int getFreePort(){
		ServerSocket socket = null;
		int port = -1;
		try{
			socket = new ServerSocket(0);
			socket.setReuseAddress(true);
			port = socket.getLocalPort();			
		 } catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(socket!=null){
				try{
					 socket.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		return port;
	}
}
