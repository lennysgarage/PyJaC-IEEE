package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        initUI(primaryStage);
    }

    private final ChangeCheckBox signBitBox = new ChangeCheckBox(0);
    private final ChangeCheckBox[] exponentBits = new ChangeCheckBox[8];
    private final ChangeCheckBox[] mantissaBits = new ChangeCheckBox[23];

    // Model
    BitsModel bitsModel;

    // Panes
    final FlowPane pane = new FlowPane();
    final TilePane pane2 = new TilePane();
    final TilePane pane3 = new TilePane();

    private void initUI(Stage stage){

        // Model
        bitsModel = new BitsModel();

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        Scene scene = new Scene(pane, 1038, 200);

        Label signBit = new Label("Sign");
        signBit.setPadding(new Insets(10, 10, 10, 10));
        signBit.setStyle("-fx-background-color:#e2f0cb; -fx-font-weight: bold; -fx-font-size:16px");
        Label exponent = new Label("Exponent");
        exponent.setPadding(new Insets(10, 100, 10, 100));
        exponent.setStyle("-fx-background-color:#c7ceea; -fx-font-weight: bold; -fx-font-size:16px");
        Label mantissa = new Label("Mantissa");
        mantissa.setPadding(new Insets(10, 302, 10, 302));
        mantissa.setStyle("-fx-background-color:#ffb7b2; -fx-font-weight: bold; -fx-font-size:16px");

        pane.getChildren().addAll(signBit, exponent, mantissa);

        // Insert all the checkboxes

        // Inserting the sign bit checkbox
        signBitBox.setPadding(new Insets(10, 17, 10, 17));
        pane.getChildren().add(signBitBox);
        signBitBox.setOnAction(new UpdateSign(0, bitsModel));

        bitsModel.attach(signBitBox);

        // Inserting the exponent bit checkboxes

        pane2.setPadding(new Insets(20, 20, 20, 22));
        pane2.setVgap(10);
        pane2.setHgap(15);
        pane2.setPrefColumns(8);

        for(int i = 0; i < 8; i++){
            exponentBits[i] = new ChangeCheckBox(1 + i);
            bitsModel.attach(exponentBits[i]);
            pane2.getChildren().add(exponentBits[i]);
            exponentBits[i].setOnAction(new UpdateExp(i, bitsModel));
        }

        // Inserting the mantissa bit checkboxes

        pane3.setPadding(new Insets(20, 20, 20, 21));
        pane3.setVgap(10);
        pane3.setHgap(12);
        pane3.setPrefColumns(23);

        for(int i = 0; i < 23; i++){
            mantissaBits[i] = new ChangeCheckBox(9 + i);
            bitsModel.attach(mantissaBits[i]);
            pane3.getChildren().add(mantissaBits[i]);
            mantissaBits[i].setOnAction(new UpdateMan(i, bitsModel));
        }

        pane.getChildren().addAll(pane2, pane3);

        // Grab text
        ChangeDecimalText txt = new ChangeDecimalText();
        txt.setOnAction(new DecimalInput(txt, bitsModel));
        pane.getChildren().add(txt);
        bitsModel.attach(txt);



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
                System.out.println(dec.getIEEE());
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
                System.out.println(bin.getDec());
                isIEEE = true;
            }
        }
    }
}
