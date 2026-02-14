import java.util.*;

class WordSearch {
    static int m, n;
    static char[][] board;
    static String word;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter rows: ");
        m = sc.nextInt();
        System.out.print("Enter columns: ");
        n = sc.nextInt();

        board = new char[m][n];

        // Input board
        System.out.println("Enter board characters:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        // Input word
        System.out.print("Enter word to search: ");
        word = sc.next();

        boolean found = false;

        // Try from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    found = true;
                    break;
                }
            }
        }

        System.out.println("Word exists: " + found);
    }

    static boolean dfs(int i, int j, int index) {
        // base case
        if (index == word.length()) return true;

        // boundary & mismatch check
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found =
                dfs(i + 1, j, index + 1) ||
                dfs(i - 1, j, index + 1) ||
                dfs(i, j + 1, index + 1) ||
                dfs(i, j - 1, index + 1);

        board[i][j] = temp; // backtrack
        return found;
    }
}
