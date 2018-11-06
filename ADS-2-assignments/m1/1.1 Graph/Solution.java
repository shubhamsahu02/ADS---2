/**.
 * Imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution
 */
public final class Solution {
    /**.
     * Constructs the object for Solution
     */
    private Solution() {

    }
    /**.
     * Main function which demonstrates operations
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        int vertices = scan.nextInt();
        int edges = scan.nextInt();
        scan.nextLine();
        LinearProbingHashST<Integer, String> hashst = new
        LinearProbingHashST<>();
        String[] places = scan.nextLine().split(",");
        for (int i = 0; i < places.length; i++) {
            hashst.put(i, places[i]);
        }
        switch (type) {
        case "List":
            Graph graph = new Graph(vertices);
            while (scan.hasNext()) {
                String[] tokens = scan.nextLine().split(" ");
                graph.addEdge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]));
            }
            System.out.println(graph.numberofVertices() + " vertices, "
                + graph.numberofEdges() + " edges");
            if (graph.numberofEdges() == 0) {
                System.out.println("No edges");
                break;
            }
            for (int i = 0; i < graph.numberofVertices(); i++) {
                StringBuffer str = new StringBuffer();
                str.append(hashst.get(i) + ": ");
                for (int w : graph.adj(i)) {
                    str.append(hashst.get(w) + " ");
                }
                System.out.println(str.toString());
            }
            break;
        case "Matrix" :
            AdjMatrixGraph matrixgraph = new AdjMatrixGraph(vertices);
            while (scan.hasNext()) {
                String[] tokens1 = scan.nextLine().split(" ");
                matrixgraph.addEdge(Integer.parseInt(tokens1[0]),
                    Integer.parseInt(tokens1[1]));
            }
            System.out.println(matrixgraph.numberofVertices() + " vertices, "
                + matrixgraph.numberofEdges() + " edges");
            if (matrixgraph.numberofEdges() == 0) {
                System.out.println("No edges");
                break;
            }
            System.out.println(matrixgraph.toString());
            break;
        default:
            break;
        }
    }
}


