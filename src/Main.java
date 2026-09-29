import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<JournalEntry> journal = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== ЖУРНАЛ КУРАТОРА ===");
            System.out.println("1. Додати новий запис");
            System.out.println("2. Показати всі записи");
            System.out.println("0. Вийти");
            System.out.print("Оберіть дію: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNewEntry();
                    break;
                case "2":
                    showAllEntries();
                    break;
                case "0":
                    System.out.println("Програму завершено.");
                    return;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void addNewEntry() {
        System.out.println("\n--- Введення даних студента ---");

        
        String nameRegex = "^[A-Za-zА-Яа-яІіЇїЄєҐґ'-]{2,30}$";
        String dateRegex = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)\\d\\d$"; 
        String phoneRegex = "^\\+?[0-9]{10,12}$"; 

        String lastName = readValidInput("Введіть прізвище: ", nameRegex, "Прізвище має містити лише літери (від 2 символів).");
        String firstName = readValidInput("Введіть ім'я: ", nameRegex, "Ім'я має містити лише літери (від 2 символів).");
        String birthDate = readValidInput("Введіть дату народження (ДД.ММ.РРРР): ", dateRegex, "Некоректний формат дати. Приклад: 15.05.2002");
        String phone = readValidInput("Введіть номер телефону (+380...): ", phoneRegex, "Некоректний телефон. Введіть від 10 до 12 цифр.");

        System.out.println("\n-- Введення адреси --");
        String street = readValidInput("Введіть вулицю: ", ".+", "Вулиця не може бути порожньою.");
        String house = readValidInput("Введіть номер будинку: ", ".+", "Номер будинку не може бути порожнім.");
        String apartment = readValidInput("Введіть номер квартири: ", "^[0-9]{1,4}$", "Номер квартири має бути числом.");

        String fullAddress = "вул. " + street + ", буд. " + house + ", кв. " + apartment;

        
        JournalEntry entry = new JournalEntry(lastName, firstName, birthDate, phone, fullAddress);
        journal.add(entry);

        System.out.println("\n[УСПІХ] Запис успішно додано до журналу!");
    }

    private static String readValidInput(String prompt, String regex, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("[ПОМИЛКА] " + errorMessage + " Повторіть введення.");
            }
        }
    }

    private static void showAllEntries() {
        System.out.println("\n=== СПИСОК ЗАПИСІВ ЖУРНАЛУ ===");
        if (journal.isEmpty()) {
            System.out.println("Журнал порожній.");
            return;
        }

        for (int i = 0; i < journal.size(); i++) {
            System.out.println((i + 1) + ". " + journal.get(i));
        }
    }
}