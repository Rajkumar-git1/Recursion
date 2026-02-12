import java.util.Scanner;

class NQueen2 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        solve(0, n, cols, diag1, diag2);

        System.out.println("Number of solutions = " + count);
    }

    static void solve(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // base case
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row - col + n] && !diag2[row + col]) {

                // place queen
                cols[col] = true;
                diag1[row - col + n] = true;
                diag2[row + col] = true;

                solve(row + 1, n, cols, diag1, diag2);

                // backtrack
                cols[col] = false;
                diag1[row - col + n] = false;
                diag2[row + col] = false;
            }
        }
    }
}
