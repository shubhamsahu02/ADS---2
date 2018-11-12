/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * Main method to perform operations.
     * Time complexity of this method is O(E).
     * E is number of edges.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertices = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
        Edge edgeObj;
        EdgeWeightedGraph graph
            = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = scan.nextLine().split(" ");
            edgeObj = new Edge(Integer.parseInt(tokens[0]),
                               Integer.parseInt(tokens[1]),
                               Double.parseDouble(tokens[2]));
            graph.addEdge(edgeObj);
        }
        KruskalMST kruskalmst = new KruskalMST(graph);
        double result = kruskalmst.weight();
        System.out.format("%.5f", +result);
    }
}