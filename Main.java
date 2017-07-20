import java.util.ArrayList;

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
        ArrayList<int[]> results = new ArrayList<>(stop - start);
        for (int i = start; i <= stop; i++) {
            results.add(lagrange.findSumRB(i));
        }
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - curTime) + " millis");
        //uncomment the following lines if you want to have control over whether or not to print out the contents.
//        System.out.println("Print content? (Y/N)");
//        if ((new java.util.Scanner(System.in)).nextLine().compareToIgnoreCase("Y") == 0) {
        print(results);
//        }
        System.out.println("Print Table? (Y/N)");
        if ((new java.util.Scanner(System.in)).nextLine().compareToIgnoreCase("Y") == 0)
            for (int key : lagrange.getTable().keySet())
                System.out.println(key + " -> " + lagrange.getTable().get(key));
    }

    private static void print(ArrayList<int[]> solutions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < solutions.size(); i++) {
            int[] segment = solutions.get(i);
            sb.append(i).append(" >> ");
            for (int q : segment)
                sb.append("[").append(q).append("] ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
