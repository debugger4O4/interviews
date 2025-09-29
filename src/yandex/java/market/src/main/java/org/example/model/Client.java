package yandex.java.market.src.main.java.org.example.model;

public class Client {
    private long id;
    private String name;
    private Bucket bucket;
    private int discount;

    public Client(long id) {
        this.id = id;
    }

    public Client(long id, String name, Bucket bucket, int discount) {
        this.id = id;
        this.name = name;
        this.bucket = bucket;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bucket='" + bucket + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}
