//Problem        : Mug Color
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;

//Your submission should *ONLY* use the following class name
public class Problem {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = stdin.nextInt();
            }
        }
        stdin.close();
        // row
        int wrongRow = -1;
        int wrongCol = -1;
        int missing = -1;
        for (int i = 0; i < 9; i++) {
            boolean[] nums = new boolean[9];
            for (int j = 0; j < 9; j++) {
                nums[arr[i][j] - 1] = true;
            }
            for (int j = 0; j < 9; j++) {
                if (!nums[j]) {
                    missing = j;
                    wrongRow = i;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] nums = new boolean[9];
            for (int j = 0; j < 9; j++) {
                nums[arr[j][i] - 1] = true;
            }
            for (int j = 0; j < 9; j++) {
                if (!nums[j]) {
                    wrongCol = i;
                }
            }
        }

        System.out
                .println("[" + wrongRow + "," + wrongCol + "]=" + (missing + 1));
    }
}
