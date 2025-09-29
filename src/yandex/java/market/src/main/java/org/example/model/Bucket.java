package yandex.java.market.src.main.java.org.example.model;

import java.util.List;

public class Bucket {

    private List<Buy> items;

    public Bucket(){}

    public Bucket(List<Buy> items) {
        this.items = items;
    }

    public List<Buy> getItems() {
        return items;
    }

    public void setItems(List<Buy> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "items=" + items +
                '}';
    }
}
