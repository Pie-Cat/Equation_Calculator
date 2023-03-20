public class Operator {
    private boolean stringCheck;
    private String strValue;
    private double dubValue;

    public Operator (StringBuilder strb) {
        oprAdd(strb.toString());
    }

    public Operator (String str) {
        oprAdd(str);
    }

    public Operator (double num) {
        oprAdd(num + "");
    }

    private void oprAdd (String str) {
        strValue = str;

        try {
            dubValue = Double.parseDouble(str);
            stringCheck = false;
        } catch (NumberFormatException e) {
            stringCheck = true;
        }
    }

    public boolean strCheck () {
        return stringCheck;
    }

    public double getNum () {
        return dubValue;
    }

    public String getStr () {
        return strValue;
    }

    public boolean equals (Object obj) {
        return this.getStr().equals(obj.toString());
    }

    public String toString () {
        return strValue;
    }
}
