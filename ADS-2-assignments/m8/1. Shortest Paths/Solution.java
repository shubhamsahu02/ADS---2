/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * class for solution
 */
public final class Solution {
    /**.
     * Constructs the object for solution class
     */
    private Solution() {

    }
    /**.
     * main function
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        LinearProbingHashST<String, Integer> hashst =
            new LinearProbingHashST<>();
        int vertices = Integer.parseInt(tokens[0]);
        int edges = Integer.parseInt(tokens[1]);
        String[] stations = scan.nextLine().split(" ");
        for (int i = 0; i < stations.length; i++) {
            hashst.put(stations[i], i);
        }
        EdgeWeightedGraph edgeweightedgraph =
            new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens1 = scan.nextLine().split(" ");
            Edge edge = new Edge(hashst.get(tokens1[0]),
                                 hashst.get(tokens1[1]),
                                 Double.parseDouble(tokens1[2]));
            edgeweightedgraph.addEdge(edge);
        }
    }
}