import javafx.scene.control.Alert;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.Socket;

/**
 * Created by johny on 15.12.15.
 * Response for client from TCP type
 */
public class ClientTCP {
    private String serverHost;
    private int serverPort;

    /**
     * TCP Client constructor
     * @param serverHost host name of server that the client want to connect
     * @param serverPort host port of server that the client want to connect
     */
    public ClientTCP(String serverHost, int serverPort)
    {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    /**
     * Connect TCP Client to some server  and receive some messege from him
     */
    public void connectToServer() {

        Socket clientSock = null;
        InputStreamReader inputInfo = null;
        String allText = ClientGui.connectionInfo.getText();
        StringBuilder newText = new StringBuilder();
        newText.append(allText);
        try {
            clientSock = new Socket(serverHost,serverPort);
            PrintStream outputInfo = new PrintStream(clientSock.getOutputStream());
            inputInfo = new InputStreamReader(clientSock.getInputStream());

            BufferedReader clientBuffer = new BufferedReader(inputInfo);
            String mess = "";
            while ((mess = clientBuffer.readLine()) != null) {
                newText.append(mess+"\n");
            }
        } catch (IOException e) {

        }
        finally {
            try {
                clientSock.close();
                inputInfo.close();
                newText.append("Disconected");
                ClientGui.connectionInfo.setText(newText.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
