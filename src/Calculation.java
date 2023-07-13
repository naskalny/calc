public class Calculation {
    public static int calculate(int x, int y, String operator) throws Exception {

        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> throw new Exception("Неопознанные оператор!\nЗавершение работы...");
        };
    }
}