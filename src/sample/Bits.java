package sample;

import java.util.Arrays;

public class Bits {

    private static Bits instance = null;
    private int signBit;
    private int[] exponentBits;
    private int[] mantissaBits;

    private Bits() {
        this.exponentBits = new int[8];
        this.mantissaBits = new int[23];
        this.initBits();
    }

    private void initBits(){
        this.signBit = 0;
        Arrays.fill(this.exponentBits, 0);
        Arrays.fill(this.mantissaBits, 0);
    }

    public static Bits getInstance() {
        if (instance == null){
            instance = new Bits();
        }
        return instance;
    }

    public int getSignBit(){
        return this.signBit;
    }

    public void setSignBit(int signBit) {
        this.signBit = signBit;
    }

    public int getExponentBit(int pos){
        return this.exponentBits[pos];
    }

    public int getMantissaBit(int pos){
        return this.mantissaBits[pos];
    }

    public void setExponentBit(int pos, int bin){
        this.exponentBits[pos] = bin;
    }

    public void setMantissaBit(int pos, int bin){
        this.mantissaBits[pos] = bin;
    }

    public String getBits(){
        String bits = String.valueOf(signBit);
        for(int i : exponentBits){
            bits += (String.valueOf(i));
        }
        for(int i : mantissaBits){
            bits += (String.valueOf(i));
        }

        return bits;
    }
}
