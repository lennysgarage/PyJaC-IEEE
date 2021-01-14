package sample;

public class decToIEEE {

    private double decimal;
    private String binString;
    private int negativeExp;

    public decToIEEE(double decimal) {
        this.decimal = decimal;
        this.negativeExp = 0;
        if (this.decimal < 0) {
            this.binString = Integer.toBinaryString(-(int) this.decimal);
        } else {
            this.binString = Integer.toBinaryString((int) this.decimal);
        }
    }

    public void getIEEE() {
        char signBit = getSignBit();
        String mantissa = getMantissa();
        String binary = getBinary();
        System.out.println(signBit + binary + mantissa);
    }

    private char getSignBit() {
        if (this.decimal >= 0) {
            return '0';
        }
        return '1';
    }

    private String getBinary() {
        int exponent;
        if (this.decimal == 0) {
            exponent = -127;
        } else if ((int)this.decimal == 0) {
            exponent = this.negativeExp;
        } else {
            exponent = this.binString.length() - 1;
        }
        String binary = Integer.toBinaryString(127 + exponent);
        while (binary.length() < 8) {
            binary = "0" + binary;
        }
        return binary;
    }

    private String getMantissa() {
        boolean lessThanOne = (int) this.decimal == 0 && this.decimal != 0;
        double decimal = this.decimal;
        if (decimal < 0) {
            decimal = -decimal;
        }
        String mantissa = this.binString.substring(1);
        while (mantissa.length() < 23) {
            decimal = ((decimal - (int)decimal) * 2);
            if (lessThanOne && (int) decimal == 1) {
                lessThanOne = false;
                this.negativeExp--;
            }
            else if (!lessThanOne) {
                mantissa += String.valueOf((int) decimal);
            } else {
                this.negativeExp--;
            }
        }
        decimal = ((decimal - (int)decimal) * 2);
        if ((int) decimal == 1) {
            decimal = ((decimal - (int)decimal) * 2);
            String roundVal = String.valueOf(decimal);
            roundVal += String.valueOf((int)((decimal - (int)decimal) * 2));
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
