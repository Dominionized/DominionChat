package ca.csf.dominionchat;

import java.io.IOException;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ClientController implements ClientObserver {

	Client client;
	@FXML
	TextField addressField;
	@FXML
	TextField portField;
	@FXML
	Button connectButton;
	@FXML
	Button sendMessageButton;
	@FXML
	Button disconnectButton;
	@FXML
	TextArea chatArea;

	public ClientController() {
		Platform.setImplicitExit(false);
		client = new Client();
		client.addObserver(this);
	}

	@FXML
	public void connectToServer() {
		try {
			client.start();
			client.newConnection(addressField.getText(), Integer.parseInt(portField.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void disconnectFromServer() {
		try {
			client.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pushMessage(String message) {
		chatArea.setText(message);
	}
}
