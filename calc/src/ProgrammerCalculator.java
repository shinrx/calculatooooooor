// Реализация калькулятора
public class ProgrammerCalculator implements ICalculator {

    // Выполнение бинарных операций
    @Override
    public long calculate(long a, long b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                yield a / b;
            }
            case "%" -> {
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                yield a % b;
            }
            default -> throw new IllegalArgumentException("Неверная операция");
        };
    }

    // Унарная операция (смена знака)
    @Override
    public long calculateUnary(long a, String op) {
        if (op.equals("+/-")) return -a;
        throw new IllegalArgumentException("Неверная операция");
    }
}