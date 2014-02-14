package org.wind.pro.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketIOUtil {

	public static PrintWriter getWriter(Socket socket){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(socket.getOutputStream(), false);
		} catch (IOException e) {
			System.out.println("error in getting io writer!");
			e.printStackTrace();
		}
		return pw;
	}
	
	public static BufferedReader getReader(Socket socket){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.out.println("error in getting io reader!");
			e.printStackTrace();
		}
		return br;
	}

}
