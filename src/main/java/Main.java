import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean inputAccepted = false;
        do {
            try {
                // Ввод данных
                System.out.print("Введите Фамилию Имя Отчество дату рождения номер телефона пол (через пробел): ");
                String[] input = scanner.nextLine().split(" ");

                if (input.length != 6) {
                    throw new IllegalArgumentException("Неверное количество данных");
                }

                UserData userData = new UserData(input[0], input[1], input[2], input[3], Long.parseLong(input[4]), input[5].charAt(0));

                // Запись в файл
                UserFileManager.writeFile(userData);

                inputAccepted = true;

            } catch (IllegalArgumentException | IOException e) {
                System.err.println("Ошибка: " + e.getMessage());
                System.out.println("Повторите ввод.");
            }
        } while (!inputAccepted);

        scanner.close();
    }
}