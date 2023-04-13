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
public class AccountPositiveTest {
    private final String name;
    private final boolean expected;

    public AccountPositiveTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Имя владельца карты: {0}")
    public static Object[][] getName() {
        return new Object[][]{
                {"Тимоти Шаламе", true}, // корректное имя 13 символов с 1 пробелом
                {"Т и", true}, // строка = 3 символам с 1 пробелом
                {"Тимоти ШаламеШаламе", true}, // строка = 19 символов с 1 пробелом
        };
    }

    @Test
    public void checkNameToEmbossNegativeTest() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss(name));
    }

}
