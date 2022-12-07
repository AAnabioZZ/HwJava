package input;

import java.util.Scanner;



public class inputInt {
    public static int inputIntNam (String hi) {
        int num=0;
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите "+hi+": ");
        try  {
            num = in.nextInt();
            if(num<1){
                System.out.println("Число должно быть положительным, попробуйте еще разок:");
                num = inputIntNam(hi);
            }
        } catch (Exception e) {
            System.out.printf("Вупс, ошибочка, это не %s, попробуйте еще разок:",hi);
            num = inputIntNam(hi);
        }
        in.close();

        return num;
        
    }
}
