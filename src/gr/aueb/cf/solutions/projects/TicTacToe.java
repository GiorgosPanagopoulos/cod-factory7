package gr.aueb.cf.solutions.projects;

import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;  // μέγεθος πίνακα
    private static final char EMPTY = '-';  // κενή θέση
    private static char[][] board = new char[SIZE][SIZE];  // πίνακας παιχνιδιού
    private static char currentPlayer = 'X';  // ο τρέχων παίκτης ('X' ή 'O')

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        boolean gameIsRunning = true;
        while (gameIsRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col, currentPlayer);
                if (checkWin(currentPlayer)) {
                    gameIsRunning = false;
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isBoardFull()) {
                    gameIsRunning = false;
                    printBoard();
                    System.out.println("The game is a tie!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';  // εναλλαγή παίκτη
                }
            } else {
                System.out.println("This move is not valid, try again.");
            }
        }

        scanner.close();
    }

    // αρχικοποίηση πίνακα
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // εκτύπωση του πίνακα
    private static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // έλεγχος για έγκυρη κίνηση
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    // κατάγραφή κίνησης
    private static void makeMove(int row, int col, char player) {
        board[row][col] = player;
    }

    // έλεγχος για νίκη
    private static boolean checkWin(char player) {
        // Έλεγχος γραμμών και στηλών
        for (int i = 0; i < SIZE; i++) {
            if (checkRow(i, player) || checkCol(i, player)) {
                return true;
            }
        }
        // Έλεγχος διαγωνίων
        return checkDiagonals(player);
    }

    private static boolean checkRow(int row, char player) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int col, char player) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonals(char playerChar) {
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != playerChar) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != playerChar) {
                win = false;
                break;
            }
        }
        return win;
    }

    // έλεγχος για πλήρη πίνακα
    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
