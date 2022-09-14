package view;

import java.util.Scanner;

import static view.MainLauncher.menuOption;

public class OrderViewLauncher {
    public static void run(){
        MainLauncher.orderMenu();
        Scanner scanner = new Scanner(System.in);
        OrderView orderView = new OrderView();
        System.out.println("\n moi ban chon chuc nang");
        System.out.print(" ==> ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                orderView.addOrder();
                break;
            case 2:
                orderView.showAllOrder();
                break;
            case 3:
                menuOption();
                break;
            default:
                System.out.println("bạn chọn chức năng không đúng vui lòng chọn lại");
        }
    }
}
