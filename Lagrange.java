public class Lagrange {
    private static int[] solutions = new int[4];

    public static void main(String[] args) {
        System.out.print("Please enter a number: ");
        findSumRB((new java.util.Scanner(System.in)).nextInt());
        for (int i : solutions) System.out.print(i == 0 ? "" : "[" + i + "] ");
    }

    /**
     * Wrapper method.
     *
     * @param num the number to be factored
     */
    static int[] findSumRB(int num) {
        solutions = new int[solutions.length];
        findSumRB(num, solutions.length);
        return solutions;
    }

    /**
     * Designed by Jiachen Ren. All Rights Reserved.
     *
     * @param num      the number to be decomposed into squared numbers.
     * @param maxTerms the max number of terms allowed.
     * @return whether or not the solution is found.
     * @since July 19th.
     */
    private static boolean findSumRB(int num, int maxTerms) {
        int sum = 0, index = solutions.length - maxTerms;
        for (int i = index; i < solutions.length; i++) sum += solutions[i];
        if (sum == num) return true;
        else if (maxTerms == 0) return false;
        for (int i = (int) Math.sqrt(num); i >= 0; i--) {
            solutions[index] = i * i;
            if (findSumRB(num - solutions[index], maxTerms - 1))
                return true;
        }
        return false;
    }



}
