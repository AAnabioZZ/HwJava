package dz4;

/**
 * wave
 */
public class wave {
    public static void main(String[] args) {
        int[][] map = new int[10][10];

        addVallsInMap(map);

        map[2][2] = -2;// start
        map[map.length - 2][map.length - 7] = -3;// finish
        printArray(map);
        findTreck(2, 2, map);
        printArray(map);
        findFinish(map);

    }
    public static void luckARaund(int[][] arr, int i, int j, int temp) {

        temp = arr[i][j];
        if (temp == -2)
            temp = 0;
        if (arr[i - 1][j] == 0)
            arr[i - 1][j] = temp + 1;
        if (arr[i - 1][j + 1] == 0)
            arr[i - 1][j + 1] = temp + 1;
        if (arr[i][j + 1] == 0)
            arr[i][j + 1] = temp + 1;
        if (arr[i + 1][j + 1] == 0)
            arr[i + 1][j + 1] = temp + 1;
        if (arr[i + 1][j] == 0)
            arr[i + 1][j] = temp + 1;
        if (arr[i + 1][j - 1] == 0)
            arr[i + 1][j - 1] = temp + 1;
        if (arr[i][j - 1] == 0)
            arr[i][j - 1] = temp + 1;
        if (arr[i - 1][j - 1] == 0)
            arr[i - 1][j - 1] = temp + 1;
        // printArray(arr);

    }

    public static void findTreck(int a, int b, int[][] arr) {
        int i = a;
        int j = b;
        int temp = 0;
        boolean wall;
        wall = true;

        if (arr[i][j] == -2)

            luckARaund(arr, i, j, temp);
        faindTr(arr);

    }

    public static void printArray(int[][] map) {

        for (int i = 0; i < map.length; i++) {
            System.out.println();
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] < 0) {
                    System.out.print(map[i][j]);
                } else {
                    System.out.print(" " + map[i][j]);
                }
            }

        }
        System.out.println();
    }

    public static void addVallsInMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if ((i == 0 || i == map.length - 1) || (j == 0 || j == map.length - 1)) {
                    map[i][j] = -1;
                }
                if (i == 6 && 1 < j && j < 7) {
                    map[i][j] = -1;
                }
                if (j == 6 && i < 4) {
                    map[i][j] = -1;
                }
            }

        }

    }

    public static void faindTr(int[][] arr) {
        for (int k = 1; k < 15; k++) {

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] == k) {
                        luckARaund(arr, i, j, arr[i][j]);
                    }
                }

            }
            // printArray(arr);
        }
    }

    public static void findFinish(int arr[][]) {
        int i;
        int j = 0;
        boolean stop = false;

        for (i = 0; i < arr.length && !stop; i++) {
            for (j = 0; j < arr.length && !stop; j++) {
                if (arr[i][j] == -3)
                    stop = true;
            }
        }
        fixTreck(i - 1, j - 1, arr);
    }

    public static void fixTreck(int i, int j, int[][] arr) {
        String result = "->[" + i + "],[" + j + "]";
        int[] indexMin = new int[2];
        int min = 0;
        if (arr[i - 1][j] != -1) {
            min = arr[i - 1][j];
            saveIndex(indexMin, i - 1, j);
        }
        if (arr[i][j + 1] != -1) {
            min = arr[i][j + 1];
            saveIndex(indexMin, i, j + 1);
        }
        if (arr[i + 1][j] != -1) {
            min = arr[i + 1][j];
            saveIndex(indexMin, i + 1, j);
        }
        if (arr[i][j - 1] != -1) {
            min = arr[i][j - 1];
            saveIndex(indexMin, i, j - 1);
        }

        while (arr[i][j] != -2) {
            if (arr[i - 1][j] < min && arr[i - 1][j ] != -3 && arr[i - 1][j ] != -1) {
                min = arr[i - 1][j ];
                saveIndex(indexMin, i - 1, j);
            }
            if (arr[i - 1][j + 1] < min && arr[i - 1][j + 1] != -3 && arr[i - 1][j + 1] != -1) {
                min = arr[i - 1][j + 1];
                saveIndex(indexMin, i - 1, j + 1);
            }
            if (arr[i][j + 1] < min && arr[i][j + 1] != -3 && arr[i][j + 1] != -1) {
                min = arr[i][j + 1];
                saveIndex(indexMin, i, j + 1);
            }
            if (arr[i + 1][j + 1] < min && arr[i + 1][j + 1] != -3 && arr[i + 1][j + 1] != -1) {
                min = arr[i + 1][j + 1];
                saveIndex(indexMin, i + 1, j + 1);
            }
            if (arr[i + 1][j] < min && arr[i + 1][j] != -3 && arr[i + 1][j] != -1) {
                min = arr[i + 1][j];
                saveIndex(indexMin, i + 1, j);
            }
            if (arr[i + 1][j - 1] < min && arr[i + 1][j - 1] != -3 && arr[i + 1][j - 1] != -1) {
                min = arr[i + 1][j - 1];
                saveIndex(indexMin, i + 1, j - 1);
            }
            if (arr[i][j - 1] < min && arr[i][j - 1] != -3 && arr[i][j - 1] != -1) {
                min = arr[i][j - 1];
                saveIndex(indexMin, i, j - 1);
            }
            if (arr[i - 1][j - 1] < min && arr[i - 1][j - 1] != -3 && arr[i - 1][j - 1] != -1) {
                min = arr[i - 1][j - 1];
                saveIndex(indexMin, i - 1, j - 1);
            }
            i = indexMin[0];
            j = indexMin[1];
            result = "->[" + i + "],[" + j + "]" + result;
        }
        System.out.println(result);
    }

    public static void saveIndex(int arr[], int i, int j) {
        arr[0] = i;
        arr[1] = j;
    }
};
