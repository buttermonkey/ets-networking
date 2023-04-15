package org.campus02.pingpong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {
	public static void main(String[] args) {
		// create server
		try (ServerSocket serverSocket = new ServerSocket(1111)) {
			// server should run forever
			while (true) {
				System.out.println("Waiting for client to connect...");
				try (Socket client = serverSocket.accept()) {
					// business logic
					PingPongHandler pingPongHandler = new PingPongHandler(client);
					pingPongHandler.process();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
