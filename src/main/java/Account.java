/*
В классе Account задай проверки: длина, наличие пробела в начале или конце строки.
 Используй методы класса String. Например, для проверки длины — name.length() >= 3.
     Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
     Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
 */
public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss(String name) {
        int n = 0;
        for (char element : name.toCharArray()) {
            if (element == ' ') {
                n++;
            }
        }
        if (name.length() >= 3 && name.length() <= 19 && n == 1 && !name.startsWith(" ") && !name.endsWith(" ")) {
            System.out.println("Данные владельца карты успешно добавлены");
            return true;
        } else {
            System.out.println("Указаны неверные данные владельца карты: " + "\"" + name + "\"" + ". Повторите попытку ещё раз.");
            return false;
        }
    }
}
