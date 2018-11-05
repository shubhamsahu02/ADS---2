/**.
 * Imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructor for solution class.
     */
    private Solution() {
        }
    /**
     * Main method.
     *
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] m  = new int[n][n];
        Graph graph = new Graph(n * n + 2);
        while (sc.hasNext()) {
            String[] location = sc.nextLine().split(" ");
            int row = Integer.parseInt(location[0]);
            int col = Integer.parseInt(location[1]);
            m[row - 1][col - 1] = 1;
        }
        Percolation per = new Percolation();
        System.out.println(per.check(m, graph, n));
    }
}