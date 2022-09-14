package service;

import model.OrderItem;
import utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOrderItemService {
    List<OrderItem> orderItems = new ArrayList<>();
    public static String path = "data/orderitem.csv";
    private static OrderItemService instance;

    public OrderItemService(){

    }

    public static OrderItemService getInstance(){
        if (instance == null)
            instance = new OrderItemService();
        return instance;
    }


    @Override
    public List<OrderItem> getOrderItems() {
        List<OrderItem> newOrderItems = new ArrayList<>();
        List<String> records = CSVUtil.read(path);
        for (String record : records) {
            newOrderItems.add(OrderItem.parseOrderItem(record));
        }
        return orderItems = newOrderItems;
    }

    @Override
    public void add(OrderItem newOrderItem) {
        orderItems.add(newOrderItem);
        CSVUtil.write(path, orderItems);

    }

    @Override
    public void update(OrderItem newOrderItem) {
        List<OrderItem> orderItems1 = getOrderItems();
        CSVUtil.write(path,orderItems1);

    }

    @Override
    public OrderItem geOrderItemById(int id) {
        for ( OrderItem orderItem : orderItems) {
            if (orderItem.getId() == id)
                return orderItem;
        }
        return null;
    }
}
