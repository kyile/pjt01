package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class RoomServer {
	static ServerSocket room;
	static byte[] bytes;
	static String receiveMsg;
	static String sendMsg;
	static OutputStream outs;
	static InputStream ins;
	static int roomNum;
	
	
	RoomServer(int roomNum){
		
	}
	
	//  server 정보
	// msg 보내기
	// msg 받기
	
	//server 방 생성하기
	//roomManager
	static void main(String[] args){
		
		try {
			room = new ServerSocket(5001);//방이 생성될 때마다 포트번호가 바뀜 
			
			while(true) {
				System.out.println(" --- 서버 연결중 --- ");
				Socket client = room.accept();//5001번 client가 들어오길 기다림
				System.out.println(client+"user1 들어옴");
				InetSocketAddress user = (InetSocketAddress)client.getRemoteSocketAddress();//연결된 clientIP 정보
				bytes = new byte[100];
				ins = client.getInputStream();//데이터 받기(들어옴)
				int readByte = ins.read(bytes);
				receiveMsg = new String(bytes,0,readByte,"UTF-8"); 
				System.out.println("서버 --> 클라이언트 : 연결 완료");
				System.out.println(client+":"+receiveMsg);//client
				ins.close();
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("encoding type error");
		} catch(UnknownHostException e) {
			System.out.println("IP notation method error");
		}catch (IOException e) {
			System.out.println();
			System.out.println("Server Port Error");
		
		} 
	}
}
