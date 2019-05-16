package lesson4;
import java.util.Random;
import java.util.Scanner;
public class XOGame {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin(char symb) {
        for (int j = 0; j < SIZE-1; j++) {
            for (int i = 0; i < SIZE-1; i++) {
                if(map[i][0] == symb && map[i][1] == symb && map[i][2] == symb && map[i][3] == symb) return true;
                if(map[i][1] == symb && map[i][2] == symb && map[i][3] == symb && map[i][4] == symb) return true;


                if(map[0][j] == symb && map[1][j] == symb && map[2][j] == symb && map[3][j] == symb) return true;
                if(map[1][j] == symb && map[2][j] == symb && map[3][j] == symb && map[4][j] == symb) return true;

                if(map[i][0] == symb && map[i+1][1] == symb && map[i+2][2] == symb && map[i+3][3] == symb) return true;
                if(map[i][1] == symb && map[i+1][2] == symb && map[i+2][3] == symb && map[i+3][4] == symb) return true;

                if(map[i][3] == symb && map[i+1][2] == symb && map[i+2][1] == symb && map[i+3][0] == symb) return true;
                if(map[i][4] == symb && map[i+1][3] == symb && map[i+2][2] == symb && map[i+3][1] == symb) return true;


            }


        } return false;
        /*if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;*/
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;

            if (map[0][0] == DOT_X && map[0][1] == DOT_X) {
                x = 2;
                y = 0;
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            } else if (map[1][0] == DOT_X && map[1][1] == DOT_X) {
                x = 2;
                y = 1;
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            } else if (map[2][0] == DOT_X && map[2][1] == DOT_X) {
                x = 2;
                y = 2;
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }else if (map[3][0] == DOT_X && map[3][1] == DOT_X) {
                x = 2;
                y = 3;
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }
            else if (map[4][0] == DOT_X && map[4][1] == DOT_X) {
                x = 2;
                y = 4;
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }


        do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);

                } while (!isCellValid(x, y));



        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

        }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
