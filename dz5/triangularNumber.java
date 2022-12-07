package dz5;
import input.inputInt;

public class triangularNumber {
    public static void main(String[] args) {
        int n = inputInt.inputIntNam("Введите число");
        int triangulNum = (int)(0.5*(double)n*(n+1));
        System.out.printf("треугольное число из %s ровняется %s",n,triangulNum);
    }
}


// public class inputInt {
//     public static int inputIntNam (String hi) {
//         int num=0;
//         Scanner in = new Scanner(System.in);
//         System.out.println(hi);
//         try  {
//             num = in.nextInt();
//             if(num<1){
//                 System.out.println("число должно быть положительным, попробуйте еще разок:");
//                 num = inputIntNam(hi);
//             }
//         } catch (Exception e) {
//             System.out.println("Вупс, ошибочка, это не число, попробуйте еще разок:");
//             num = inputIntNam(hi);
//         }
//         in.close();

//         return num;
        
//     }
// }



