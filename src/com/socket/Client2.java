package com.socket;

/**
 * TODO: SOCKET CLIENT TASK2 (SEND CSV TO DATABASE)
 * @author zulkarnaen
 */

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client2 {

	private static SocketAddress address;
	private static Socket socket;
	private static ObjectOutputStream out;
	private static File myFile;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "127.0.0.1";
		int port = 5555;

		address = new InetSocketAddress(ip, port);
		socket = new Socket();
		try {
			socket.connect(address);
			System.out.println("------->Berhasil Terhubung ke Client!<-------\n");
			System.out.println("============= WELCOME TO CLIENT =============\n");
			out = new ObjectOutputStream(socket.getOutputStream());

			String msgFile 	= "D:/zTesting_Socket/zClient/Task2.csv";
			myFile = new File(msgFile);

			System.out.println("=============================================");
			System.out.println("--------->Asal Path	: " + myFile.getAbsolutePath());
			System.out.println("---------------------------------------------");
			System.out.println("--------->length	: " + myFile.length());
			System.out.println("---------------------------------------------\n");

			out.writeObject(myFile);

			System.out.println("=============== INFO DATABASE ===============");
			// TODO: Manipulasi untuk Insert ke DB
			SendCSVtoDatabase.readCsv();
			SendCSVtoDatabase.readCsvUsingLoad();
			System.out.println("---------- Data Berhasil di Upload ----------");
			System.out.println("=============================================\n");

			out.close();
			socket.close();
			System.out.println("-------------->Socket ditutup <--------------\n");
			System.out.println("*beberapa saat lagi console akan redirect ke server");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
