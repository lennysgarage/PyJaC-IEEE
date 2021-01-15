package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class UpdateBits {

    int position;
    final Bits bits = Bits.getInstance();
    final BitsModel bitsModel;

    UpdateBits(int position, BitsModel bitsModel) {
        this.position = position;
        this.bitsModel = bitsModel;
    }
}

class UpdateSign extends UpdateBits implements EventHandler<ActionEvent> {

    UpdateSign(int position, BitsModel bitsModel){
        super(position, bitsModel);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(bits.getSignBit() == 0)
            bits.setSignBit(1);
        else
            bits.setSignBit(0);
        bitsModel.updateBits();
    }
}

class UpdateExp extends UpdateBits implements EventHandler<ActionEvent> {

    UpdateExp(int position, BitsModel bitsModel) {
        super(position, bitsModel);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(bits.getExponentBit(position) == 0)
            bits.setExponentBit(position, 1);
        else
            bits.setExponentBit(position, 0);
        bitsModel.updateBits();
    }
}

class UpdateMan extends UpdateBits implements EventHandler<ActionEvent> {

    UpdateMan(int position, BitsModel bitsModel){
        super(position, bitsModel);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(bits.getMantissaBit(position) == 0)
            bits.setMantissaBit(position, 1);
        else
            bits.setMantissaBit(position, 0);
        bitsModel.updateBits();
    }
}



