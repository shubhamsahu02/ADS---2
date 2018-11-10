import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner scan = new Scanner(System.in);
		int vertexCount = Integer.parseInt(scan.nextLine());
		int edges = Integer.parseInt(scan.nextLine());
		EdgeWeightedGraph edgeweight = new EdgeWeightedGraph(vertexCount);
		for (int i = 0; i < edges; i++) {
			String[] tokens = scan.nextLine().split(" ");
			int vert = Integer.parseInt(tokens[0]);
			int edg = Integer.parseInt(tokens[1]);
			double weight = Double.parseDouble(tokens[2]);
			Edge edgeObj = new Edge(vert, edg, weight);
			edgeweight.addEdge(edgeObj);
		}
		String caseToGo = scan.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Prints the Graph Object.

			System.out.println(edgeweight);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] tokens = scan.nextLine().split(" ");
			int source = Integer.parseInt(tokens[0]);
			int destination = Integer.parseInt(tokens[2]);
   	        DijkstraUndirectedSP dijkstraObj = new DijkstraUndirectedSP(edgeweight, source);
   	        double distBetween = dijkstraObj.distTo(destination);
   	        System.out.println(distBetween);
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass through.
			// Third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}