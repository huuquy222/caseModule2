package view;

import utils.AppUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static view.MainLauncher.menuOption;

public class ProductViewLauncher {
    public static void run() {
        int number;
        do {
            Scanner scanner = new Scanner(System.in);
            ProductView productView = new ProductView();
            menuClothes();
            try {
                System.out.println("\nChọn chức năng: ");
                System.out.print("➾ ");
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        productView.add();
                        break;
                    case 2:
                        productView.update();
                        break;
                    case 3:
                        productView.remove();
                        break;
                    case 4:
                        productView.showProducts(InputOption.SHOW);
                        break;
                    case 5:
                        productView.sortByPriceOrderByASC();
                        break;
                    case 6:
                        menuOption();
                        break;
                    case 7:
                        AppUtils.exist();
                        break;
                    default:
                        System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        run();
                }
            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void menuClothes() {
        System.out.println();
        System.out.println("|= = = = = = = = = = MAIN CLOTHES = = = = = = = = |");
        System.out.println("|                                                 |");
        System.out.println("|  1. Thêm sản phẩm                               |");
        System.out.println("|  2. Sửa thông tin sản phẩm                      |");
        System.out.println("|  3. Xoá sản phẩm                                |");
        System.out.println("|  4. Hiển thị tất cả sản phẩm                    |");
        System.out.println("|  5. Hiển thị tất cả sản phẩm theo giá tăng dần  |");
        System.out.println("|  6. Trở lại                                     |");
        System.out.println("|  7. Thoát                                       |");
        System.out.println("|                                                 |");
        System.out.println("|= = = = = = = = = = = = = = = = = = = = = = = = =|");
    }
}
