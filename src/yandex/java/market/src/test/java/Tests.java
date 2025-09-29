package yandex.java.market.src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yandex.java.market.src.main.java.org.example.model.Bucket;
import yandex.java.market.src.main.java.org.example.model.Buy;
import yandex.java.market.src.main.java.org.example.model.Client;

import java.math.BigDecimal;
import java.util.List;

public class Tests {

    private Client client;
    private Bucket bucket;
    private List<Buy> buys;


    @BeforeEach
    public void init() {
        client.setId(1);
        buys.add(new Buy(1, new BigDecimal(10), new BigDecimal(5)));
        buys.add(new Buy(2, new BigDecimal(22), new BigDecimal(6)));
        buys.add(new Buy(3, new BigDecimal(33), new BigDecimal(7)));
        buys.add(new Buy(4, new BigDecimal(44), new BigDecimal(8)));
        buys.add(new Buy(5, new BigDecimal(55), new BigDecimal(9)));
        buys.add(new Buy(6, new BigDecimal(2), new BigDecimal(33)));
        bucket.setItems(buys);
    }

    @Test
    public void test() {
        // проверка на скидку
        // проверка на наличие товара в магазе
        // проверка на то не заблокированы платежные средства у клиента
        // проверка на наличие цены
        // проверка на наличие id
        // проверка на количество знаком после запятой
    }
}
