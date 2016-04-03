import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.*;

/**
 * Created by johny on 16.12.15.
 * Response for client from UDP type
 */
public class ClientUDP {
    private String serverHost;
    private int serverPort;
    public boolean serverClosed = false;

    /**
     * UDP Client constructor
     * @param serverHost host name of server that the client want to connect
     * @param serverPort host port of server that the client want to connect
     */
    public ClientUDP(String serverHost, int serverPort)
    {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    /**
     * Connect UDP Client to some server and receive some messege from him
     */
    public void connectToServer() {

        DatagramSocket sock = null;
        InetAddress host;
        String infoToReceive;
        String allText = ClientGui.connectionInfo.getText();
        StringBuilder newText = new StringBuilder();
        newText.append(allText);
        String empty = "";
        DatagramPacket  dp = null;
        DatagramPacket reply = null;
        byte[] b = empty.getBytes();

        try {
            sock = new DatagramSocket();
            host = InetAddress.getByName(serverHost);
            dp = new DatagramPacket(b,b.length,host , serverPort);
            sock.send(dp);
            byte[] buffer = new byte[65536];
            reply = new DatagramPacket(buffer, buffer.length);
            boolean continueSending = true;

            sock.setSoTimeout(1000);
            sock.receive(reply);

            byte[] data = reply.getData();
            infoToReceive = new String(data, 0, reply.getLength());

            newText.append(infoToReceive + "\n");

        } catch (SocketException se) {
            serverClosed = true;
        } catch (IOException ioe) {
            serverClosed = true;
        } catch (Exception e)
        {
            serverClosed = true;
        }
        finally
        {
            if(serverClosed) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not connected");
                alert.setContentText("The server was not found!");
                alert.showAndWait();
            }
            else {
                newText.append("Disconected");
                ClientGui.connectionInfo.setText(newText.toString());
            }
            sock.close();
        }
    }
}
