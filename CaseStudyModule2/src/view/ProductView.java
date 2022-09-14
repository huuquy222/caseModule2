package view;

import model.Product;
import service.IProductService;
import service.ProductService;
import utils.AppUtils;

import java.util.List;
import java.util.Scanner;

import static view.InputOption.*;

public class ProductView {
    private final IProductService productService;
    private final Scanner scanner = new Scanner(System.in);
    public ProductView() {
        productService = ProductService.getInstance();
    }

    public void add() {
        do {
            long id = System.currentTimeMillis()/1000;
            String title = inputTitle(ADD);
            String color = inputColor(ADD);
            int quantity = inputQuantity(ADD);
            double price = inputPrice(ADD);
            Product product = new Product(id, title, color, quantity, price);
            productService.add(product);
            System.out.println("Bạn đã thêm sản phẩm thành công\n");
        } while (AppUtils.isRetry(ADD));
    }

    private int inputQuantity(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số lượng: ");
                break;
            case UPDATE:
                System.out.println("Nhập số lượng bạn muốn sửa: ");
                break;
        }
        int quantity;
        do {
            quantity = AppUtils.retryParseInt();
            if (quantity <=0 || quantity >= 200)
                System.out.println("Số lượng phải lớn hơn 0000 và bé hơn 200 (giá > 0)");
        } while (quantity <= 0  || quantity >= 200);
        return quantity;
    }


    private String inputColor(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập màu sắc sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Nhập màu sắc bạn muốn sửa: ");
                break;

        }
        String result;
        System.out.println("-->> ");
        while ((result = scanner.nextLine()).isEmpty()) {
            System.err.printf("Màu sắc sản phẩm không được để trống \n");
            System.out.print("-->> ");

        }
        return result;
    }

    public void showProducts(InputOption inputOption) {
        System.out.println("|---------------------------------------------------- DANH SÁCH SẢN PHẨM ----------------------------------------------------|");
        System.out.printf("%-15s %-25s %-15s %-15s %-15s\n", "ID", "Tên sản phẩm", "Màu sắc", "Số lượng", "Giá");
        for (Product product : productService.getProducts()) {
            System.out.printf("%-15d %-25s %-15s %-15d %-15s\n",
                    product.getId(),
                    product.getTitle(),
                    product.getColor(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice())
            );
        }
        System.out.println("|------------------------------------------------------------------------------------------------------------------------|\n");
        if (inputOption == SHOW)
            AppUtils.isRetry(SHOW);
    }

    public void remove() {
        showProducts(DELETE);
        int id;
        while (!productService.exist(id = inputId(DELETE))) {
            System.out.println("Không tìm thấy sản phẩm cần xóa!");
            System.out.println("Nhấn 'y' để thêm tiếp sản phẩm\t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
            System.out.print("--->> ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    break;
                case "q":
                    return;
                case "t":
                    AppUtils.exist();
                    break;
                default:
                    System.out.println("Chọn không đúng chức năng! Vui lòng nhập lại");
                    break;

            }
        }

        System.out.println("|-------------------- Bạn có chắc chắn muốn xóa! ---------------------|");
        System.out.println("|  Nhấn 1 để xóa                                                      |");
        System.out.println("|  Nhấn 2 để quay lại.                                                |");
        System.out.println("|---------------------------------------------------------------------|");
        int option = AppUtils.retryChoose(1,2);
        if (option == 1) {
            productService.removeById(id);
            System.out.println("Đã xóa sản phẩm thành công");
            AppUtils.isRetry(DELETE);

        }
    }

    private String  inputTitle(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập tên sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Nhập tên bạn muốn sửa: ");
                break;
        }
        String result;
        System.out.print("-->> ");
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("Tên sản phẩm không được để trống \n");
            System.out.print("-->> ");
        }
        return result;
    }

    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập ID");
                break;
            case UPDATE:
                System.out.println("Nhập ID bạn muốn sửa");
                break;
            case DELETE:
                System.out.println("Nhập ID bạn cần xóa: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = productService.existById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("ID này đã tồn tại.Vui lòng nhập ID khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy ID! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }

    private double inputPrice(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập giá sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Nhập giá bạn muốn sửa: ");
                break;
        }
        double price;
        do {
            price = AppUtils.retryParseDouble();
            if (price < 100 || price >=50000000)
                System.out.println("giá phải lớn hơn 100 && bé hơn 50000000 triệu: ))");
        } while (price < 100 || price >=50000000);
        return price;
    }

    public void showProductsSort(InputOption inputOption, List<Product> products) {
        System.out.println("= = = = = = = = = = = = = = = =  DANH SÁCH SẢN PHẨM  = = = = = = = = = = = = = = = =");
        System.out.printf("%-15s %-25s %-15s %-15s %-15s\n", "ID", "Tên sản phẩm", "Màu sắc", "Số lượng", "Giá");
        for (Product product : products) {
            System.out.printf("%-15s %-25s %-15s %-15s %-15s\n", product.getId(), product.getTitle(), product.getColor(), product.getQuantity(), AppUtils.doubleToVND(product.getPrice()));
        }
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        if (inputOption == SHOW){
            AppUtils.isRetry(SHOW);
        }
    }

    public void sortByPriceOrderByASC() {
        showProductsSort(SHOW, productService.findAllOrderByPriceASC());
    }


    public void update() {
        boolean isRetry;
        do {
            showProducts(UPDATE);
            long id = inputId(UPDATE);
            System.out.println("|=============== SỬA SẢN PHẨM ===================|");
            System.out.println("| 1. Sửa tên sản phẩm                            |");
            System.out.println("| 2. Sửa màu sắc sản phẩm                        |");
            System.out.println("| 3. Sửa số lượng sản phẩm                       |");
            System.out.println("| 4. Sửa giá sản phẩm                            |");
            System.out.println("| 5. Quay lại Menu                               |");
            System.out.println("|================================================|");
            System.out.println("| Chọn chức năng:                                |");
            int option = AppUtils.retryChoose(1, 5);
            Product newProduct = new Product();
            newProduct.setId(id);

            switch (option) {
                case 1:
                    String title = inputTitle(UPDATE);
                    newProduct.setTitle(title);
                    productService.update(newProduct);
                    System.out.println("Tên sản phẩm đã cập nhật thành công");
                    break;
                case 2:
                    String color = inputColor(UPDATE);
                    newProduct.setColor(color);
                    productService.update(newProduct);
                    System.out.println("Màu sắc sản phẩm đã cập nhật thành công");
                    break;
                case 3:
                    int quantity = inputQuantity(UPDATE);
                    newProduct.setQuantity(quantity);
                    productService.update(newProduct);
                    System.out.println("Số lượng sản phẩm đã cập nhật thành công");
                    break;
                case 4:
                    double price = inputPrice(UPDATE);
                    newProduct.setPrice(price);
                    productService.update(newProduct);
                    System.out.println("Bạn đã sửa giá sản phẩm thành công");
                    break;
            }
            isRetry = option != 5 && AppUtils.isRetry(UPDATE);
        }
        while (isRetry);
    }
}

