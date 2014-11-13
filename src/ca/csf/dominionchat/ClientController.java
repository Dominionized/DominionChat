package ca.csf.dominionchat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class ClientController {
	
	DominionChatClient client;
	@FXML TextField addressField;
	@FXML TextField portField;
	@FXML Button connectButton;
	@FXML Button sendMessageButton;
	
	public ClientController(){
		client = new DominionChatClient();
	}

	@FXML public void connectToServer() {
		try {
			client.newConnection(addressField.getText(), Integer.parseInt(portField.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
