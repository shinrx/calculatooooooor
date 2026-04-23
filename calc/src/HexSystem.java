// Шестнадцатеричная система счисления
public class HexSystem extends AbstractNumberSystem {

    // Перевод из HEX в DEC
    public int toDecimal(String value) {
        return Integer.parseInt(value, 16);
    }

    // Перевод из DEC в HEX
    public String fromDecimal(int value) {
        return Integer.toHexString(value).toUpperCase();
    }

    // Название системы
    public String getName() {
        return "HEX";
    }

    // Проверка (0-9 и A-F)
    public boolean isValid(String value) {
        return value.matches("-?[0-9A-Fa-f]+");
    }
}