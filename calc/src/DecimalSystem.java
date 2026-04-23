// Десятичная система счисления
public class DecimalSystem extends AbstractNumberSystem {

    // Перевод в DEC (уже десятичная)
    public int toDecimal(String value) {
        return Integer.parseInt(value);
    }

    // Обратное преобразование
    public String fromDecimal(int value) {
        return String.valueOf(value);
    }

    // Название системы
    public String getName() {
        return "DEC";
    }

    // Проверка числа (цифры и возможный минус)
    public boolean isValid(String value) {
        return value.matches("-?\\d+");
    }
}