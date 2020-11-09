package Main;
import java.net.*;

import TestMotors.TestController;
import Server.Server;

import java.io.*;


public class Main {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestController myController = new TestController();
		Server theRobotsServer = new Server(5000, myController);
	}

}
