package yandex.java.bankomat;

/*
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BankomatTest {
    private Bankomat bankomat;
    @BeforeEach
    public void init() {
        Map<Bankomat.Nominals, Integer> addMoney = new HashMap<>();
        addMoney.put(Bankomat.Nominals.R5000, 10);
        addMoney.put(Bankomat.Nominals.R2000, 10);
        addMoney.put(Bankomat.Nominals.R1000, 10);
        addMoney.put(Bankomat.Nominals.R500, 10);
        addMoney.put(Bankomat.Nominals.R100, 10);
        addMoney.put(Bankomat.Nominals.R50, 10);

        bankomat = new Bankomat();
        bankomat.bank(addMoney);
    }

    @Test
    public void testAmount1() {
        Map<Bankomat.Nominals, Integer> check = new HashMap<>();
        check.put(Bankomat.Nominals.R5000, 1);
        check.put(Bankomat.Nominals.R1000, 1);
        check.put(Bankomat.Nominals.R500, 1);

        Assertions.assertEquals(check, bankomat.getMoney(6500));
    }

    @Test
    public void testAmount2() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            bankomat.getMoney(1000000);
        });
    }

    @Test
    public void testEmpty() {
        bankomat = new Bankomat();
        Assertions.assertThrows(RuntimeException.class, () -> {
            bankomat.getMoney(1000000);
        });
    }
}

