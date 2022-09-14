package view;

import java.util.Scanner;

public class UserViewLauncher {

    public static void launch(){
        Scanner scanner = new Scanner(System.in);
        UserView u = new UserView();
        int option = -1;
        do {
            menuUser();
            try {
                do {
                    System.out.println("Mời bạn chọn chức năng");
                    System.out.println("==> ");
                    option = Integer.parseInt(scanner.nextLine());
                    if (option > 4 || option < 1)
                        System.out.println("Bạn chọn chức năng chưa đúng, vui lòng chọn lại");
                } while (option > 4 || option < 1);
                switch (option){
                    case 1:
                        u.addUser();
                        break;
                    case 2:
                        u.updateUser();
                        break;
                    case 3:
                        u.showUsers(InputOption.UPDATE);
                        break;
                    case 4:
                        menuOption();
                        break;
                    default:
                        System.out.println("Bạn chọn chức năng chưa đúng , vui lòng chọn lại");
                        break;
                }
            } catch (Exception e){
                System.out.println("Bạn nhập sai, hãy nhập lại");
            }
        } while (option != 4);

        }

    private static boolean menuOption() {
        return true;
    }

    private static void menuUser() {
        System.out.println("/============================== USER MANAGER ==================================/");
        System.out.println("/                                                                              /");
        System.out.println("/                         1. Thêm người dùng                                   /");
        System.out.println("/                         2. Sửa thông tin người dùng                          /");
        System.out.println("/                         3. Hiện danh sách người dùng                         /");
        System.out.println("/                         4. Quay lại                                          /");
        System.out.println("/                                                                              /");
        System.out.println("/==============================================================================/");
    }

}
