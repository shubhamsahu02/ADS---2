/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * class for SOlution
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * main function which checks if graph is bipartite or not
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberofvertices = scan.nextInt();
        int numberofedges = scan.nextInt();
        scan.nextLine();
        Graph graph = new Graph(numberofvertices);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(tokens[0]),
                          Integer.parseInt(tokens[1]));
        }
        Bipartite bipartite = new Bipartite(graph);
        if (bipartite.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}