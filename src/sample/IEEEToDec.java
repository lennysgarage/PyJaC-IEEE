package sample;

public class IEEEToDec {

    private String binString;

    public IEEEToDec(String binString) {
        this.binString = binString;
    }

    public double getDec() {
        return this.calcIEEEToDec();
    }

    private int getSignBit(){
        return this.binString.charAt(0);
    }

    private double getSummation(){
        double sum = 0;
        char[] mantissa = this.binString.substring(9).toCharArray();
        for(int i = 0; i < 23; i++){
            sum += Character.getNumericValue(mantissa[i]) * Math.pow(2,-(i+1));
        }
        return 1 + sum;
    }

    private int getExponent(){
        int exponent = 0;
        char[] exponentBits = this.binString.substring(1,9).toCharArray();
        for(int i = 0; i <= 7; i++){
            exponent += Character.getNumericValue(exponentBits[i]) * Math.pow(2,7-i);
        }
        return exponent;
    }

    private double calcIEEEToDec(){
        // Special case for when the value is 0.
        if (this.getExponent() == 0){
            return 0;
        }
        return Math.pow(-1, this.getSignBit()) * this.getSummation() * Math.pow(2, this.getExponent() - 127);
    }
}
