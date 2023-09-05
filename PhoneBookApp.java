import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + ": " + phoneNumber;
    }
}

public class PhoneBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // создам объект Scanner для ввода данных с клавиатуры
        Contact[] contacts = new Contact[10]; // создаем массив для хранения контактов, максимум 10 контактов

        while (true) { // Бесконечный цикл выполнения программы
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Редактировать контакт");
            System.out.println("3. удалить контакт");
            System.out.println("4. Показать список контактов");
            System.out.println("5. выйти");

            int choice = scanner.nextInt(); // читаю выбор пользователя
            scanner.nextLine(); //  символ новой строки после ввода числа

            switch (choice) { // Оператор выбора в зависимости от выбора пользователя
                case 1:
                    addContact(scanner, contacts); // Вызываю метод что бы добавить контакт
                    break;
                case 2:
                    editContact(scanner, contacts); // Вызываем метод для редактирования контакта
                    break;
                case 3:
                    deleteContact(scanner, contacts); // Вызываем метод для удаления контакта
                    break;
                case 4:
                    showContacts(contacts); // Вызываем метод для отображения контактов
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    return; // Завершаем выполнение программы
                default:
                    System.out.println("Неверный выбор, попробуйте ещё раз.");
            }
        }
    }

    // Функция что бы добавить новый кнтакт
    private static void addContact(Scanner scanner, Contact[] contacts) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) { // Проверяем, есть ли свободное место для контакта
                System.out.println("Введите имя контакта:");
                String name = scanner.nextLine(); // Считываем имя контакта
                System.out.println("Введите номер телефона:");
                String phoneNumber = scanner.nextLine(); // Считываем номер телефона контакта
                contacts[i] = new Contact(name, phoneNumber); // Создаем новый контакт и добавляем его в массив
                System.out.println("Контакт успешно добавлен.");
                return; // Завершаем метод после добавления контакта
            }
        }
        System.out.println("Нельзя добавить больше контактов.");
    }

    // Функция для редактирования существующего контакта
    private static void editContact(Scanner scanner, Contact[] contacts) {
        showContacts(contacts); // Отображаем список контактов
        System.out.println("Введите номер контакта, который хотите редактировать:");
        int index = scanner.nextInt(); // Считываем номер контакта для редактирования
        scanner.nextLine(); // Считываем символ новой строки после ввода числа

        if (index >= 0 && index < contacts.length && contacts[index] != null) { // Проверяем валидность номера и существование контакта
            System.out.println("Введите новое имя контакта:");
            String newName = scanner.nextLine(); // Считываем новое имя контакта
            System.out.println("Введите новый номер телефона:");
            String newPhoneNumber = scanner.nextLine(); // Считываем новый номер телефона контакта
            contacts[index].name = newName; // Обновляем имя контакта
            contacts[index].phoneNumber = newPhoneNumber; // Обновляем номер телефона контакта
            System.out.println("Контакт успешно отредактирован.");
        } else {
            System.out.println("Неверный номер контакта.");
        }
    }

    // Функция для удаления существующего контакта
    private static void deleteContact(Scanner scanner, Contact[] contacts) {
        showContacts(contacts); // Отображаем список контактов
        System.out.println("Введите номер контакта, который хотите удалить:");
        int index = scanner.nextInt(); // Считываем номер контакта для удаления
        scanner.nextLine(); // Считываем символ новой строки после ввода числа

        if (index >= 0 && index < contacts.length && contacts[index] != null) { // Проверяем валидность номера и существование контакта
            contacts[index] = null; // Удаляем контакт
            System.out.println("Контакт успешно удален.");
        } else {
            System.out.println("Неверный номер контакта.");
        }
    }

    // Функция для отображения списка контактов
    private static void showContacts(Contact[] contacts) {
        System.out.println("Список контактов:");
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                System.out.println(i + ". " + contacts[i]); // Отображаем контакт
            } else {
                System.out.println(i + ". ..."); // Отображаем пустое место
            }
        }
    }
}