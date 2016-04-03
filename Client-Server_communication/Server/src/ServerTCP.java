import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by johny on 15.12.15.
 * Response for Server of TCP type
 */
public class ServerTCP {
        private Socket sock = null;
        private InputStreamReader inputInfo = null;
        private BufferedReader buffer = null;
        private PrintStream outputInfo = null;
        public int clientCounter;

        /**
         * Constructor of TCP Server
         * @param sock socket of server which show connection of new client
         * @param clientCounter number of client
         */
        public ServerTCP(Socket sock, int clientCounter)
        {
            this.sock = sock;
            this.clientCounter = clientCounter;
        }

        /**
         * Function that receive new client and send information to him
         * and print some message to text area of Server GUI
         */
        public void newClient() {
                try {
                        inputInfo = new InputStreamReader(sock.getInputStream());
                        buffer = new BufferedReader(inputInfo);
                        outputInfo = new PrintStream(sock.getOutputStream());

                        //send information to client
                        Date now = new Date();
                        outputInfo.println("Hello " + now);
                        outputInfo.println("You are client number " + clientCounter);
                        outputInfo.flush();

                        String oldInfo = ServerGui.connectionInfo.getText();
                        String newInfo = "The client number " + clientCounter + " is connected\nThe message to " + clientCounter + " was send\n===========================================\n";
                        ServerGui.connectionInfo.setText(oldInfo + newInfo);

                        outputInfo.close();
                        sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}
