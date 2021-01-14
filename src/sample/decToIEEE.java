package sample;

public class decToIEEE {

    private double decimal;
    private String binString;

    public decToIEEE(double decimal) {
        this.decimal = decimal;
        if (this.decimal < 0) {
            this.binString = Integer.toBinaryString(-(int) this.decimal);
        } else {
            this.binString = Integer.toBinaryString((int) this.decimal);
        }
    }

    public void getIEEE() {
        System.out.println(getSignBit() + getBinary() + getMantissa());
    }

    private char getSignBit() {
        if (this.decimal >= 0) {
            return '0';
        }
        return '1';
    }

    private String getBinary() {
        int exponent = this.binString.length() - 1;
        return Integer.toBinaryString(127 + exponent);
    }

    private String getMantissa() {
        if (this.decimal < 0) {
            this.decimal = -this.decimal;
        }
        String mantissa = this.binString.substring(1);
        while (mantissa.length() < 23) {
            this.decimal = ((this.decimal - (int)this.decimal) * 2);
            mantissa += String.valueOf((int) this.decimal);
        }
        this.decimal = ((this.decimal - (int)this.decimal) * 2);
        if ((int) this.decimal == 1) {
            this.decimal = ((this.decimal - (int)this.decimal) * 2);
            String roundVal = String.valueOf(this.decimal);
            roundVal += String.valueOf((int)((this.decimal - (int)this.decimal) * 2));
            if (roundVal.indexOf('1') != -1 || (int)(mantissa.charAt(mantissa.length() - 1)) == 0) {
                mantissa = Integer.toBinaryString(Integer.parseInt(mantissa, 2) + 1);
            }
        }
        String fill = "";
        if (mantissa.length() < 23) {
            for (int i = 0; i < (23 - mantissa.length()); i++) {
                fill += "0";
            }
        }
        return fill + mantissa;
    }

}
