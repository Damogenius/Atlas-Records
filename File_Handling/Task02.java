package File_Handling;

import java.io.*;
public class Task02
{
    public static void main(String args[])
    {
        FileInputStream infile = null;
        int b;
        try
        {
            infile = new FileInputStream("FileName01.txt");
            while((b = infile.read()) != -1)
            {
                System.out.printf("%c ",(char)b);
            }
            infile.close();
        }
        catch(IOException e)
        {
            System.out.println("Sorry..!! File Not Found...!!!");
        }
    }
}

