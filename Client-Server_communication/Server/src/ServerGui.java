import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by johny on 15.12.15.
 * Create GUI of server application
 */
public class ServerGui extends Application {

    public int clientCounter = 0;
    private Stage window;
    private Button start;
    private TextField port;
    private Label portlb;
    public static Label ifStarted;
    public static TextArea connectionInfo;
    private Button stop;
    private boolean serverRun = false;
    ServerSocket serverForCom;
    DatagramSocket udpServer = null;
    ChoiceBox<String> serverType;
    Thread thread = null;

    boolean isAllgood = false;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Create and work with windows and components of server application
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ServerTCP Application");
        window.setOnCloseRequest(e -> stopButtonPressed());
        start = new Button();
        start.setText("start server");

        start.setOnAction(e -> startButtonPressed());
        port = new TextField();
        portlb = new Label("port:");

        ifStarted = new Label();

        serverType = new ChoiceBox<>();
        serverType.getItems().addAll("TCP","UDP");
        serverType.setValue("TCP");

        connectionInfo = new TextArea();



        stop = new Button();
        stop.setText("stop server");
        stop.setDisable(true);
        stop.setPadding(new Insets(20, 20, 20, 20));
        stop.setOnAction(e -> stopButtonPressed());

        VBox mainTemplate = new VBox();

        HBox firstRow = new HBox();
        firstRow.getChildren().addAll(start, portlb, port, ifStarted, serverType);
        firstRow.setSpacing(20);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(20, 20, 20, 20));

        mainTemplate.getChildren().addAll(firstRow, connectionInfo, stop);
        mainTemplate.setAlignment(Pos.CENTER);

        Scene mainScene = new Scene(mainTemplate, 600, 300);

        window.setScene(mainScene);
        window.show();

    }

    private void stopButtonPressed() {
        if(ifStarted.getText().equals("ServerTCP started")) {
            connectionInfo.setText("ServerTCP Stoped");
            serverRun = false;
            try {
                serverForCom.close();
                window.close();
            } catch (IOException e) {

            }
        }
        else if(ifStarted.getText().equals("ServerUDP started"))
        {
            System.exit(0);
        }
        else {
            System.exit(0);
        }
    }

    private void startButtonPressed() {

        try {
            int validPort = Integer.parseInt(port.getText());
            if (validPort > 9999 || validPort < 0) {
                throw new Exception();
            }
            String selectedServerType = serverType.getValue();
            if(selectedServerType.equals("TCP")) {
                ifStarted.setText("ServerTCP started");

                start.setDisable(true);
                stop.setDisable(false);
                connectionInfo.clear();
                serverForCom = new ServerSocket(validPort);
                thread = new Thread() {
                    public void run() {
                        try {
                            while (ifStarted.getText().equals("ServerTCP started")) {
                                Socket sock = serverForCom.accept();
                                clientCounter++;
                                ServerTCP someNewClient = new ServerTCP(sock, clientCounter);
                                someNewClient.newClient();
                            }
                        } catch (IOException e1) {
                            connectionInfo.setText("ServerTCP Stoped");
                        }
                    }
                };
            }
            else{
                ifStarted.setText("ServerUDP started");
                start.setDisable(true);
                stop.setDisable(false);
                connectionInfo.clear();


                try {
                    udpServer = new DatagramSocket(validPort);
                    byte[] buffer = new byte[65536];
                    DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

                    ifStarted.setText("ServerUDP started");
                    thread = new Thread() {
                        public void run() {
                            while (ifStarted.getText().equals("ServerUDP started")) {
                                clientCounter++;
                                if(!udpServer.isClosed()) {
                                    ServerUDP someNewClient = new ServerUDP(udpServer, clientCounter, incoming);
                                    someNewClient.newClient();
                                }
                            }
                        }
                    };

                }catch (Exception e)
                {

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            connectionInfo.setText("Unvalid port");
        } ;

        try {
            thread.start();
        }
        catch (Exception e)
        {

        }
    }
}