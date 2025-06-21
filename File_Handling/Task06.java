package File_Handling;

import java.io.*;
import java.io.*;

class Task06 {
    public static void main(String args[]) {
        try {
            FileInputStream infile = new FileInputStream("FileName01.txt");
            FileOutputStream outfile = new FileOutputStream("NewFile05new.txt",true);
           // byte b=0;
            int byteread = infile.read();

            while (byteread != -1) {
                outfile.write(byteread);
                byteread = infile.read();
            }

            infile.close();
            outfile.close();

            System.out.println("Byte Copied From NewFile01.txt to NewFile05.txt File");
        } catch (FileNotFoundException e) {
            System.out.println("Sorry..!! File Not Found...!!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}