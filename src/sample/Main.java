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
                    decToIEEE(Integer.parseInt(input));
                    break;
                case "2":
                    IEEEToDec(input);
                    break;
                default:
                    System.out.println("Plase enter a valid input (0-2)");
                    break;
            }
        }
    }

    private static void decToIEEE(int dec){

    }

    private static void IEEEToDec(String ieee){

    }
}
