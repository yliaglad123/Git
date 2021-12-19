import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check {
    public static String inputString() {
        String str=new String();
        boolean s = true;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (s) {
            s = false;
            try{
                str=reader.readLine();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            if (!(str.matches("[A-Яа-яЁё]+"))) {
                System.out.println("Неправильный ввод.");
                s = true;
            }
        }
        return str;
    }
    public static int inputInt(){
        int number=0;
        boolean s = true;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (s) {
            s = false;
            try{
                number=Integer.parseInt(reader.readLine());
            }
            catch (NumberFormatException ex){
                s=true;
                System.out.println("Неверный формат числа");
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return number;
    }
    public static String input() {
        String str=new String();
        boolean s = true;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (s) {
            s = false;
            try {
                str = reader.readLine();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                s = true;
            }
        }
        return str;
    }
}
