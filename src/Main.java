import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isRoman;
    static int x;
    static int y;

    public static void main(String[] args) throws Exception {

        System.out.print("Введите выражение из двух операндров (Прим. 4+3):");
        String input = scanner.nextLine().replaceAll(" ", "").toUpperCase();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String operator = Validate.findOperator(input);
        if (operator == null) throw new Exception("//т.к. строка не является математической операцией");

        String[] parts = input.split("[-+/*]");
        if (parts.length != 2)
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        if (Romanian.checkIsRoman(parts[0]) && Romanian.checkIsRoman(parts[1])) {
            x = Romanian.convertToArabic(parts[0]);
            y = Romanian.convertToArabic(parts[1]);
            isRoman = true;
        } else {
            if (Validate.checkIsInt(parts[0]) && Validate.checkIsInt(parts[1])) {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
            } else {
                throw new Exception("//т.к. используются одновременно разные системы счисления");
            }
        }

        if (!Validate.checkIsUntil10(x, y)) {
            throw new Exception("//т.к. используйте числа от 1 до 10");
        } else {
            int result = Calculation.calculate(x, y, operator);
            if (isRoman) {
                if (result < 1)
                    throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                return (Romanian.convertToRomanian(result));
            } else {
                return (String.valueOf(result));
            }
        }
    }
}