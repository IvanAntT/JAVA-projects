import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by johny on 15.12.15.
 * Create GUI of client application
 */
public class ClientGui extends Application{

    private TextField servPort;
    private TextField servHost;
    public static TextArea connectionInfo;
    private Button connect;
    private ChoiceBox<String> clientType;


    public static void main(String[] args) {
        launch(args);
    }

    //Create and work with windows and components of client application
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("ClientTCP Application");


        Label servPortlb = new Label("Server port: ");
        Label servHostlb = new Label("Server host: ");

        servPort = new TextField();
        servHost = new TextField();

        connect = new Button("Connect to server");
        connect.setOnAction(e -> connectPressed());

        HBox mainLayout = new HBox();

        HBox firstRow = new HBox();
        firstRow.getChildren().addAll(servPortlb, servPort);

        HBox secRow = new HBox();
        secRow.getChildren().addAll(servHostlb, servHost);

        VBox firstPart = new VBox();
        firstPart.getChildren().addAll(firstRow, secRow);
        firstPart.setSpacing(20);
        firstPart.setPadding(new Insets(20, 20, 20, 20));

        connect.setPadding(new Insets(20, 20, 20, 20));

        clientType = new ChoiceBox<>();
        clientType.getItems().addAll("TCP", "UDP");
        clientType.setValue("TCP");

        mainLayout.getChildren().addAll(firstPart,clientType, connect);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setSpacing(20);

        Scene mainScene = new Scene(mainLayout, 600 , 100);

        window.setScene(mainScene);
        window.show();
    }

    /*
     * Function when connect button is pressed
     */
    private void connectPressed() {
        String serverHost = servHost.getText();
        String servePort = servPort.getText();

        try {
            int validPort = Integer.parseInt(servePort);
            if(validPort > 9999 || validPort < 0)
            {
                throw new Exception();
            }

            if(clientType.getValue().equals("TCP")) {
                ClientTCP someClient = new ClientTCP(serverHost, validPort);

                Stage newWindow = new Stage();
                BorderPane mainNewWindow = new BorderPane();
                connectionInfo = new TextArea();
                mainNewWindow.setCenter(connectionInfo);
                Scene mainSecScene = new Scene(mainNewWindow, 300, 300);
                someClient.connectToServer();
                newWindow.setScene(mainSecScene);
                newWindow.setTitle("New ClientTCP Connected");
                newWindow.show();
            }
            else {
                ClientUDP someClient = new ClientUDP(serverHost, validPort);
                connectionInfo = new TextArea();
                someClient.connectToServer();

                if(someClient.serverClosed == false) {
                    Stage newWindow = new Stage();
                    BorderPane mainNewWindow = new BorderPane();
                    mainNewWindow.setCenter(connectionInfo);
                    Scene mainSecScene = new Scene(mainNewWindow, 300, 300);
                    newWindow.setScene(mainSecScene);
                    newWindow.setTitle("New ClientUDP Connected");
                    newWindow.show();
                }
            }
        }catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not connected");
            alert.setContentText("Invalid server information!");
            alert.showAndWait();
        }


    }
}
