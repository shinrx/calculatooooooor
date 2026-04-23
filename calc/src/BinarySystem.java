// Двоичная система счисления
public class BinarySystem extends AbstractNumberSystem {

    // Перевод из BIN в DEC
    public int toDecimal(String value) {
        return Integer.parseInt(value, 2);
    }

    // Перевод из DEC в BIN
    public String fromDecimal(int value) {
        return Integer.toBinaryString(value);
    }

    // Название системы
    public String getName() {
        return "BIN";
    }

    // Проверка, что строка содержит только 0 и 1 (и возможный минус)
    public boolean isValid(String value) {
        return value.matches("-?[01]+");
    }
}