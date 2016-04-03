package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.*;
import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Realize functionality and logic of FX Calculator
 */
public class Main extends Application {

    private Stage window;
    private String firstNumber = "";
    private String secondNumber = "";
    private String operation = "";
    TextField input;
    boolean isFirstNumberPressed = false;
    Button dot;
    private boolean exprOver = false;
    private Scene calcScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Calculator");
        window.setOnCloseRequest(e -> {
            e.consume();
            exitFilePressed();
        });


        VBox calcLayout = new VBox();
        calcLayout.setPadding(new Insets(10,10,10,10));
        calcScene = new Scene(calcLayout, 600, 600);

        //Main menu
        MenuBar calcMenu = new MenuBar();

        Menu fileMenu = new Menu("_File");
        MenuItem openFile = new MenuItem("Open");
        openFile.setOnAction(e -> openFilePressed());
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setOnAction(e -> saveFilePressed());
        MenuItem line = new SeparatorMenuItem();
        MenuItem exitFile = new MenuItem("Exit");
        exitFile.setOnAction(e -> exitFilePressed());
        fileMenu.getItems().addAll(openFile,saveFile,line, exitFile);

        Menu styleMenu = new Menu("_Styles");
        MenuItem normal = new MenuItem("Normal design");
        MenuItem red = new MenuItem("Red design");
        red.setOnAction(e-> calcScene.getStylesheets().add(getClass().getResource("CalculatorRedStyle.css").toExternalForm()));
        MenuItem black = new MenuItem("Green design");
        black.setOnAction( e -> calcScene.getStylesheets().add(getClass().getResource("CalclulatorGreenStyle.css").toExternalForm()));
        styleMenu.getItems().addAll(normal, red, black);

