package utils;

import view.InputOption;

import java.text.DecimalFormat;
import java.util.Scanner;

import static view.InputOption.*;

public class AppUtils {
    public static Object exist;
    public static int retryParseInt;
    static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int i, int i1) {
        int option;
        do {
            System.out.print(" => ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                int max = 5;
                int min = 1;
                if (option > max || option < min) {
                    System.out.println("chọn chức năng chưa đúng , vui lòng chọn lại");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("nhập sai vui lòng nhập lại ");
            }
        } while (true);
        return option;
    }

    public static int enterQuantity() {
        int quantity;
        do {
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                return quantity;
            } catch (Exception e) {
                System.out.println("nhập sai vui lòng nhập lại ");
            }
        } while (true);
    }
    public static double enterPrice() {
        double price;
        do {
            try {
                price = Double.parseDouble(scanner.nextLine());
                return price;
            } catch (Exception e) {
                System.out.println("nhập sai vui lòng nhập lại ");
            }
        } while (true);
    }
    public static String doubleToVND(double value) {
        String patternVND = ",###đ";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static boolean isRetry() {
        do {
            switch (InputOption) {
                case ADD:
                    System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'y' để sửa tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case DELETE:
                    System.out.println("Nhấn 'b' để quay lại \t|\t 't' để thoát khỏi chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'b' để quay lại \t|\t 't' để thoát khỏi chương trình");
                    break;
                default:
                    String inputOption = null;
                    throw new IllegalStateException("Unexpected value :" + inputOption);
            }
            System.out.println(" => ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    return true;
                case "b":
                    return false;
                case "t":
                    AppUtils.exist();
                    break;
                default:
                    System.out.println("Chọn chức năng sai , vui lòng chọn lại");
                    break;
            }
        } while (true);
    }

    public static void exist() {
        System.out.println("\t Good bye , see you again !");
        System.exit(5);
    }

    public static void isRetryNumber() {

    }

    public static boolean isRetry(InputOption show) {
        return false;
    }

    public static int retryParseInt() {
        int result;
        do{
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception e){
                System.out.println("nhap sai vui long nhao lai");
            }
        } while (true);
    }

    public static String retryString(String password) {
        String result;
        System.out.print(" ==> ");
        while ((result = scanner.nextLine()).isEmpty()){
            System.out.printf("%s khong de trong \n");
            //fieldName
            System.out.print(" ==> ");
        }
        return result;
    }

    public static double retryParseDouble() {
        double result;
        do {
            System.out.print(" ==> ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception e){
                System.out.println("nhap sai vui long nhap lai");
            }
        } while (true);
    }

    public static void exist(int i) {
    }
}
