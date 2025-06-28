package File_Handling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class New_Demo {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        FileWriter w = null;
        try {
            w = new FileWriter("Demo_file.txt",true);
            w.write(s);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        } finally {
            if (w != null)
                w.close();
        }
        System.out.println("appending");
        System.out.println("Thank You...!!!");
    }
}
