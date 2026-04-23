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

        // ===== UC3–UC7: Play one turn each =====

        // ---- Player Turn ----
        playHumanTurn(board, currentPlayer, player1Symbol, player2Symbol);
        printBoard(board);

        // Switch player
        currentPlayer = (currentPlayer == 1) ? 2 : 1;

        // ---- Computer Turn ----
        char computerSymbol = (currentPlayer == 1) ? player1Symbol : player2Symbol;
        computerMove(board, computerSymbol);

        printBoard(board);
    }

    // ===== Human Turn =====
    public static void playHumanTurn(char[][] board, int currentPlayer,
                                    char player1Symbol, char player2Symbol) {

        char symbol = (currentPlayer == 1) ? player1Symbol : player2Symbol;

        int row, col;

        while (true) {
            int slot = getUserInput();

            int[] position = convertSlotToPosition(slot);
            row = position[0];
            col = position[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, symbol);
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // ===== Computer Move (UC7) =====
    public static void computerMove(char[][] board, char symbol) {
        Random random = new Random();
        int row, col;

        while (true) {
            int slot = random.nextInt(9) + 1;

            int[] position = convertSlotToPosition(slot);
            row = position[0];
            col = position[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, symbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // ===== Input =====
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return scanner.nextInt();
    }

    // ===== Convert slot → row, col =====
    public static int[] convertSlotToPosition(int slot) {
        slot = slot - 1;
        int row = slot / 3;
        int col = slot % 3;
        return new int[]{row, col};
    }

    // ===== Validate move =====
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    // ===== Place move =====
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // ===== Print board =====
    public static void printBoard(char[][] board) {
        System.out.println("\nTic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}