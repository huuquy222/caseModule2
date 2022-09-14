package model;

public class Product {
    private Long id;
    private String title;
    private String color;
    private double price;
    private int quantity;


    public Product(Long id, String title, String color, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {

    }

    public static Product parse(String record){
        String[] fields = record.split(",");
        Long id = Long.parseLong(fields[0]);
        String title = fields[1];
        String color = fields[2];
        int quantity = Integer.parseInt(fields[3]);
        double price = Double.parseDouble(fields[4]);
        return new Product(id, title, color, quantity, price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return String.format("%S,%s,%s,%s,%s",
                id,
                title,
                color,
                quantity,
                price);
    }
}
