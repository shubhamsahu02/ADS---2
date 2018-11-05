/**.
 * imports scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * main function
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String synsetsFileName = scan.nextLine();
        String hypernymsFileName = scan.nextLine();
        WordNet wordNet = new WordNet("\\Files\\" + synsetsFileName,
                                      "\\Files\\" + hypernymsFileName);
        //LinearProbingHashST<> hashst =
        String line = scan.nextLine();
        switch (line) {
        case "Graph":
            wordNet.printGraph();
            break;
        case "Queries":
            String[] tokens1 = scan.nextLine().split(" ");
            if (tokens1[0].equals("null") || tokens1[1].equals("null")) {
                System.out.println("IllegalArgumentException");
            }
            break;
        } 

    }
}
