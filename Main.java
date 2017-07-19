/**
 * Created by Jiachen on 7/19/17.
 * For testing the Lagrange backtracking algorithm.
 */
public class Main {
    public static void main(String args[]) {
        int start = Integer.parseInt(args[0]);
        int stop = Integer.parseInt(args[1]);
        for (int i = start; i <= stop; i++) {
            System.out.print(i + " >> ");
            for (int q : Lagrange.findSumRB(i))
                System.out.print("[" + q + "]");
            System.out.println();
        }
    }
}
