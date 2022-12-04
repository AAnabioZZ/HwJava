package dz3;

public class findOptimal {
    public static void main(String[] args) {
        int a = 3;
        int b = 27;
        int c = 3;
        int d = 2;
        long[] arr = new long[b + 1];
        countTracks(a, b, c, d, arr);
        printArray(a, b, c, d, arr, optomalTreck(a, b, c, d));
        // find -> 3
        // a: 2 b: 7 c: 2 d: 1 -> 3
        // a: 3 b: 27 c: 3 d: 2 -> 6
        // a: 30 b: 345 c: 5 d: 6 -> 0
        // a: 30 b: 345 c: 2 d: 1 -> 7047
        // a: 22 b: 333 c: 3 d: 1 -> 467
        // a: 55 b: 555 c: 5 d: 2 -> 30
        // a: 22 b: 2022 c: 11 d: 56 -> 0
        // a: 22 b: 2022 c: 11 d: 10 -> 18
        // a: 22 b: 2022 c: 3 d: 1 -> 763827
        // a: 22 b: 20220 c: 3 d: 1 -> 535173226980
        // a: 1 b: 1111 c: 2 d: 1 -> 3990330794
        // a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286
    }

    public static String optomalTreck(int a, int temp, int c, int d) {
        String res = "";
        while (temp > a) {
            if ((double) (temp - a) % c == 0) {
                while (temp > a && (temp - a) % c == 0) {
                    temp /= c;
                    res = " * c" + res;
                }
            } else {
                temp -= d;
                res = " + d" + res;
            }
        }
        return res;

    }

    public static void printArray(int a, int b, int c, int d, long[] arr, String str) {
        System.out.printf("a: %d b: %d c: %d d: %d -> %s ", a, b, c, d, arr[b] + "\n");
        System.out.println("a" + str + " = b");

    }

    public static void countTracks(int a, int b, int c, int d, long[] arr) {
        for (int index = a; index < arr.length; index++) {
            if (index == a)
                arr[index] = 1;
            if ((double) index % c == 0 && index / c >= a)
                arr[index] = arr[index / c] + arr[index - d];
            if ((double) index % c == 0 && index / c < a && index - d >= a)
                arr[index] = arr[index - d];
            if ((double) index % c != 0 && index - d >= a)
                arr[index] = arr[index - d];
        }

    }
}

// задать масив длинной с искомое число
// далее проходим по массиву обозначая клетки
// если отстаток от деления на множитель равен 0 то записываем в ячейку сумму из
// разделенной ячейки плюс значение в ячейки (- сложение)
// евли остаток от деление != 0 то фиксируется значение из (- сложение)
// пока индекс не станет = искомому числу
// это максимальное комичество различных путей из точки а в точку б