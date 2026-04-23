// Восьмеричная система счисления
public class OctalSystem extends AbstractNumberSystem {

    // Перевод из OCT в DEC
    public int toDecimal(String value) {
        return Integer.parseInt(value, 8);
    }

    // Перевод из DEC в OCT
    public String fromDecimal(int value) {
        return Integer.toOctalString(value);
    }

    // Название системы
    public String getName() {
        return "OCT";
    }

    // Проверка (только цифры 0-7)
    public boolean isValid(String value) {
        return value.matches("-?[0-7]+");
    }
}