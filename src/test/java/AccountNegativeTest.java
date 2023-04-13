import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/*    На банковской карте можно напечатать данные владельца.
        Чтобы это сделать, принтеру передают строку с именем и фамилией — например, «Тимоти Шаламе».
        Её получится напечатать, если соблюдены требования:
        •	в строке не меньше 3 и не больше 19 символов,
        •	в строке есть только один пробел,
        •	пробел стоит не в начале и не в конце строки.
*/
@RunWith(Parameterized.class)
public class AccountNegativeTest {
    private final String name;
    private final boolean expected;

    public AccountNegativeTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Имя владельца карты: {0}")
    public static Object[][] getName() {
        return new Object[][]{
                {"    Тимоти Шаламе", false}, // пробелы в начале строки
                {"Тимоти Шаламе  ", false}, // пробелы в конце строки
                {"ТимотиШаламе", false}, // без пробелов
                {"Тимоти Ша ла ме  ", false}, // больше 1го пробела
                {"Т ", false}, // строка меньше 3 символов
                {"   ", false}, // строка из 3х пробелов
                {"Тимоти ШаламеШаламеШаламе", false}, // строка больше 19 символов с 1 пробелом
        };
    }

    @Test
    public void checkNameToEmbossNegativeTest() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss(name));
    }

}
