package sample;

import javafx.scene.control.TextField;

public class ChangeDecimalText extends TextField implements Observer {

    final Bits bits = Bits.getInstance();

    ChangeDecimalText(){
        // Default value
        this.setText("0");
    }

    @Override
    public void update(Observable o) {
        IEEEToDec num = new IEEEToDec(bits.getBits());
        this.setText(String.valueOf(num.getDec()));

    }
}
