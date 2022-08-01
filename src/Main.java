import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер операции:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            System.out.println("Для завершения введите 'end'");

            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                System.out.println();
                break;
            }
            int operation = 0;
            try {
                operation = Integer.parseInt(inputString);
            } catch (Exception e) {
                System.out.println("Введены некорректные данные!");
                continue;
            }
            switch (operation) {
                case (1) -> {
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.nextLine();
                    products.add(product);
                    System.out.println("Итого в списке покупок: " + products.size());

                }
                case (2) -> {
                    System.out.println("Список покупок:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }

                }
                case (3) -> {
                    System.out.println("Список покупок:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    System.out.println("Какой продукт хотите удалить? Введите номер или название");
                    String deleteProduct = scanner.nextLine();
                    try {
                        int deleteProductIndex = Integer.parseInt(deleteProduct);
                        deleteProduct = products.get(deleteProductIndex - 1);
                        products.remove(deleteProductIndex - 1);
                    } catch (Exception e) {
                        products.remove(deleteProduct);

                    }
                    System.out.println("Покупка '" + deleteProduct + "' удалена из списка продуктов:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                }
                case (4) -> {
                    System.out.println("Введите текст для поиска:");
                    String findInput = scanner.nextLine();
                    String findStr = findInput.toLowerCase(Locale.ROOT);
                    int coincidences = 0;
                    System.out.println("Найдено:");
                    for (String product : products) {
                        if (product.toLowerCase().contains(findStr)) {
                            coincidences++;
                            System.out.println((products.indexOf(product) + 1) + ". " + product);
                        }
                    }
                    if (coincidences == 0) {
                        System.out.println("Ничего не найдено");
                    }

                }
                default -> {
                }
            }


        }
    }
}
