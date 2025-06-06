

import java.util.Objects;
import java.util.Scanner;
public class Task012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String loginid = "damo";
        String pwd = "12345867";
        int Count = 0;

        do{
            System.out.println("you have logged in for  "+ Count++ +" times");
            System.out.println("enter ur login id and password");
            loginid = sc.nextLine();
            pwd = sc.nextLine();
        }while (Objects.equals(loginid, "damo") && Objects.equals(pwd, "1234567"));

    }
}
