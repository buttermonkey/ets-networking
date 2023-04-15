package org.campus02.pingpong;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongClient {
	public static void main(String[] args) {
		try (Socket server = new Socket("localhost", 1111);
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
			 BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			 BufferedReader cli = new BufferedReader(new InputStreamReader(System.in))) {
			String msg;
			while ((msg = cli.readLine()) != null && !"EXIT".equals(msg)) {
				bw.write(msg + "\n");
				bw.flush();
				String reply = br.readLine();
				System.out.println(reply);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
