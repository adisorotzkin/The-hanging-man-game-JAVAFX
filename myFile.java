import java.io.*;
import java.util.Random;

public class myFile
{

    public String [] myReader() throws FileNotFoundException
    {
        String str = "";
        String[] strings = new String[100];
        try
        {
            FileReader fr = new FileReader("File.txt");
            int size =  60;

            char[] data = new char[size];
            fr.read(data);
            fr.close();
            for (int i = 0; i < data.length; i++)
            {
                str += data[i];
            }
            strings = str.split(" ");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return strings;
    }


    public String wordRand(String [] str)
    {
        int index;
        Random r = new Random();
        index = r.nextInt(str.length);
        return str[index];
    }

}
