/**
 * Created by Jiachen on 7/19/17.
 * For testing the Lagrange backtracking algorithm.
 */
public class Main {
    public static void main(String args[]) {
        int start = Integer.parseInt(args[0]);
        int stop = Integer.parseInt(args[1]);
        Lagrange lagrange = new Lagrange(4, stop - start);
        long curTime = System.currentTimeMillis();
        for (int i = start; i <= stop; i++) {
            System.out.print(i + " >> ");
            for (int q : lagrange.findSumRB(i))
                System.out.print("[" + q + "]");
            System.out.println();
        }
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - curTime) + " millis");
        System.out.println("Print table content? (Y/N)");
        if ((new java.util.Scanner(System.in)).nextLine().compareToIgnoreCase("Y") == 0)
            for (int key: lagrange.getTable().keySet())
                System.out.println(key + " -> " + lagrange.getTable().get(key));
    }

}
