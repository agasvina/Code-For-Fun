import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        String s;
        int n = stdin.nextInt();
        stdin.close();

        int[] occ = new int[10];

        occ[1] = 1;

        for (int i = 0; i < n; i++) {
            int[] occ2 = new int[10];
            occ2[6] += occ[1];
            occ2[8] += occ[1];

            occ2[7] += occ[2];
            occ2[9] += occ[2];

            occ2[4] += occ[3];
            occ2[8] += occ[3];

            occ2[3] += occ[4];
            occ2[9] += occ[4];
            occ2[0] += occ[4];

            occ2[1] += occ[6];
            occ2[7] += occ[6];
            occ2[0] += occ[6];

            occ2[2] += occ[7];
            occ2[6] += occ[7];

            occ2[1] += occ[8];
            occ2[3] += occ[8];

            occ2[4] += occ[9];
            occ2[2] += occ[9];

            occ2[4] += occ[0];
            occ2[6] += occ[0];

            for (int k = 0; k < 10; k++) {
                occ[k] = occ2[k];
            }
        }
        System.out.println(occ[9]);
    }
}
