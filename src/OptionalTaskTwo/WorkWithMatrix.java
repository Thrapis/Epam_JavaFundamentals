package OptionalTaskTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WorkWithMatrix {
    public static void main(String[] args) {
        System.out.print("Enter size of matrix: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.print("Enter dispersion: ");
        scanner = new Scanner(System.in);
        int dispersion = scanner.nextInt();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = getRandomNumber(-dispersion, dispersion);
            }
        }

        System.out.println("Matrix = {");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("}");


        System.out.println("-------------------------------------");
        System.out.print("Enter column to sort: ");
        scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        sortByColumn(matrix, k);
        System.out.println("Matrix = {");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("}");

        System.out.println("-------------------------------------");
        System.out.print("Biggest sequence: ");
        ArrayList<Integer> biggestSequence = findBiggestSequence(matrix);
        for (int i = 0; i < biggestSequence.size(); i++) {
            System.out.print(biggestSequence.get(i) + "\t");
        }
        System.out.println("\nLength of biggest sequence: " + biggestSequence.size());
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public static void sortByColumn(int[][] matrix, int k) {
        boolean changes = true;
        while (changes) {
            changes = false;
            for (int i = 0; i + 1 < matrix.length; i++) {
                if (matrix[i][k] > matrix[i + 1][k]) {
                    swapRows(matrix, i, i + 1);
                    changes = true;
                }
            }
        }
    }

    public static void swapRows(int[][] array, int rowA, int rowB) {
        int tmpRow[] = array[rowA];
        array[rowA] = array[rowB];
        array[rowB] = tmpRow;
    }

    public static ArrayList<Integer> findBiggestSequence(int[][] matrix) {
        ArrayList<Integer> biggestSequence = new ArrayList<Integer>();
        ArrayList<Integer> buf = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (buf.size() == 0) {
                    buf.add(matrix[i][j]);
                } else if (buf.get(buf.size() - 1) <= matrix[i][j]) {
                    buf.add(matrix[i][j]);
                } else {
                    break;
                }
            }
            if (biggestSequence.size() < buf.size()) {
                biggestSequence = buf;
            }
            buf = new ArrayList<>();
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (buf.size() == 0) {
                    buf.add(matrix[i][j]);
                } else if (buf.get(buf.size() - 1) <= matrix[i][j]) {
                    buf.add(matrix[i][j]);
                } else {
                    break;
                }
            }
            if (biggestSequence.size() < buf.size()) {
                biggestSequence = buf;
            }
            buf = new ArrayList<>();
        }

        return biggestSequence;
    }

}

