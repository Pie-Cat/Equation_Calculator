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

    public boolean isString () { return stringCheck; }

    public Object getValue () {
        if (stringCheck)
            return strValue;
        else
            return dubValue;
    }
}
