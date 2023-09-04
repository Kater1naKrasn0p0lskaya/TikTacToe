import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char[][] map;
    private static final int SIZE = 3;
    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        humanTurn();
        printMap();
        aiTurn();
        printMap();
    }

    private static void aiTurn() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        }
        while (!isCellValid(x, y));
        System.out.println("Компьютер походил на " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    private static void humanTurn() {
        Scanner sc = new Scanner(System.in);
        int x, y;
        do {
            System.out.println("Введите координаты");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    private static boolean isCellValid(int x, int y) {
        if (x >= SIZE || y <= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int k = 0; k < SIZE; k++) {
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                map[i][k] = DOT_EMPTY;
            }
        }
    }
}