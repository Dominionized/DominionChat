package ca.csf.dominionchat;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Client extends Thread{

	private Socket clientSocket;
	private boolean connected;
	private List<ClientObserver> observers;

	public Client() {
		observers = new ArrayList<ClientObserver>();
	}

	public void addObserver(ClientObserver observer) {
		observers.add(observer);
	}

	public void newConnection(String address, int port) throws UnknownHostException, IOException {
		try {
			clientSocket = new Socket(address, port);
			System.out.println("Connected to " + clientSocket.getInetAddress() + ":" + Integer.toString(clientSocket.getPort()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		/*try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	private void pushMessageToObservers(String message){
		for (ClientObserver observer : observers){
			observer.pushMessage(message);
		}
	}
	
	@Override
	public void run(){
		
	}
}
