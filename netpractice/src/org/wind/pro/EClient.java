package org.wind.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.wind.pro.util.SocketIoUtil;

public class EClient {
	
	private int port = 8999;
	private String address = "localhost";
	private Socket socket = null;
	
	public EClient(){
		try {
			socket = new Socket(this.address,this.port);
		} catch (UnknownHostException e) {
			System.out.println("unkown host!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error in initiating client!");
			e.printStackTrace();
		}
	}
	
	public EClient(String address,int port){
		this.address = address;
		this.port = port;
		try {
			socket = new Socket(this.address,this.port);
		} catch (UnknownHostException e) {
			System.out.println("unkown host!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error in initiating client!");
			e.printStackTrace();
		}
	}
	
	public void talkToServer(){
		
		String tempStr = null;
		PrintWriter pw = SocketIoUtil.getWriter(socket);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while((tempStr = br.readLine() )!= null){
				pw.write(tempStr);
			}
		} catch (IOException e) {
			System.out.println("error in inputing client data!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EClient eClient = new EClient();
		eClient.talkToServer();
		System.out.println("Client is created");
	}

}
