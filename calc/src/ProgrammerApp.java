import java.util.Scanner;

// Основной класс приложения (UI)
public class ProgrammerApp implements IApp {

    private final Scanner sc = new Scanner(System.in);
    private final ICalculator calc = new ProgrammerCalculator();
    private final NumberSystemManager manager = new NumberSystemManager();

    @Override
    public void start() {

        System.out.println("Калькулятор программиста");

        while (true) {
            try {
                // Показываем текущую систему
                System.out.println("\nТекущая система: " + manager.getName());
                System.out.println("Введите BIN / DEC / OCT / HEX для смены системы");
                System.out.print("Введите число или q: ");

                String input = sc.next();

                // Выход из программы
                if (input.equalsIgnoreCase("q")) break;

                // Смена системы
                if (isMode(input)) {
                    manager.setSystem(input);
                    continue;
                }

                AbstractNumberSystem system = manager.getSystem();

                // Проверка корректности ввода
                if (!system.isValid(input)) {
                    System.out.println("Ошибка ввода!");
                    continue;
                }

                long a = system.toDecimal(input);

                System.out.print("Операция (+ - * / % +/-): ");
                String op = sc.next();

                long result;

                // Унарная операция
                if (op.equals("+/-")) {
                    result = calc.calculateUnary(a, op);
                } else {
                    // Ввод второго числа
                    System.out.print("Введите второе число: ");
                    String bStr = sc.next();

                    if (!system.isValid(bStr)) {
                        System.out.println("Ошибка ввода!");
                        continue;
                    }

                    long b = system.toDecimal(bStr);

                    // Вычисление
                    result = calc.calculate(a, b, op);
                }

                // Вывод результата
                printAll(result);

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    // Проверка, является ли строка командой смены системы
    private boolean isMode(String s) {
        return s.equalsIgnoreCase("BIN") ||
                s.equalsIgnoreCase("DEC") ||
                s.equalsIgnoreCase("OCT") ||
                s.equalsIgnoreCase("HEX");
    }

    // Вывод результата во всех системах
    private void printAll(long value) {
        System.out.println("\nРЕЗУЛЬТАТ");

        AbstractNumberSystem current = manager.getSystem();

        // Сначала текущая система
        System.out.println(current.getName() + ": " + current.fromDecimal((int) value));

        // Остальные системы
        AbstractNumberSystem[] systems = {
                new DecimalSystem(),
                new BinarySystem(),
                new OctalSystem(),
                new HexSystem()
        };

        for (AbstractNumberSystem sys : systems) {
            if (!sys.getName().equals(current.getName())) {
                System.out.println(sys.getName() + ": " + sys.fromDecimal((int) value));
            }
        }
    }
}