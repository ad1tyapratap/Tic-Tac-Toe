import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        // ===== UC1: Create and initialize board =====
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        printBoard(board);

        // ===== UC2: Toss =====
        Random random = new Random();
        int toss = random.nextInt(2);

        char player1Symbol;
        char player2Symbol;
        int currentPlayer;

        if (toss == 0) {
            currentPlayer = 1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = 2;
            player1Symbol = 'O';
            player2Symbol = 'X';
        }

        System.out.println("\nPlayer " + currentPlayer + " starts first.");

        // ===== UC3: Input =====
        int slot = getUserInput();

        // ===== UC4: Convert slot to row & column =====
        int[] position = convertSlotToPosition(slot);
        int row = position[0];
        int col = position[1];

        System.out.println("Row: " + row + ", Column: " + col);

        // (Preview of next step)
        board[row][col] = (currentPlayer == 1) ? player1Symbol : player2Symbol;

        printBoard(board);
    }

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC3: Input method
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return scanner.nextInt();
    }

    // ===== UC4: Conversion method =====
    public static int[] convertSlotToPosition(int slot) {

        slot = slot - 1; // convert to 0-based index

        int row = slot / 3;
        int col = slot % 3;

        return new int[]{row, col};
    }
}