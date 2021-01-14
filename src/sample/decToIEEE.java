package sample;

public class decToIEEE {
    private double decimal;
    private int intval;
    private double mantissa;

    public decToIEEE(double decimal) {
        this.decimal = decimal;
        intval = (int) this.decimal;
        mantissa = this.decimal - this.intval;
    }

    public static String getIEEE(double intval) {
        char signBit;
        if (intval >= 0) {
            signBit = '0';
        } else {
            signBit = '1';
        }
        String lmao = Integer.toBinaryString((int)intval);
        int exponent = lmao.length() - 1;
        String mantissa = lmao.substring(1);
        while (mantissa.length() < 23) {
            intval = ((intval - (int)intval) * 2);
            mantissa += String.valueOf((int) intval);
        }
        intval = ((intval - (int)intval) * 2);
        if ((int) intval == 1) {
            intval = ((intval - (int)intval) * 2);
            String roundVal = String.valueOf(intval);
            roundVal += String.valueOf((int)((intval - (int)intval) * 2));
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
        String binary = Integer.toBinaryString(127 + exponent);
        return signBit + binary + fill + mantissa;
    }


}
