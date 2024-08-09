package ru.moisei;

import java.util.Random;
import java.util.Scanner;

/**
 * Урок 4
 */
    //Домашнее задание
    //1. Полностью разобраться с кодом, попробовать переписать с нуля.
    //2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
    //например, с использованием циклов.
public class mainApp {
    private static char[][] map;
    private static final int SIZE = 3;
    private static final char map_Empty = '*';
    private static final char dot_X = 'X';
    private static final char dot_0 = '0';
    private static Scanner scanner;
    private static Random random;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (isMapFull()) {
                System.out.println("игра окончена. Ничья!");
                break;
            }
            if (checkWin('X')) {
                System.out.println("игра окончена. Победил игрок!");
                break;
            }
            aiTurn();
            printMap();
            if (isMapFull()) {
                System.out.println("игра окончена. Ничья");
                break;
            }
            if (checkWin('0')) {
                System.out.println("игра окончена. Поюедил AI");
                break;
            }
        }
    }

    public static boolean checkWin(char element) {
        int w1 = 0, w2 = 0, w3 = 0, w4 = 0, w5 = 0, w6 = 0, w7 = 0, w8 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - j - 1 && map[i][j] == element) {
                    if (w1 == 3) {
                        return true;
                    }
                }
                if (i == j && map[i][j] == element) {
                    w2++;
                    if (w2 == 3) {
                        return true;
                    }
                }
                if (i == 0 && map[i][j] == element) {
                    w3++;
                    if (w3 == 3) {
                        return true;
                    }
                }
                if (i == 1 && map[i][j] == element) {
                    w4++;
                    if (w4 == 3) {
                        return true;
                    }
                }
                if (i == 2 && map[i][j] == element) {
                    w5++;
                    if (w5 == 3) {
                        return true;
                    }
                }
                if (j == 0 && map[i][j] == element) {
                    w6++;
                    if (w6 == 3) {
                        return true;
                    }
                }
                if (j == 1 && map[i][j] == element) {
                    w7++;
                    if (w7 == 3) {
                        return true;
                    }
                }
                if (j == 2 && map[i][j] == element) {
                    w8++;
                    if (w8 == 3) {
                        return true;
                    }
                    if (map[0][0] == element && map[1][1] == element && map[2][2] == element) return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!ilCellEmty(x, y));
        map[x][y] = dot_0;
        System.out.println("aI выполнил ход по кординатам " + (x + 1) + " " + (y + 1) + " ");
    }

    public static boolean ilCellEmty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if (map[x][y] != map_Empty) {
            return false;
        }
        return true;
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход введите кординаты (Х Y)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!ilCellEmty(x, y));
        map[x][y] = dot_X;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[j][i] = map_Empty;

            }

        }
    }
}