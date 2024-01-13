package yandex.java.bankomat;

/*
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */

import java.util.HashMap;
import java.util.Map;

public class Bankomat {

    public enum Nominals {
        R50(50),
        R100(100),
        R500(500),
        R1000(1000),
        R2000(2000),
        R5000(5000);

        final Integer value;

        Nominals(Integer value) {
            this.value = value;
        }
    }

    public Map<Nominals, Integer> banknotes;

    public Bankomat() {
        this.banknotes = new HashMap<>();
    }

    public Bankomat(Map<Nominals, Integer> banknotes) {
        this.banknotes = new HashMap<>(banknotes);
    }

    public void bank(Map<Nominals, Integer> banknotes) {
        this.banknotes.putAll(banknotes);
    }

    public Map<Nominals, Integer> getMoney(int amount) {
        if (banknotes.isEmpty()) {
            throw new RuntimeException("There are not enough funds in the ATM!");
        }
        Map<Nominals, Integer> result = new HashMap<>();
        Nominals[] nominals = Nominals.values();
        int index = nominals.length - 1; // Начинаем с самого большого номинала
        while (amount > 0 && index >= 0) {
            int currentNominal = nominals[index].value;
            if (amount >= currentNominal && banknotes.containsKey(nominals[index]) && banknotes.get(nominals[index]) > 0) {
                int numBanknotes = Math.min(amount / currentNominal, banknotes.get(nominals[index]));
                result.put(nominals[index], numBanknotes);
                amount -= currentNominal * numBanknotes;
            }
            index--; // Переходим к следующему номиналу
        }
        if (amount > 0) {
            throw new RuntimeException("It is impossible to issue the specified amount in banknotes available");
        }
        return result;
    }
}