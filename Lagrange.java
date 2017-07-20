import java.util.HashMap;

public class Lagrange {
    private int[] solutions;
    private HashMap<Integer, Integer> hashMap;

    Lagrange(int numSquares, int numInputs) {
        hashMap = new HashMap<>(numInputs);
        solutions = new int[numSquares];
    }

    /**
     * Wrapper method.
     *
     * @param num the number to be factored
     */
    int[] findSumRB(int num) {
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
    private boolean findSumRB(int num, int maxTerms) {
        int sum = 0, index = solutions.length - maxTerms;
        for (int i = index; i < solutions.length; i++) sum += solutions[i];
        if (sum == num) return true;
        else if (maxTerms == 0) return false;
        int shortcut = hashMap.getOrDefault(num, -1);
        if (shortcut != -1) {
            solutions[index] = shortcut * shortcut;
            return findSumRB(num - solutions[index], maxTerms - 1);
        } else for (int i = (int) Math.sqrt(num); i >= 0; i--) {
            solutions[index] = i * i;
            if (findSumRB(num - solutions[index], maxTerms - 1)) {
                hashMap.put(num, i);
                return true;
            }
        }
        return false;
    }

    /**
     * This sqrt int algorithm works by tricking StrictMath.sqrt into believing
     * that x is unsigned, which in this case is exactly what I am looking for. It
     * beats the native method by about a few milliseconds and is bench marked
     * against 6 other sqrt int algorithms. It is the fastest under all circumstances.
     *
     * Bench-marking by Jiachen Ren. See
     * @param x positive int
     * @return floored sqrt of x.
     */
    private static int floorSqrt(int x) {
        return (int) StrictMath.sqrt(x & 0xffffffffL);
    }

    /**
     * @return the hash map created for acceleration.
     */
    HashMap<Integer, Integer> getTable() {
        return hashMap;
    }


}
