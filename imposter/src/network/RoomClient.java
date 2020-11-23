package network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//user유저 클라이언트
public class RoomClient {
	
	public int port;
	public String ip;
	public String userid;
	public static Socket socket;
	byte[] bytes;
	public String sendMsg;
	public String receiveMsg;


	static void main(String[] args){
		System.out.println("--- server에 연결 요청 중 ---");
		try {
			socket = new Socket("192.168.1.90", 5001);
			System.out.println("클라이언트 --> 서버 : 연결 완료");
			
		} catch (UnknownHostException e) {
			System.out.println("IP notation method error");
		} catch (IOException e) {
			System.out.println("Server Port Error");
		}
	}

}