        Menu helpMenu = new Menu("_Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> aboutPressed());
        helpMenu.getItems().add(about);

        calcMenu.getMenus().addAll(fileMenu, styleMenu, helpMenu);

        //for insert numbers
        input=new TextField();
        input.setEditable(false);
        input.setPrefColumnCount(20);
        input.setPrefHeight(100);
        input.setFont(new Font("Verdana", 40));

        //for numbers
        GridPane gridWithNumbers = new GridPane();
        gridWithNumbers.setHgap(10);
        gridWithNumbers.setVgap(10);
        gridWithNumbers.setPadding(new Insets(10, 0, 0, 0));

        Button num0 = new Button("0");
        num0.setOnAction(e -> pressedNumberButton(0));
        num0.setId("zero");
        Button num1 = new Button("1");
        num1.setOnAction(e -> pressedNumberButton(1));
        Button num2 = new Button("2");
        num2.setOnAction(e -> pressedNumberButton(2));
        Button num3 = new Button("3");
        num3.setOnAction(e -> pressedNumberButton(3));
        Button num4 = new Button("4");
        num4.setOnAction(e -> pressedNumberButton(4));
        Button num5 = new Button("5");
        num5.setOnAction(e -> pressedNumberButton(5));
        Button num6 = new Button("6");
        num6.setOnAction(e -> pressedNumberButton(6));
        Button num7 = new Button("7");
        num7.setOnAction(e -> pressedNumberButton(7));
        Button num8 = new Button("8");
        num8.setOnAction(e -> pressedNumberButton(8));
        Button num9 = new Button("9");
        num9.setOnAction(e -> pressedNumberButton(9));

        dot = new Button(".");
        dot.setOnAction(e -> dotPressed());

        Button result = new Button("=");
        result.setOnAction(e -> resultPressed());
        result.setId("result");

        Button negat = new Button("+/-");
        negat.setOnAction(e -> negatPressed());

        Button plus = new Button("+");
        plus.setOnAction(e -> operation = "+");

        Button minus = new Button("-");
        minus.setOnAction(e -> operation = "-");

        Button multy = new Button("X");
        multy.setOnAction(e -> operation = "X");

        Button div = new Button("/");
        div.setOnAction(e -> operation = "/");

        Button clear = new Button("C");
        clear.setOnAction(e -> {input.clear();
                                dot.setDisable(false);});

        Button back = new Button("<-");
        back.setOnAction(e -> back());

        Button sqrt = new Button("sqrt");
        sqrt.setOnAction(e -> sqrtPresed());

        Button sin = new Button("sinx");
        sin.setOnAction(e -> sinxPressed());

        Button cos = new Button("cosx");
        cos.setOnAction(e -> cosxPressed());

        Button fact = new Button("x!");
        fact.setOnAction(e -> factorialPressed());

        Button pow = new Button("x^y");
        pow.setOnAction(e -> operation = "x^y");



        gridWithNumbers.add(clear, 0, 0);
        gridWithNumbers.add(back, 1 , 0);
        gridWithNumbers.add(multy, 2 , 0);
        gridWithNumbers.add(div, 3 , 0);
        gridWithNumbers.add(sqrt, 4 , 0);

        gridWithNumbers.add(num7, 0 , 1);
        gridWithNumbers.add(num8, 1 , 1);
        gridWithNumbers.add(num9, 2 , 1);
        gridWithNumbers.add(minus, 3 , 1);
        gridWithNumbers.add(sin, 4 , 1);

        gridWithNumbers.add(num4, 0 , 2);
        gridWithNumbers.add(num5, 1 , 2);
        gridWithNumbers.add(num6, 2 , 2);
        gridWithNumbers.add(plus, 3 , 2);
        gridWithNumbers.add(cos, 4 , 2);

        gridWithNumbers.add(num1, 0 , 3);
        gridWithNumbers.add(num2, 1 , 3);
        gridWithNumbers.add(num3, 2 , 3);
        gridWithNumbers.add(result, 3 , 3, 1, 2);
        gridWithNumbers.add(fact, 4 , 3);

        gridWithNumbers.add(num0, 0 , 4);
        gridWithNumbers.add(dot, 1, 4);
        gridWithNumbers.add(negat, 2 , 4);
        gridWithNumbers.add(pow, 4, 4);

        calcLayout.getChildren().addAll(calcMenu, input, gridWithNumbers);



        calcScene.getStylesheets().add(getClass().getResource("CalculatorNormalStyle.css").toExternalForm());
        window.setScene(calcScene);
        window.setResizable(false);
        window.show();

    }

