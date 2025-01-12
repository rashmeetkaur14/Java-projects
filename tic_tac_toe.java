

import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] board = new char[3][3];
        char ch1 = ' ', ch2 = ' ';
        boolean validChoice = false;
        int turn = 0;
        int row, col;

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        System.out.println("************ HELLO PLAYERS ************");
        System.out.println("PLEASE ENTER THE NAMES OF THE PLAYERS");
        String player1 = in.nextLine();
        String player2 = in.nextLine();

        System.out.println("What between 0 and X would you like to choose, " + player1 + "?");

        while (!validChoice) {
            ch1 = in.next().charAt(0);
            if (ch1 == '0') {
                ch2 = 'X';
                validChoice = true;
            } else if (ch1 == 'X') {
                ch2 = '0';
                validChoice = true;
            } else {
                System.out.println(player1 + ", please enter a valid symbol (0 or X):");
            }
        }

        System.out.println("So, this leaves " + player2 + " with the symbol " + ch2);
        System.out.println("Before starting, let's understand the positions on the board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((i + 1) + "," + (j + 1) + (j < 2 ? " | " : "  "));
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }

        System.out.println("OKAY, SO PARTICIPANTS, LET'S BEGIN!");

        while (true) {
            boolean validMove = false;
            System.out.println((turn % 2 == 0 ? player1 : player2) + ", enter your position (row and column):");

            while (!validMove) {
                try {
                    row = in.nextInt();
                    col = in.nextInt();

                    if (row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1] == ' ') {
                        board[row - 1][col - 1] = (turn % 2 == 0) ? ch1 : ch2;
                        validMove = true;
                    } else {
                        System.out.println("Invalid position or cell already occupied. Please enter a valid position:");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter two integers for row and column.");
                    in.next(); // Clear invalid input
                }
            }

            // Display the board
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + (j < 2 ? " | " : " "));
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("---------");
                }
            }

            turn++;

            // Check for a winner
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') ||
                        (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')) {
                    System.out.println((turn % 2 == 1 ? player1 : player2) + " has won the game!");
                    return;
                }
            }
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                    (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
                System.out.println((turn % 2 == 1 ? player1 : player2) + " has won the game!");
                return;
            }

            // Check for a draw
            if (turn == 9) {
                System.out.println("It's a draw!");
                return;
            }
        }
    }
}

