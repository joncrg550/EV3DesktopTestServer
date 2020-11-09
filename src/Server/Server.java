package Server;

import java.net.*;

import TestMotors.TestController;

import java.io.*;

public class Server {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream instream = null;
	
	public Server(int port, TestController myController) {
		try {
			server = new ServerSocket(port);
			System.out.println("server starting");
			
			System.out.println("Waiting for client.");
			
			socket = server.accept();
			System.out.println("client connected");
			
			instream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			String nextLine = "";
			
			while(!nextLine.equalsIgnoreCase("done")) {
				try {
					nextLine = instream.readUTF();
					
					switch(nextLine.stripTrailing()) {
					case "forward":
						myController.goForward();
						break;
					case  "backward":
						myController.goBackwards();
						break;
					case "left":
						myController.turnLeft();
						break;
					case  "right":
						myController.turnRight();
						break;
					case  "grab":	
						//#TODO call robot claw grab method
						//unimplemented
						break;
					case  "release":
						//#TODO call robot release method
						//unimplemented
						break;
					case "done":
						System.out.println("Shutting down");
					default: 
						System.out.println("Invalid command");
						
					}
					
				}
				catch(Exception e) {
					if(e.getMessage() != null) {
						System.out.println(e.getMessage());
					}
				}
				
			}
		}
		catch(Exception e) {
			if(e.getMessage() != null) {
				System.out.println(e.getMessage());
			}
		}
	}

}
