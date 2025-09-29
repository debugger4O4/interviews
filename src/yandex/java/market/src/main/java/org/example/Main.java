package yandex.java.market.src.main.java.org.example;

/*
Вы — backend-разработчик в интернет-магазине.
Дела идут в гору и магазин решил повысить лояльность покупателей, предоставляя им персональные скидки.
К вам обратился product owner с задачей создать простую систему лояльности, которая предоставляет процентную скидку на корзину.
Размер скидки зависит от покупателя.
Аналитики уже определили, какие скидки должны быть предоставлены покупателям.


## Определения

Корзина - список покупок покупателя.

Покупка:
- id товара
- цена
- итоговая стоимость c учетом скидки

Скидка. Для покупателя может быть задан % скидки (целое число).


## Задача
Написать часть новой системы лояльности, которая:
- на вход получает id покупателя и корзину
- вычисляет и применяет скидки
- возвращает корзину, в которой учтены скидки. Скидка учитывается в стоимости покупки

*/

import yandex.java.market.src.main.java.org.example.model.Bucket;
import yandex.java.market.src.main.java.org.example.model.Buy;
import yandex.java.market.src.main.java.org.example.model.Client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Client client = new Client(1);
    private static Bucket bucket = new Bucket();
    private static List<Buy> buys = new ArrayList<>();

    public static void main(String[] args) {
        buys.add(new Buy(1, new BigDecimal(10), new BigDecimal(5)));
        buys.add(new Buy(2, new BigDecimal(22), new BigDecimal(6)));
        buys.add(new Buy(3, new BigDecimal(33), new BigDecimal(7)));
        buys.add(new Buy(4, new BigDecimal(44), new BigDecimal(8)));
        buys.add(new Buy(5, new BigDecimal(55), new BigDecimal(9)));
        buys.add(new Buy(6, new BigDecimal(2), new BigDecimal(33)));
        bucket.setItems(buys);
        client.setBucket(bucket);
        client.setDiscount(8);
        System.out.println(task(client).getItems());
    }

    public static Bucket task(Client client) {
        Bucket clientBucket = client.getBucket();
        int discount = client.getDiscount();
        List<Buy> buys = clientBucket.getItems();
        if (discount > 0) {
            buys.forEach(f -> {
                BigDecimal price = f.getPrice();
                f.setPriceWithDiscount(calculateDiscount(price, discount));
            });
        } else {
            buys.forEach(f -> {
                BigDecimal price = f.getPrice();
                f.setPrice(price);
            });
        }
        clientBucket.setItems(buys);
        return clientBucket;
    }

    private static BigDecimal calculateDiscount(BigDecimal price, int discount) {
        return price.subtract(price.divide(new BigDecimal(100)).multiply(new BigDecimal(discount))).setScale(2, RoundingMode.HALF_UP);
    }
}