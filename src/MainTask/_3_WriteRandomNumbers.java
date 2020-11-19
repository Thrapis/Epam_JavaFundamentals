package MainTask;

import java.util.Random;
import java.util.Scanner;

public class _3_WriteRandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print("Enter count of random numbers: ");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt() + " ");
        }
        for (int i = 0; i < count; i++) {
            System.out.println(random.nextInt());
        }
    }
}
