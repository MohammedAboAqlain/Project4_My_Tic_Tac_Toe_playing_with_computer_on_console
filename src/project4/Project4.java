package project4;

import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) {

        int[][] XOBoard = new int[3][3];
        Scanner input = new Scanner(System.in);
        int a = whichPlayer(), x, y;

        outer:
        for (int i = 0; i < 9; i++) {
            printBoard(XOBoard);
            if (a == 0) {
                if (i % 2 == 0) {
                    playXO(XOBoard, a);
                    if (checkWinner(XOBoard)) {
                        printBoard(XOBoard);
                        System.out.println("congratulations! you won.");
                        break outer;
                    }
                }else{
                    
                }
            }else{
                if(i % 2 == 1){
                    playXO(XOBoard, 1);
                    if (checkWinner(XOBoard)) {
                        printBoard(XOBoard);
                        System.out.println("congratulations! you won.");
                        break outer;
                    }
                }else{
                    
                }
            }

        }

    }

    public static void printBoard(int[][] list) {
        System.out.println("-------------");

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ((list[i][j] == 'X' || list[i][j] == 'O') && j == list.length - 1) {
                    System.out.println("| " + ((char) list[i][j]) + " |");
                } else if ((list[i][j] == 'X' || list[i][j] == 'O')) {
                    System.out.print("| " + ((char) list[i][j]) + " ");
                } else if (j == list.length - 1) {
                    System.out.println("|   |");
                } else {
                    System.out.print("|   ");
                }

            }
            System.out.println("-------------");
        }
    }

    public static boolean checkWinner(int[][] list) {
        if (((list[0][0] == list[0][1]) && (list[0][0] == list[0][2]) && (list[0][0] != 0))
                || ((list[1][0] == list[1][1]) && (list[1][0] == list[1][2]) && (list[1][0] != 0))
                || ((list[2][0] == list[2][1]) && (list[2][0] == list[2][2]) && (list[2][0] != 0))
                || ((list[0][0] == list[1][0]) && (list[1][0] == list[2][0]) && (list[0][0] != 0))
                || ((list[0][1] == list[1][1]) && (list[1][1] == list[2][1]) && (list[0][1] != 0))
                || ((list[0][2] == list[1][2]) && (list[1][2] == list[2][2]) && (list[0][2] != 0))
                || ((list[0][0] == list[1][1]) && (list[1][1] == list[2][2]) && (list[0][0] != 0))
                || ((list[0][2] == list[1][1]) && (list[1][1] == list[2][0]) && (list[0][2] != 0))) {
            return true;
        }

        return false;
    }

    public static int whichPlayer() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("which player do you want? if player X press 0, otherwise press 1 : ");
        int a = input.nextInt();
        return a;
    }
    
    public static void playXO(int[][] XOBoard, int a) {
        int x,y;
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Enter the row position : ");
            x = input.nextInt();
            System.out.print("Enter the column position : ");
            y = input.nextInt();
            if (XOBoard[x][y] == 0) {
                XOBoard[x][y] = (a == 0)? 'X' : 'O';
                break;
            } else {
                System.out.println("No, it should be an empty position!");
            }
        }
    }

}
