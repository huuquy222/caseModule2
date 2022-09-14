package service;

import model.Order;
import utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderService  implements IOrderService{
    public static String path = "data/order.csv";
    public static  OrderService instance;
    public OrderService(){

    }

    public static OrderService getInstance(){
        if (instance == null)
            instance = new OrderService();
        return instance;
    }
    @Override
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtil.read(path);
        for (String  record: records) {
            orders.add(Order.parse(record));
        }
        return orders;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orders = getOrders();
        orders.add(newOrder);
        CSVUtil.write(path, orders);

    }

    @Override
    public void update() {
        List<Order> orders = getOrders();
        CSVUtil.write(path, orders);

    }

    @Override
    public Order getOrderById(int id) {
        List<Order> orders = getOrders();
        for (Order order : orders) {
            if (order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getOrderById(id) != null;
    }

    @Override
    public void remove(Order order) {
        List<Order> orders = getOrders();
        orders.remove(order);
        update();
    }
}