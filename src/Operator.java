public class Operator {
    private boolean stringCheck;
    private String strValue;
    private double dubValue;

    public Operator (String str) {
        strValue = str;

        try {
            dubValue = Double.parseDouble(str);
            stringCheck = false;
        } catch (NumberFormatException e) {
            stringCheck = true;
        }
    }

    public Operator (double num) {
        strValue = num + "";
        dubValue = num;
        stringCheck = false;
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

    public Object getValue () {
        if (stringCheck)
            return strValue;
        else
            return dubValue;
    }

    public boolean equals (Object obj) {
        return this.getValue().equals(obj.toString());
    }

    public String toString () {
        return strValue;
    }
}
