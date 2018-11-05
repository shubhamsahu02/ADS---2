/**.
 * Imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object for SOlution
     */
    private Solution() {

    }
    /**.
     * Main function which explians wheather cycle
     * Exits or not
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        int edges = scan.nextInt();
        scan.nextLine();
        Digraph digraph = new Digraph(vertices);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            digraph.addEdge(Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]));
        }
        DirectedCycle directedcycle = new DirectedCycle(digraph);
        if (directedcycle.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}
