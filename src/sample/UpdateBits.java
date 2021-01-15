package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public abstract class UpdateBits {

    int position;
    final Bits bits = Bits.getInstance();

    UpdateBits(int position) {
        this.position = position;
    }
}

class UpdateSign implements EventHandler<ActionEvent> {

    private final CheckBox signBit;

    UpdateSign(CheckBox signBit){
        this.signBit = signBit;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(this.signBit.isSelected());
    }
}

class UpdateExp extends UpdateBits implements EventHandler<ActionEvent> {

    UpdateExp(int position) {
        super(position);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(bits.getExponentBit(position) == 0)
            bits.setExponentBit(position, 1);
        else
            bits.setExponentBit(position, 0);
        System.out.println(bits.getExponentBit(position));
        // need to notify observers
    }
}

class UpdateMan extends UpdateBits implements EventHandler<ActionEvent> {

    UpdateMan(int position){
        super(position);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(bits.getMantissaBit(position) == 0)
            bits.setMantissaBit(position, 1);
        else
            bits.setMantissaBit(position, 0);
        System.out.println(bits.getMantissaBit(position));
    }

    // need to notify observers
}