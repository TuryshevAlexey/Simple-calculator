import java.io.*;
import java.util.Scanner;

class Main {
    static public void main (String []args) throws Exception{
        //Scanner sc = new Scanner (System.in);
        FileReader fr = new FileReader("/Users/aleksey/IdeaProjects/Hello world/out/production/Hello world/input.txt");
        FileWriter fw = new FileWriter("output.txt");
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()){
            String str = sc.nextLine();

            double a = 0.0;
            double b = 0.0;
            char znak = ' ';
            int m=0;
            boolean is = true;
            for(String num:str.split(" ")) {
                m++;
                if(m==1) {
                    try {
                        a = Double.valueOf(num);
                    }catch(NumberFormatException e) {
                        fw.write(str + " = " + "Error! Not number\n");
                        //fw.close();
                        is = false;
                        break;
                    }
                }
                if(m==3) {
                    try {
                        b = Double.valueOf(num);
                    }catch(NumberFormatException e) {
                        fw.write(str + " = " + "Error! Not number\n");
                        //fw.close();
                        is = false;
                        break;
                    }
                }
            }
            if(is) {
                m=0;
                for(String num:str.split(" ")) {
                    m++;
                    if(m==2) {
                        try {
                            znak = result(num,znak);
                        }catch(Exception s){
                            fw.write(str + " = " + "Operation Error!\n");
                            //fw.close();
                            is=false;
                            break;
                        }
                    }
                }
            }
            if(is) {
                switch (znak) {
                    case ('+'):
                        fw.write(str + " = " + Double.toString(a + b) + "\n");
                        break;
                    case ('-'):
                        fw.write(str + " = " + Double.toString(a - b) + "\n");
                        break;
                    case ('/'):
                        if (b == 0.0) fw.write(str + " = " + "Error! Division by zero\n");
                        else fw.write(str + " = " + Double.toString(a / b) + "\n");
                        break;
                    case ('*'):
                        fw.write(str + " = " + Double.toString(a * b) + "\n");
                        break;
                }
            }
        }
        fw.close();
        sc.close();
        fr.close();
    }
    public static char result(String nms, char znak) throws Exception {
        if(nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            znak = nms.charAt(0);
            return znak;
        }
        else throw new Exception("OperationError");
    }
}


