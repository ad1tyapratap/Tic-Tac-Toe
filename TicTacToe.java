import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        // ===== UC1: Create and initialize board =====
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Print empty board
        printBoard(board);

        // ===== UC2: Toss and assign players =====
        Random random = new Random();
        int toss = random.nextInt(2);

        char player1Symbol;
        char player2Symbol;
        int currentPlayer; // 1 or 2

        if (toss == 0) {
            currentPlayer = 1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = 2;
            player1Symbol = 'O';
            player2Symbol = 'X';
        }

        // Display game setup
        System.out.println("\n--- Game Setup ---");
        System.out.println("Toss Result: " + toss);
        System.out.println("Player 1 Symbol: " + player1Symbol);
        System.out.println("Player 2 Symbol: " + player2Symbol);
        System.out.println("Player " + currentPlayer + " starts first.");
    }

    // Method to print the board
    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}