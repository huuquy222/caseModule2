package service;

import model.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItem> getOrderItems();

    void add(OrderItem newOrderItem);

    void update(OrderItem newOrderItem);

    OrderItem geOrderItemById(int id);
}
