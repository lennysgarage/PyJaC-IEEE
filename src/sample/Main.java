package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    //private int[] exponentBits = {0, 0, 0, 0, 0, 0, 0, 0};
    private CheckBox[] exponentBits = new CheckBox[8];
    private CheckBox[] mantissaBits = new CheckBox[23];

    @Override
    public void start(Stage primaryStage) throws Exception{
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        final GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        //pane.setVgap(10);
        Scene scene = new Scene(pane, 600, 600);

        Label signBit = new Label("Sign bit");
        signBit.setPadding(new Insets(0, 40, 0, 0));
        signBit.setStyle("-fx-background-color:#5c2cd3; -fx-font-weight: bold; -fx-font-size:16px");
        Label exponent = new Label("Exponent");
        exponent.setPadding(new Insets(0, 100, 0, 0));
        exponent.setStyle("-fx-background-color:#3ec162; -fx-font-weight: bold; -fx-font-size:16px");
        Label mantissa = new Label("Mantissa");
        mantissa.setPadding(new Insets(0, 100, 0, 0));
        mantissa.setStyle("-fx-background-color:#e3331c; -fx-font-weight: bold; -fx-font-size:16px");

        pane.add(signBit,1, 0);
        pane.add(exponent, 2, 0);
        pane.add(mantissa, 3, 0);


        // Insert all the checkboxes
        CheckBox signBitBox = new CheckBox();
        pane.add(signBitBox, 1, 3);

        for(int i = 0; i < 8; i++){
            exponentBits[i] = new CheckBox();
            pane.add(exponentBits[i], 2 + i, 3);
        }

        for(int i = 0; i < 23; i++){
            mantissaBits[i] = new CheckBox();
            pane.add(mantissaBits[i], 10 + i, 1);
        }




        stage.setTitle("IEEE-754 Single Precision Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("=========IEEE Converter=========");
            System.out.println("2. IEEE-754 to Decimal");
            System.out.println("1. Decimal to IEEE-754");
            System.out.println("0. Exit");
            System.out.println("=========IEEE Converter=========");

            String input = in.nextLine();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    decToIEEE();
                    break;
                case "2":
                    IEEEToDec();
                    break;
                default:
                    System.out.println("Please enter a valid input (0-2)");
                    break;
            }
        }
    }

    private static void decToIEEE(){
        boolean isInt = false;
        while(!isInt) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter a decimal number to convert to its IEEE-754 representation: ");
            try {
                double inputInt = in.nextDouble();
                decToIEEE dec = new decToIEEE(inputInt);
                dec.getIEEE();
            } catch (Exception e){
                e.printStackTrace();
                continue;
            }
            isInt = true;
        }
    }

    private static void IEEEToDec(){
        boolean isIEEE = false;
        while(!isIEEE) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter a decimal number in IEEE-754 to convert back to its decimal representation: ");
            String inputIEEE = in.nextLine();
            if(inputIEEE.length() == 32){
                IEEEToDec bin = new IEEEToDec(inputIEEE);
                bin.getDec();
                isIEEE = true;
            }
        }
    }
}
