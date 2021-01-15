package sample;

import javafx.scene.control.CheckBox;

public class ChangeCheckBox extends CheckBox implements Observer {

    Bits bits = Bits.getInstance();
    int position;

    ChangeCheckBox(int position){
        this.position = position;
    }

    @Override
    public void update(Observable o) {
        // Change checkbox to on or off
        if(position == 0){
            this.setSelected(bits.getSignBit() == 1);
        } else if (position <= 8){
            this.setSelected(bits.getExponentBit(position - 1) == 1);
        } else {
            this.setSelected(bits.getMantissaBit(position - 9) == 1);
        }
    }
}
