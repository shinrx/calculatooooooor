// Абстрактный класс для всех систем счисления
public abstract class AbstractNumberSystem {

    // Перевод строки в десятичное число
    public abstract int toDecimal(String value);

    // Перевод десятичного числа в текущую систему
    public abstract String fromDecimal(int value);

    // Название системы (BIN, DEC и т.д.)
    public abstract String getName();

    // Проверка корректности введённого числа
    public abstract boolean isValid(String value);
}
