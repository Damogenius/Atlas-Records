package File_Handling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task01
{
    public static void main(String args[])
    {
        File f1=new File("FileName01.txt");
        FileOutputStream outfile = null;
        byte Text[] = {'I','L','I','K','E','I','N','D','I','A'};
        String obj= new String("\n Trying Something new");
        try
        {
            outfile = new FileOutputStream(f1);
            outfile.write(Text);
            outfile.write(obj.getBytes());
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(-1);
        }
        System.out.println("Write Byte , along with a string");
        System.out.println("Thank You...!!!");
    }
}

