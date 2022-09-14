package view;

import model.Order;
import model.OrderItem;
import model.Product;
import service.*;
import utils.AppUtils;
import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    private final IProductService productService;
    private final IOrderService orderService;
    private final IOrderItemService orderItemService;
    private final Scanner scanner = new Scanner(System.in);

    public OrderView(){
        productService = ProductService.getInstance();
        orderService = OrderService.getInstance();
        orderItemService = OrderItemService.getInstance();
    }

    public OrderItem addOrderItems(long orderId){
        List<OrderItem> orderItemList = orderItemService.getOrderItems();
        ProductView productView = new ProductView();
        productView.showProducts(InputOption.ADD);
        long id = System.currentTimeMillis()/1000;
        System.out.println("nhap ID san pham :");
        System.out.print(" ==> ");
        int productId = Integer.parseInt(scanner.nextLine());
        while (!productService.existById(productId)){
            System.out.println("id san pham khong ton tai");
            System.out.println("nhap id san pham :");
            System.out.print(" ==> ");
            productId = Integer.parseInt(scanner.nextLine());
        }
        Product product = productService.getProductById(productId);
        double price = product.getPrice();
        int oldQuantity = product.getQuantity();
        int quantity;
        do {
            System.out.println("nhap so luong san pham");
            System.out.print(" ==> ");
            quantity = AppUtils.retryParseInt();
            if (quantity <= 0 || quantity > oldQuantity){
                System.out.println("so luong lon hon 0");
            }
        } while (quantity <= 0 || quantity > oldQuantity);
        String productName = product.getTitle();
        long total = (long) (quantity * price);
        int currentQuantity = oldQuantity - quantity;
        product.setQuantity(currentQuantity);

        productService.update(product);
        OrderItem orderItem = new OrderItem(id,price,quantity, orderId, productId, productName, total);

        return orderItem;

    }
    public void addOrder(){
        try {
            orderService.getOrders();
            long orderId = System.currentTimeMillis()/1000;
            System.out.println("nhap ho va ten");
            System.out.print(" ==> ");
            String name = scanner.nextLine();
            while (!ValidateUtils.isNameValid(name)){
                System.out.println("ten"+ name + "khong dung" + "vui long nhap lai " + "(ten phai viet hoa chu cai va khong co dau)");
                System.out.println("nhap ten");
                System.out.print(" ==> ");
                name = scanner.nextLine();
            }
            System.out.println("nhap so dien thoai");
            System.out.print(" ==> ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)){
                System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("nhap so dien thoai");
                System.out.print(" ==> ");
                phone = scanner.nextLine();
            }
            System.out.println("nhap dia chi");
            System.out.print(" ==> ");
            String address;
            while ((address = scanner.nextLine()).isEmpty()){
                System.out.println("nhap dia chi");
                System.out.print(" ==> ");
            }

            OrderItem orderItem = addOrderItems(orderId);
            Order order = new Order(orderId, name, phone, address);
            orderItemService.add(orderItem);

            orderService.add(order);
            System.out.println("da tao duoc don hang");

            do {
                System.out.println("|============================================|");
                System.out.println("|                                            |");
                System.out.println("|      Nhấn 'a' để tạo tiếp đơn hàng         |");
                System.out.println("|      Nhấn 'b' để trở lại                   |");
                System.out.println("|      Nhấn 'd' để thoát                     |");
                System.out.println("|                                            |");
                System.out.println("|============================================|");

                System.out.println("CHON CHUC NANG");
                System.out.print(" ==> ");
                String choice = scanner.nextLine();
                switch (choice){
                    case "a":
                        addOrder();
                        break;
                    case "b":
                        OrderViewLauncher.run();
                        break;
                    case "c":

                        break;
                    case "d":
                        AppUtils.exist();
                        break;
                    default:
                        System.out.println("nhap khong dung vui long nhap lai");
                }
            } while (true);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("nhap sai hay nhap lai");
        }
    }



        public void showAllOrder() {
        List<Order> orders = orderService.getOrders();
        List<OrderItem> orderItems = orderItemService.getOrderItems();
        OrderItem newOrderItem ;
        try {
            System.out.println(" |= = = = = = = = = = = = = = = =  LIST PRODUCT ORDER  = = = = = = = = = = = = = = = = = = = = =  = = = = = = = = = = = = = = = = == = = = = = = = = = = = = = = = = = = = = = = = = = |");
            System.out.println(" |                                                                                                                                                                                      |");
            System.out.printf("|%-15s %-25s %-12s %-15s %-25s %-15s %-15s %-15s %-21s\n|", "   Id", "Tên khách hàng", "  SĐT", "Địa chỉ", "Tên Sản Phẩm", "Màu sắc", "Số lượng", "   Giá", "   Tổng" + "|");
            for (Order order1 : orders) {
                for (OrderItem orderItem1 : orderItems) {
                    if (orderItem1.getOrderId() == order1.getId()) {
                        newOrderItem = orderItem1;
                        Product product = productService.getProductById(newOrderItem.getProductId());
                        System.out.printf("%-15s %-25s %-12s %-15s %-25s %-15s %-15s %-21s %-7s\n|",
                                order1.getId(),
                                order1.getName(),
                                order1.getPhone(),
                                order1.getAddress(),
                                newOrderItem.getProductName(),
                                product.getColor(),
                                newOrderItem.getQuantity(),
                                newOrderItem.getPrice(),
                                newOrderItem.getTotal());
                    }
                }

            }
            System.out.println(" |                                                                                                                                                                                  |");
            System.out.println(" |= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  | ");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.print("➾ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exist();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
}