    private void exitFilePressed() {
        Stage askRequest = new Stage();

        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(15, 15, 15, 15));
        Label ask = new Label();
        ask.setText("Are you sure to want exit from calculator?");
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(15,15,15,15));
        buttons.setSpacing(15);
        Button yesBut = new Button("Yes");
        Button noBut = new Button("No");

        buttons.getChildren().addAll(yesBut, noBut);
        mainLayout.getChildren().addAll(ask, buttons);

        yesBut.setOnAction(e -> {
            askRequest.close();
            window.close();
        });

        noBut.setOnAction(e -> {
            askRequest.close();
        });

        Scene askScene = new Scene(mainLayout);
        askRequest.setScene(askScene);
        askRequest.showAndWait();

    }

    private void saveFilePressed() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(window);

        if(file != null){
            SaveFile(input.getText(), file);
        }
    }


    /**
     * Function which take information and file and create file
     * and save information into him
     * @param numberInformation
     * @param file
     */
    private void SaveFile(String numberInformation, File file) {
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(numberInformation);
            fileWriter.close();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Write to file Error");
            alert.setContentText("Something is wrong!");
            alert.showAndWait();
        }
    }

    private void openFilePressed() {
        Stage mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            if(selectedFile.canRead())
            {
                try{
                    Reader reader = new FileReader(selectedFile.getAbsoluteFile());
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line = bufferedReader.readLine();
                    Integer intLine = Integer.parseInt(line);
                    input.setText(line);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e)
                {
                    input.clear();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Read from file Error");
                    alert.setHeaderText("Unvalid number");
                    alert.setContentText("Please chose file with integer information!");
                    alert.showAndWait();
                }
            }
        }
    }

    private void aboutPressed() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Calculator information");
        window.setMinWidth(350);
        window.setMaxHeight(500);

        Label createdBy = new Label();
        createdBy.setText("This calculator is created by \nJohny Todorov with Intellij IDEA");
        createdBy.setPadding(new Insets(10, 10, 10, 10));
        createdBy.setFont(new Font("Arial", 30));

        Label nameOfCalc = new Label();
        nameOfCalc.setText("TJS Calculator");
        nameOfCalc.setFont(new Font("Arial", 50));


        ImageView calcImage = new ImageView();
        calcImage.setImage(new Image(getClass().getResourceAsStream("/abcalc.jpg")));

        Button closeBut = new Button("Close");
        closeBut.setOnAction(e -> window.close());
        closeBut.setPadding(new Insets(10, 10, 10, 10));

        BorderPane layoutOfAbout = new BorderPane();

        //add image
        layoutOfAbout.setLeft(calcImage);


        //add create by label
        layoutOfAbout.setCenter(createdBy);
        layoutOfAbout.setAlignment(createdBy, Pos.TOP_LEFT);

        //add name of calculator
        layoutOfAbout.setTop(nameOfCalc);
        layoutOfAbout.setAlignment(nameOfCalc, Pos.CENTER);

        //add close button
        layoutOfAbout.setBottom(closeBut);
        layoutOfAbout.setAlignment(closeBut, Pos.CENTER);


        layoutOfAbout.setPadding(new Insets(20, 20, 20, 20));

        Scene newScene = new Scene(layoutOfAbout);
        window.setScene(newScene);
        window.showAndWait();
    }

    private void cosxPressed() {
        try {
            Double number = Double.parseDouble(input.getText());
            input.setText(String.valueOf(Math.cos(number)));
        }
        catch (Exception e)
        {
            input.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation Error");
            alert.setHeaderText("Unvalid number");
            alert.setContentText("Please insert the integer number!");
            alert.showAndWait();
        }
    }

    private void sinxPressed() {
        try {
            Double number = Double.parseDouble(input.getText());
            input.setText(String.valueOf(Math.sin(number)));
        }
        catch (Exception e)
        {
            input.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation Error");
            alert.setHeaderText("Unvalid number");
            alert.setContentText("Please insert the integer number!");
            alert.showAndWait();
        }

    }

    private void factorialPressed() {
        BigInteger number;
        BigInteger result = BigInteger.ONE;
        try {
            number = BigInteger.valueOf(Long.parseLong(input.getText()));
            int check = number.intValue();
            if(check < 0)
            {
                throw new Exception();
            }
            if(check < 100000) {
                for (int i = 1; i <= number.intValue(); i++) {
                    result = result.multiply(BigInteger.valueOf(i));
                }
                input.setText(String.valueOf(result));
            }
            else
            {
                throw new ArithmeticException();
            }
        }
        catch (ArithmeticException ae)
        {
            input.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation Error");
            alert.setHeaderText("Number is too big");
            alert.setContentText("The operation will be very slow \nfor this number or bigger!");
            alert.showAndWait();
        }
        catch (Exception e)
        {
            input.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation Error");
            alert.setHeaderText("Unvalid number");
            alert.setContentText("Please insert the positive integer number!");
            alert.showAndWait();
        }



    }

    private void sqrtPresed() {
        if(firstNumber.equals("NaN") || firstNumber.equals("Unvalid Operation") || secondNumber.equals("NaN") || secondNumber.equals("Unvalid Operation")) {

        }
        else {
            Double firstNum = Double.parseDouble(input.getText());
            Double result = Math.sqrt(firstNum);
            input.setText(result.toString());
        }
    }

    private void dotPressed() {
        if(!input.getText().contains(".")) {
            if (input.getText().length() == 0) {
                input.setText("0.");
            } else {
                input.setText(input.getText() + ".");
            }
            dot.setDisable(true);
        }
    }

    /**
     * Button which change the number to positive or negative
     */
    private void negatPressed() {
        String inputStr = input.getText();
        if(inputStr.contains("-"))
        {
            input.setText(input.getText(1, input.getText().length()));
        }
        else
        {
            input.setText("-" + input.getText());
        }
    }

    /**
     * Function which take the operation which the user is chose
     * and give the result of the two numbers.
     */
    private void resultPressed() {
        isFirstNumberPressed = false;
        secondNumber = input.getText();
        if(firstNumber.equals("NaN") || firstNumber.equals("Unvalid Operation") || secondNumber.equals("NaN") || secondNumber.equals("Unvalid Operation")) {

        }
        else
        {
            if(firstNumber.contains(".") || secondNumber.contains(".") || operation.equals("/"))
            {
                floatResult();
            }
            else {
                BigIntegerResult();
            }
        }
        exprOver = true;
    }

    /**
     * The function which is called from result function and
     * calculated the result from current operation for integer number
     */
    private void BigIntegerResult() {
        if (!secondNumber.equals("") && !firstNumber.equals("")) {
            BigInteger secNum = new BigInteger(secondNumber);
            BigInteger firstNum = new BigInteger(firstNumber);
            switch (operation) {
                case "+": {
                    input.clear();
                    BigInteger result = firstNum.add(secNum);
                    input.setText(result.toString());
                    break;
                }
                case "-": {
                    input.clear();
                    BigInteger result = firstNum.subtract(secNum);
                    input.setText(result.toString());
                    break;
                }
                case "X": {
                    input.clear();
                    BigInteger result = firstNum.multiply(secNum);
                    input.setText(result.toString());
                    break;
                }
                case "x^y":{
                    input.clear();
                    int intSecNum = secNum.intValue();
                    BigInteger result = firstNum.pow(intSecNum);
                    input.setText(result.toString());
                    break;
                }
                case "":
                    break;
            }
            operation = "";
        }
    }

    /**
     * The function which is called from result function and
     * calculated the result from current operation for float number
     */
    private void floatResult() {
        if(!secondNumber.equals("") && !firstNumber.equals("")) {
            Float secNum = Float.parseFloat(secondNumber);
            Float firstNum = Float.parseFloat(firstNumber);
            switch (operation) {
                case "+": {
                    input.clear();
                    Float result = firstNum+secNum;
                    input.setText(result.toString());
                    break;
                }
                case "-": {
                    input.clear();
                    Float result = firstNum-secNum;
                    input.setText(result.toString());
                    break;
                }
                case "X": {
                    input.clear();
                    Float result = firstNum*secNum;
                    input.setText(result.toString());
                    break;
                }
                case "/": {
                    if(secNum == 0)
                    {
                        input.clear();
                        input.setText("Unvalid Operation");
                    }
                    else {
                        input.clear();
                        Float result = firstNum/secNum;
                        input.setText(result.toString());
                    }
                    break;
                }
                case "":
                    break;
            }
            operation = "";
        }
    }

    /**
     * Delete the last character from the display
     */
    private void back() {
        if(input.getText().length() > 0){
            if(input.getText().charAt(input.getText().length()-1) != '.') {
                input.deleteText(input.getText().length() - 1, input.getText().length());
            }
            else
            {
                dot.setDisable(false);
                input.deleteText(input.getText().length() - 1, input.getText().length());
            }
        }
    }

    /**
     * Insert the current number which user pressed
     * @param buttonNumber
     */
    private void pressedNumberButton(int buttonNumber) {

        if(exprOver == true && operation.equals(""))
        {
            input.clear();
            exprOver = false;
        }
        if(!operation.equals("") && isFirstNumberPressed == false)
        {
            firstNumber = input.getText();
            input.clear();
            isFirstNumberPressed = true;
            dot.setDisable(false);
        }
        if(buttonNumber == 0 && input.getText().length()==0)
        {
            input.setText("0.");
            dot.setDisable(true);
        }
        else {
            String currentVal = input.getText();
            input.setText(currentVal + buttonNumber);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
