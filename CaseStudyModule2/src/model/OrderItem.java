package model;

public class OrderItem {
    private long id;
    private double price;
    private int quantity;
    private long orderId;
    private int productId;
    private String productName;
    private long total;



    public OrderItem(long id, double price, int quantity, long orderId, int productId, String productName, long total) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.total = total;
    }

    public static OrderItem parseOrderItem(String record) {
        String[] fileds = record.split(",");
        long id = Long.parseLong(fileds[0]);
        double price = Double.parseDouble(fileds[1]);
        int quantity = Integer.parseInt(fileds[2]);
        long orderId = Long.parseLong(fileds[3]);
        int productId = Integer.parseInt(fileds[4]);
        String productName = fileds[5];
        long total = Long.parseLong(fileds[6]);
        OrderItem orderItem = new OrderItem(id, price, quantity, orderId, productId, productName,total);

        return orderItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return id + ","
                + price + ","
                + quantity + ","
                + orderId + ","
                + productId + ","
                + productName + ","
                + total;

    }
}
