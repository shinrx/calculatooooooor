// Класс для управления текущей системой счисления
public class NumberSystemManager {

    // Текущая система (по умолчанию DEC)
    private AbstractNumberSystem currentSystem = new DecimalSystem();

    // Установка системы по имени
    public void setSystem(String name) {
        switch (name.toUpperCase()) {
            case "BIN" -> currentSystem = new BinarySystem();
            case "OCT" -> currentSystem = new OctalSystem();
            case "DEC" -> currentSystem = new DecimalSystem();
            case "HEX" -> currentSystem = new HexSystem();
            default -> System.out.println("Неизвестная система!");
        }
    }

    // Получение текущей системы
    public AbstractNumberSystem getSystem() {
        return currentSystem;
    }

    // Получение названия системы
    public String getName() {
        return currentSystem.getName();
    }
}