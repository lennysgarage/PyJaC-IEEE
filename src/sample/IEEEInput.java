package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class IEEEInput implements EventHandler<ActionEvent> {

    private final TextField text;
    private final BitsModel bitsModel;
    final Bits bits = Bits.getInstance();

    IEEEInput(TextField text, BitsModel bitsModel){
        this.text = text;
        this.bitsModel = bitsModel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String ieee = text.getText();
        try {
            updateArrays(ieee);
        } catch(Exception e) { }
        bitsModel.updateBits();
    }

    private void updateArrays(String ieee){
        bits.setSignBit(Character.getNumericValue(ieee.charAt(0)));
        for(int i = 1; i < 9; i++){
            bits.setExponentBit(i-1, Character.getNumericValue(ieee.charAt(i)));
        }
        for(int i = 9; i < ieee.length(); i++){
            bits.setMantissaBit(i-9, Character.getNumericValue(ieee.charAt(i)));
        }
    }
}
