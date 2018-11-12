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
     * Time complexity of this method is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberof = Integer.parseInt(scan.nextLine());
        String[] a = new String[numberof];
        for (int i = 0; i < numberof; i++) {
            a[i] = scan.nextLine();
        }
        int b = a[0].length();
        LSD lsd = new LSD();
        lsd.sort(a, b);
        System.out.println(lsd);
    }
}
