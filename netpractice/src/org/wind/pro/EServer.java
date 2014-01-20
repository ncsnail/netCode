package org.wind.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.wind.pro.util.SocketIoUtil;

public class EServer {
	
	
	private int port = 8999;
	private ServerSocket serverSocket;
	
	public EServer(){
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("error in initiating server!");
			e.printStackTrace();
		}
	}
	
	public void service(){
		
		String msg = null;
		Socket socket = null;
		
		while(true){
			try{
				socket = serverSocket.accept();
				System.out.println("New connection accepted:"+socket.getInetAddress()+":"+socket.getPort());
				BufferedReader bf = SocketIoUtil.getReader(socket);
				while((msg = bf.readLine()) != null){
					System.out.println(msg);
					if("bye".equals(msg)){
						break;
					}
				}
			}catch(Exception e){
				System.out.println("error in communicating with clients!");
				e.printStackTrace();
			}finally{
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						System.out.println("error in closing socket!");
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EServer eServer = new EServer();
		System.out.println("EServer is created!");
	}

}
