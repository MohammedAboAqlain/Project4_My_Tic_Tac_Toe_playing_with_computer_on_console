package project4;

public class Project4 {

    public static void main(String[] args) {

        int[][] XOBoard = new int[3][3];
        int a = whichPlayer();

        for (int i = 0; i < 9; i++) {
            printBoard(XOBoard);
            if (a == 0) {
                if (i % 2 == 0) {
                    playXO(XOBoard, a);
                    if (checkWinner(XOBoard)) {
                        printBoard(XOBoard);
                        System.out.println("congratulations! you won.");
                        break;
                    }
                } else {
                    computrePlay(XOBoard, a);
                    if (checkWinner(XOBoard)) {
                        printBoard(XOBoard);
                        System.out.println("Good luck! computer won!");
                        break;
                    }
                }
            } else {
                if (i % 2 == 1) {
                    playXO(XOBoard, a);
                    if (checkWinner(XOBoard)) {
                        printBoard(XOBoard);
                        System.out.println("congratulations! you won.");
                        break;
                    }
                } else {
                    computrePlay(XOBoard, a);
                    if (checkWinner(XOBoard)) {
                        printBoard(XOBoard);
                        System.out.println("Good luck! computer won!");
                        break;
                    }
                }
            }
            if (i == 8) {
                printBoard(XOBoard);
                System.out.println("the game finished with no winner");
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
        int x, y;
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Enter the position as a (row-column) separated by a space : ");
            x = input.nextInt();
            y = input.nextInt();
            if (XOBoard[x][y] == 0) {
                XOBoard[x][y] = (a == 0) ? 'X' : 'O';
                break;
            } else {
                System.out.println("No, it should be an empty position!");
            }
        }
    }

    public static void computrePlay(int[][] XOBoard, int a) {

        if ((XOBoard[0][0] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[0][0] == XOBoard[0][1]) && (XOBoard[0][2] == 0)) {
                XOBoard[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[1][0]) && (XOBoard[2][0] == 0)) {
                XOBoard[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[1][1]) && (XOBoard[2][2] == 0)) {
                XOBoard[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[0][2]) && (XOBoard[0][1] == 0)) {
                XOBoard[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[2][0]) && (XOBoard[1][0] == 0)) {
                XOBoard[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[2][2]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[0][2] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[0][2] == XOBoard[0][1]) && (XOBoard[0][0] == 0)) {
                XOBoard[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[1][2]) && (XOBoard[2][2] == 0)) {
                XOBoard[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[1][1]) && (XOBoard[2][0] == 0)) {
                XOBoard[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[2][2]) && (XOBoard[1][2] == 0)) {
                XOBoard[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[2][0]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }

        }
        if ((XOBoard[2][2] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[2][2] == XOBoard[1][2]) && (XOBoard[0][2] == 0)) {
                XOBoard[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][2] == XOBoard[2][1]) && (XOBoard[2][0] == 0)) {
                XOBoard[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][2] == XOBoard[1][1]) && (XOBoard[0][0] == 0)) {
                XOBoard[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][2] == XOBoard[2][0]) && (XOBoard[2][1] == 0)) {
                XOBoard[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[2][0] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[2][0] == XOBoard[2][1]) && (XOBoard[2][2] == 0)) {
                XOBoard[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][0] == XOBoard[1][1]) && (XOBoard[0][2] == 0)) {
                XOBoard[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][0] == XOBoard[1][0]) && (XOBoard[0][0] == 0)) {
                XOBoard[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[0][1] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[0][1] == XOBoard[1][1]) && (XOBoard[2][1] == 0)) {
                XOBoard[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][1] == XOBoard[2][1]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[1][0] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[1][0] == XOBoard[1][1]) && (XOBoard[1][2] == 0)) {
                XOBoard[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[1][0] == XOBoard[1][2]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[1][2] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[1][2] == XOBoard[1][1]) && (XOBoard[1][0] == 0)) {
                XOBoard[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[2][1] == ((a == 0) ? 'O' : 'X'))) {
            if ((XOBoard[2][1] == XOBoard[1][1]) && (XOBoard[0][1] == 0)) {
                XOBoard[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[0][0] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[0][0] == XOBoard[0][1]) && (XOBoard[0][2] == 0)) {
                XOBoard[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[1][0]) && (XOBoard[2][0] == 0)) {
                XOBoard[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[1][1]) && (XOBoard[2][2] == 0)) {
                XOBoard[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[0][2]) && (XOBoard[0][1] == 0)) {
                XOBoard[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[2][0]) && (XOBoard[1][0] == 0)) {
                XOBoard[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][0] == XOBoard[2][2]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[0][2] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[0][2] == XOBoard[0][1]) && (XOBoard[0][0] == 0)) {
                XOBoard[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[1][2]) && (XOBoard[2][2] == 0)) {
                XOBoard[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[1][1]) && (XOBoard[2][0] == 0)) {
                XOBoard[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[2][2]) && (XOBoard[1][2] == 0)) {
                XOBoard[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][2] == XOBoard[2][0]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }

        }
        if ((XOBoard[2][2] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[2][2] == XOBoard[1][2]) && (XOBoard[0][2] == 0)) {
                XOBoard[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][2] == XOBoard[2][1]) && (XOBoard[2][0] == 0)) {
                XOBoard[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][2] == XOBoard[1][1]) && (XOBoard[0][0] == 0)) {
                XOBoard[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][2] == XOBoard[2][0]) && (XOBoard[2][1] == 0)) {
                XOBoard[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[2][0] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[2][0] == XOBoard[2][1]) && (XOBoard[2][2] == 0)) {
                XOBoard[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][0] == XOBoard[1][1]) && (XOBoard[0][2] == 0)) {
                XOBoard[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[2][0] == XOBoard[1][0]) && (XOBoard[0][0] == 0)) {
                XOBoard[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[0][1] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[0][1] == XOBoard[1][1]) && (XOBoard[2][1] == 0)) {
                XOBoard[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[0][1] == XOBoard[2][1]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[1][0] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[1][0] == XOBoard[1][1]) && (XOBoard[1][2] == 0)) {
                XOBoard[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((XOBoard[1][0] == XOBoard[1][2]) && (XOBoard[1][1] == 0)) {
                XOBoard[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[1][2] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[1][2] == XOBoard[1][1]) && (XOBoard[1][0] == 0)) {
                XOBoard[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((XOBoard[2][1] == ((a == 0) ? 'X' : 'O'))) {
            if ((XOBoard[2][1] == XOBoard[1][1]) && (XOBoard[0][1] == 0)) {
                XOBoard[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if (XOBoard[1][1] == 0) {
            XOBoard[1][1] = (a == 0) ? 'O' : 'X';
            return;
        } else {
            for (int i = 0; i < XOBoard.length - 1; i++) {
                for (int j = 0; j < XOBoard.length - 1; j++) {
                    if ((XOBoard[i][j] != 0) && (XOBoard[i + 1][j + 1] == 0)) {
                        XOBoard[i + 1][j + 1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((XOBoard[i][j] != 0) && (XOBoard[i][j + 1] == 0)) {
                        XOBoard[i][j + 1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((XOBoard[i][j] != 0) && (XOBoard[i + 1][j] == 0)) {
                        XOBoard[i + 1][j] = (a == 0) ? 'O' : 'X';
                        return;
                    }

                }
            }
        }
        outer:
        for (int i = 0; i < XOBoard.length; i++) {
            for (int j = 0; j < XOBoard.length; j++) {
                if (XOBoard[i][j] == 0) {
                    XOBoard[i][j] = (a == 0) ? 'O' : 'X';
                    break outer;
                }
            }

        }
    }

}
