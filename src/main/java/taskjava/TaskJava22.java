package taskjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskJava22 {
    public enum Level { Specilist1, Specilist2, Specilist3, Specilist4,
        Boss1,Boss2,Boss3,Director,CEO1,CEO2,CEO3,CEO4,CEOHead
    };

    public static void main(String[] args) {
        ArrayList<String> hierarchy=new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        String c = in.nextLine();

        String param=null;
        for (String s: args) {
            //System.out.println("parameter ="+s);
            param=s;
        }

        String parts[] = c.split("/");

        System.out.println("hierarchy parmtr=" + param);
        Level level;

        if (param.equals("i")) {
            System.out.println(" By asc    =" + c);
            int i=0;
            for (String s: parts) {
                i++;
                //System.out.println("i ="+i);
                //System.out.println("sortydnik ="+s);
                hierarchy.add(s+" = "+Level.values()[i]);
                //System.out.println("level ="+Level.values()[i]);

            }

        }

        if (param.equals("r")) {
            System.out.println(" By desc    =" + c);
            int i=parts.length;
            for (String s: parts) {
                //System.out.println("i ="+i);
                //System.out.println("sortydnik ="+s);
                hierarchy.add(s+" = "+Level.values()[i]);
                i--;
                //System.out.println("level ="+Level.values()[i]);

            }



        }

        System.out.println("Hierarchy result ");
        for (String h:hierarchy) {
            System.out.println("      ======" + h);
        };

    }

}
