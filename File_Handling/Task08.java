package File_Handling;

import java.io.File;

public class Task08 {
    public static void main(String[] args) {
        File f1=new File("NewFile05.txt");
        File f2= new File("FileName05.txt");
        boolean success = f1.renameTo(f2);

        if (success) {
            System.out.println("Rename File " +f1+" To "+f2+" Sucessfully ");
        } else {
            System.out.println("Failed to rename file.");
        }


}
}
