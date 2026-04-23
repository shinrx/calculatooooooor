// Интерфейс калькулятора
public interface ICalculator {

    // Обычная операция (2 числа)
    long calculate(long a, long b, String op);

    // Унарная операция (1 число)
    long calculateUnary(long a, String op);
}