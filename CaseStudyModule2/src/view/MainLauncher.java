package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLauncher {
    public static void launch() {
        AdminView adminView = new AdminView();
        adminView.adminLogin();
        menuOption();
    }

    public static void exit() {
        System.out.println("Good bye ! see you again!!");
        System.exit(2022);
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n Chọn chức năng");
                System.out.print("--->> ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        ProductViewLauncher.run();
                        break;
                    case 2:
                        UserViewLauncher.launch();
                        break;
                    case 3:
                        OrderViewLauncher.run();
                    case 4:

                        exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng, vui lòng nhập lại!");
                        exit();

                }
            } catch (InputMismatchException io) {
                System.out.println("Nhập sai,vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void mainMenu() {
        System.out.println("\t = = = = = = = = = = =  MAIN MENU = = = = = = = = = = = = = ");
        System.out.println("\t =                                                         =");
        System.out.println("\t =     1. Quản lý sản phẩm                                 =");
        System.out.println("\t =     2. Quản lý người dùng                               =");
        System.out.println("\t =     3. Quản lý đơn đặt hàng                             =");
        System.out.println("\t =     4. Thoát chương trình                               =");
        System.out.println("\t =                                                         =");
        System.out.println("\t = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
    }
    public static void orderMenu(){
        System.out.println("\t = = = = = = = = = = = ORDER MENU= = = = = = = = = = = = = =");
        System.out.println("\t =                                                         =");
        System.out.println("\t =     1. Mua sản phẩm                                     =");
        System.out.println("\t =     2. Xem Danh sách khách đã mua hàng                  =");
        System.out.println("\t =     3. Thoát chương trình                               =");
        System.out.println("\t =                                                         =");
        System.out.println("\t = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
    }

}


