package File_Handling;

import java.io.*;
class Task07
{
    public static void main(String args[])
    {
        try
        {
            FileInputStream file1 = new FileInputStream("FileName01.txt");
            FileInputStream file2 = new FileInputStream("FileName02.txt");
            SequenceInputStream file3 = new SequenceInputStream(file1, file2);
            FileWriter w=new FileWriter("4rd_File",true);
            BufferedInputStream br1 = new BufferedInputStream(file3);
            //BufferedOutputStream br2 = new BufferedOutputStream(System.out);
            //BufferedOutputStream br2 = new BufferedOutputStream("3rd_file.txt");
            int ch;
            while((ch = br1.read())!=-1)
            {
                w.write((char)ch);
            }
            br1.close();
            w.close();
            file1.close();
            file2.close();
            System.out.println("Merge Two File Sucessfully ");
        }
        catch(IOException e)
        {
            System.out.println("Sorry..!! File Not Found...!!!");
        }
    }
}
