class Validate {
    public static boolean checkIsUntil10(int x, int y) {
        return x <= 10 && y <= 10;
    }

    public static boolean checkIsInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static String findOperator(String inputData) {
        if (inputData.contains("+")) {
            return "+";
        } else if (inputData.contains("-")) {
            return "-";
        } else if (inputData.contains("*")) {
            return "*";
        } else if (inputData.contains("/")) {
            return "/";
        } else return null;
    }
}