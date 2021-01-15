package sample;

public class Bits {

    private static Bits instance = null;
    private int[] exponentBits;
    private int[] mantissaBits;

    private Bits() {
        this.exponentBits = new int[8];
        this.mantissaBits = new int[23];
        this.initBits();
    }

    private void initBits(){
        for(int i = 0; i < this.exponentBits.length; i++){
            this.exponentBits[i] = 0;
        }
        for(int i = 0; i < this.mantissaBits.length; i++){
            this.mantissaBits[i] = 0;
        }
    }

    public static Bits getInstance() {
        if (instance == null){
            instance = new Bits();
        }
        return instance;
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
}
