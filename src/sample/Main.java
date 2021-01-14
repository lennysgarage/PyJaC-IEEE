package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        //launch(args);
        boolean running = true;

        while(running) {
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
                break;
            }
            // Call method to convert here using inputInt
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
