package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class DecimalInput implements EventHandler<ActionEvent> {

    private final TextField text;
    private final BitsModel bitsModel;
    final Bits bits = Bits.getInstance();

    DecimalInput(TextField text, BitsModel bitsModel){
        this.text = text;
        this.bitsModel = bitsModel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            double dec = Double.parseDouble(text.getText());
            bits.setDecimal(dec);
            updateArrays(dec);
        } catch(Exception e) { }
        bitsModel.updateBits();
    }

    private void updateArrays(Double dec){
        decToIEEE ieee = new decToIEEE(dec);
        String str = ieee.getIEEE();
        bits.setSignBit(Character.getNumericValue(str.charAt(0)));
        for(int i = 1; i < 9; i++){
            bits.setExponentBit(i-1, Character.getNumericValue(str.charAt(i)));
        }
        for(int i = 9; i < str.length(); i++){
            bits.setMantissaBit(i-9, Character.getNumericValue(str.charAt(i)));
        }
    }
}
