package taskjava;


import java.io.FileWriter;
import java.io.IOException;

public class TaskJava3 {

    public static void expCSV(String par){

        if (par=="e") {
            try
            {
                String sFileName="c:\\test3.csv";

                FileWriter writer = new FileWriter(sFileName);

                writer.append("DisplayName");
                writer.append(',');
                writer.append("Age");
                writer.append('\n');

                writer.append("MKYONG");
                writer.append(',');
                writer.append("26");
                writer.append('\n');

                writer.append("YOUR NAME");
                writer.append(',');
                writer.append("29");
                writer.append('\n');

                //generate whatever data you want

                writer.flush();
                writer.close();
                System.out.println("very good");
            }
            catch(IOException e)
            {
                System.out.println("not good="+e.toString());
            }
            System.out.println(par.toString());

        }

    }

    public static void main(String[] args) {
             expCSV("e");

    }
}
