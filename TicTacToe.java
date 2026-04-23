import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        // ===== UC1: Initialize board =====
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

        // ===== UC3 + UC4 + UC5 combined =====
        int row, col;

        while (true) {
            int slot = getUserInput();

            int[] position = convertSlotToPosition(slot);
            row = position[0];
            col = position[1];

            if (isValidMove(board, row, col)) {
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        // Place move
        char symbol = (currentPlayer == 1) ? player1Symbol : player2Symbol;
        board[row][col] = symbol;

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

    // UC3: Input
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return scanner.nextInt();
    }

    // UC4: Convert slot → row, col
    public static int[] convertSlotToPosition(int slot) {
        slot = slot - 1;
        int row = slot / 3;
        int col = slot % 3;
        return new int[]{row, col};
    }

    // ===== UC5: Validation =====
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Check bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}