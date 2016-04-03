import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * Created by johny on 16.12.15.
 * Response for Server of TCP type
 */
public class ServerUDP {

    private DatagramSocket dataSocket;
    private int clientCounter;
    private DatagramPacket incoming;

    /**
     * Constructor of UDP Server
     * @param dataSocket Server from which wait to receive information
     * @param clientCounter number of current client
     * @param incoming the message that want to receive from server
     */
    public ServerUDP(DatagramSocket dataSocket, int clientCounter, DatagramPacket incoming)
    {
        this.dataSocket = dataSocket;
        this.clientCounter = clientCounter;
        this.incoming = incoming;

        try {
            if(!dataSocket.isClosed()) {
                this.dataSocket.receive(incoming);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newClient(){
        try {
            Date now = new Date();
            //send information to client
            String infoToSend= "Hello " + now + "\nYou are client number " + clientCounter;
            DatagramPacket sendMessage = new DatagramPacket(infoToSend.getBytes(), infoToSend.getBytes().length, incoming.getAddress() , incoming.getPort());
            dataSocket.send(sendMessage);

            String oldInfo = ServerGui.connectionInfo.getText();
            String newInfo = "The client number " + clientCounter + " is connected\nThe message to " + clientCounter + " was send\n===========================================\n";
            ServerGui.connectionInfo.setText(oldInfo + newInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
