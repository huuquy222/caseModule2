package view;

import service.IUserService;
import service.UserService;
import utils.AppUtils;

import java.util.Scanner;

public class AdminView {
    private final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public AdminView() {
        this.userService = UserService.getInstance();
    }

    public void adminLogin() {
        boolean isRetry;
        System.out.println("/=========================================================/");
        System.out.println("/                                                         /");
        System.out.println("/                       ĐĂNG NHẬP                         /");
        System.out.println("/                                                         /");
        System.out.println("/=========================================================/");



        do {

            System.out.println("Username");
            String username = AppUtils.retryString("Username");
            System.out.println("Password");
            String password = AppUtils.retryString("Password");
            if ((userService.adminLogin(username, password) == null)){
                System.out.println("tài khoản không hợp lệ");
                isRetry = isRetry();
            } else {
                    System.out.println("Bạn đã đăng nhập thành công\n");
                    System.out.println("CHÀO MỪNG QUÝ KHÁCH ĐẾN VỚI CỬA HÀNG QUẦN ÁO NAM\n");
                    isRetry = false;
                }
        } while (isRetry);
    }
    private boolean isRetry(){
        do {
            try {
                System.out.println("|#################### Chọn Chức Năng ####################|");
                System.out.println("|                                                        |");
                System.out.println("|               1.Nhấn 'b' để đăng nhập lại              |");
                System.out.println("|               1.Nhấn 'q' để thoát khỏi chương trình    |");
                System.out.println("|                                                        |");
                System.out.println("|########################################################|");
                System.out.println(" ==> ");
                String option = scanner.nextLine();
                switch (option){
                    case "b":
                        return true;
                    case "q":
                        AppUtils.exist();
                        break;
                    default:
                        System.out.println("Bạn chọn chức năng chưa đúng, vui lòng  chọn lại");
                        break;
                }
            } catch (Exception e){
                System.out.println("Nhập sai vui lòng nhập lại");
                e.printStackTrace();
            }
        } while (true);
    }
}