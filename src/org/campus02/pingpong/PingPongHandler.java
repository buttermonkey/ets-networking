package org.campus02.pingpong;

import java.io.*;
import java.net.Socket;

public class PingPongHandler {
	private final Socket client;

	public PingPongHandler(Socket client) {
		this.client = client;
	}

	public void process() {
		// business logic
		try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String reply = switch (line) {
					case "PING" -> "PONG";
					case "PONG" -> "PING";
					default -> "ERROR";
				};
				bw.write("--> " + reply + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
