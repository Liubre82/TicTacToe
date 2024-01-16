package com.launchgame;

import com.players.HumanPlayer;
import com.players.Player;
import com.players.PlayerFactory;
import com.tictactoeboard.TicTacToe;

import java.util.Scanner;

public class LaunchGame
{

    //creates a delay in our program, delay parameter is in milliseconds.
    public static void setTimeoutSync(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
    {
        boolean endProgram = false;
        TicTacToe board = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        Player p1, p2; //reference var to the 2 Players playing.
        int moves = 0; //count amount of moves, if at move 9 and no winner, it is a tie.

        while(!endProgram) {

            System.out.print("What is your name player1?: ");
            String name = sc.next();
            p1 = new HumanPlayer('X', name);

            /* Selects whether to play with another real person or with the computer. program will
            loop until the correct input is specified. */
            System.out.print("play against who? Type 'person' or 'computer': ");
            String playerType = sc.next().toLowerCase();
            while (!playerType.equals("person") && !playerType.equals("computer")) {
                System.out.print("Invalid name, enter type of opponent, 'person' or 'computer': ");
                playerType = sc.next();
            }

            /* Determining which Player obj to create depending on the inputted player type
            above(dynamic polymorphism) */
            if (playerType.equals("computer")) {
                p2 = new PlayerFactory(playerType, 'O', "computer").getPlayer();
            } else {
                System.out.print("Name of opponent?: ");
                String playerName = sc.next();
                p2 = new PlayerFactory(playerType, 'O', playerName).getPlayer();
            }

            // Select if user want to get first turn or 2nd.
            System.out.print("Would you like to go 1st or 2nd? '1' for 1st, '2' for 2nd: ");
            int order = sc.nextInt();
            Player currPlayer = (order == 1) ? p1 : p2; //reference var tracks which player's turn it is.

            /* game will continue until a player wins or the game ends due to a tie.*/
            while (!TicTacToe.checkWin() && moves < 9) {
                board.displayBoard();
                System.out.println(currPlayer.getName() + "'s turn!\n");

                //set a delay if user is playing with the computer/ai.
                if (currPlayer == p2 && p2.getName().equals("computer")) {
                    setTimeoutSync(2500);
                }

                currPlayer.makeMove(); //sets player's mark on game board.
                moves++; //increment on each move by a player.

                //checks if a player has won on each turn.
                if (TicTacToe.checkWin()) {
                    System.out.println(currPlayer.getName() + " has won!\n");
                    break;
                }
                if (moves >= 9) System.out.println("Its a draw.\n");

                //condition changes the player on each iteration.
                if (currPlayer == p1) currPlayer = p2;
                else currPlayer = p1;
            }
            board.displayBoard();

            System.out.print("Play again? y/n: ");
            String playAgain = sc.next().toLowerCase();

            //condition to ask user if they wish to replay the game.
            if(playAgain.equals("n")) {
                endProgram = true;
                System.out.println("Goodbye!");
            }
            else {
                moves = 0;
                board.initBoard();
            }
        }
    }
}
