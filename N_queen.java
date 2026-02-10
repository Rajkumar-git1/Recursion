import java.util.*;

public class N_queen {

    static List<List<String>> res = new ArrayList<>();

    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];

        // fill board with '.'
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        backtrack(0, board, n);

        // print result
        if (res.size() == 0) {
            System.out.println("No solution exists");
        } else {
            for (List<String> sol : res) {
                for (String row : sol) {
                    System.out.println(row);
                }
                System.out.println(); // space between solutions
            }
        }
    }

    static void backtrack(int row, char[][] board, int n) {
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    static boolean isSafe(int row, int col, char[][] board, int n) {
        // check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board)
            list.add(new String(row));
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        solveNQueens(n);
    }
}
