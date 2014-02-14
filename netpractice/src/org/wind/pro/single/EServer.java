package org.wind.pro.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.wind.pro.util.SocketIOUtil;

public class EServer {
	
	
	private int port = 8999;
	private ServerSocket serverSocket;
	
	public EServer(){
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("The server is starting");
		} catch (IOException e) {
			System.out.println("error in initiating server!");
			e.printStackTrace();
		}
	}
	
	public void service(){
		
		Socket socket = null;
		
		while(true){
			try {
				socket = serverSocket.accept();
				System.out.println("New connection accepted:"+socket.getInetAddress()+":"+socket.getPort());
				Thread t1 = new Thread(new Handler(socket));
				t1.run();
			} catch (IOException e) {
				System.out.println("error in accepting the connection from client");
				e.printStackTrace();
			}
		}
	}
	
	class Handler implements Runnable{
		private Socket socket;
		
		public Handler(Socket socket){
			this.socket =  socket;
		}
		
		public void run() {
			
			String msg = null;
			try{
				BufferedReader bf = SocketIOUtil.getReader(socket);
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
	
	public static void main(String[] args) {
		EServer server= new EServer();
		server.service();
		System.out.println("The Server is ready!");
	}
	

}
