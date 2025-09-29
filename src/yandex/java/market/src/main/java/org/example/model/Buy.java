package yandex.java.market.src.main.java.org.example.model;

import java.math.BigDecimal;

public class Buy {

    private long id;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

    public Buy() {}

    public Buy(long id, BigDecimal price, BigDecimal priceWithDiscount){
        this.id = id;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", price=" + price +
                ", priceWithDiscount=" + priceWithDiscount +
                '}';
    }
}
