package sample;

import javafx.scene.control.TextField;

public class ChangeIEEEText extends TextField implements Observer {

    final Bits bits = Bits.getInstance();

    ChangeIEEEText(){
        // Default value
        this.setText("00000000000000000000000000000000");
    }

    @Override
    public void update(Observable o) {
        decToIEEE ieee = new decToIEEE(bits.getDecimal());
        this.setText(ieee.getIEEE());

    }
}
