package project4;

public class Project4 {

    public static void main(String[] args) {

        int[][] xOBoard = new int[3][3];
        int a = whichPlayer();

        for (int i = 0; i < 9; i++) {
            printBoard(xOBoard);
            if (a == 0) {
                if (i % 2 == 0) {
                    playXO(xOBoard, a);
                    if (checkWinner(xOBoard)) {
                        printBoard(xOBoard);
                        System.out.println("congratulations! you won.");
                        break;
                    }
                } else {
                    computrePlay(xOBoard, a);
                    if (checkWinner(xOBoard)) {
                        printBoard(xOBoard);
                        System.out.println("Good luck! computer won!");
                        break;
                    }
                }
            } else {
                if (i % 2 == 1) {
                    playXO(xOBoard, a);
                    if (checkWinner(xOBoard)) {
                        printBoard(xOBoard);
                        System.out.println("congratulations! you won.");
                        break;
                    }
                } else {
                    computrePlay(xOBoard, a);
                    if (checkWinner(xOBoard)) {
                        printBoard(xOBoard);
                        System.out.println("Good luck! computer won!");
                        break;
                    }
                }
            }
            if (i == 8) {
                printBoard(xOBoard);
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

    public static void playXO(int[][] list, int a) {
        int x, y;
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Enter the position as a (row-column) separated by a space : ");
            x = input.nextInt();
            y = input.nextInt();
            while(x < 0 || x > 2 || y < 0 || y > 2){
                System.out.println("invalid input, the row/column should be from 0 to 2\n"
                                 + "              *******************                  \n"
                                 + "Enter the position as a (row-column) separated by a space : ");
                x = input.nextInt();
                y = input.nextInt();
                
            }
            if (list[x][y] == 0) {
                list[x][y] = (a == 0) ? 'X' : 'O';
                break;
            } else {
                System.out.println("No, it should be an empty position!");
            }
        }
    }

    public static void computrePlay(int[][] list, int a) {

        if ((list[0][0] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[0][0] == list[0][1]) && (list[0][2] == 0)) {
                list[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[1][0]) && (list[2][0] == 0)) {
                list[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[1][1]) && (list[2][2] == 0)) {
                list[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[0][2]) && (list[0][1] == 0)) {
                list[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[2][0]) && (list[1][0] == 0)) {
                list[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[2][2]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[0][2] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[0][2] == list[0][1]) && (list[0][0] == 0)) {
                list[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[1][2]) && (list[2][2] == 0)) {
                list[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[1][1]) && (list[2][0] == 0)) {
                list[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[2][2]) && (list[1][2] == 0)) {
                list[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[2][0]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }

        }
        if ((list[2][2] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[2][2] == list[1][2]) && (list[0][2] == 0)) {
                list[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][2] == list[2][1]) && (list[2][0] == 0)) {
                list[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][2] == list[1][1]) && (list[0][0] == 0)) {
                list[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][2] == list[2][0]) && (list[2][1] == 0)) {
                list[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[2][0] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[2][0] == list[2][1]) && (list[2][2] == 0)) {
                list[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][0] == list[1][1]) && (list[0][2] == 0)) {
                list[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][0] == list[1][0]) && (list[0][0] == 0)) {
                list[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[0][1] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[0][1] == list[1][1]) && (list[2][1] == 0)) {
                list[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][1] == list[2][1]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[1][0] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[1][0] == list[1][1]) && (list[1][2] == 0)) {
                list[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[1][0] == list[1][2]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[1][2] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[1][2] == list[1][1]) && (list[1][0] == 0)) {
                list[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[2][1] == ((a == 0) ? 'O' : 'X'))) {
            if ((list[2][1] == list[1][1]) && (list[0][1] == 0)) {
                list[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[0][0] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[0][0] == list[0][1]) && (list[0][2] == 0)) {
                list[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[1][0]) && (list[2][0] == 0)) {
                list[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[1][1]) && (list[2][2] == 0)) {
                list[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[0][2]) && (list[0][1] == 0)) {
                list[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[2][0]) && (list[1][0] == 0)) {
                list[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][0] == list[2][2]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[0][2] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[0][2] == list[0][1]) && (list[0][0] == 0)) {
                list[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[1][2]) && (list[2][2] == 0)) {
                list[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[1][1]) && (list[2][0] == 0)) {
                list[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[2][2]) && (list[1][2] == 0)) {
                list[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][2] == list[2][0]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }

        }
        if ((list[2][2] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[2][2] == list[1][2]) && (list[0][2] == 0)) {
                list[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][2] == list[2][1]) && (list[2][0] == 0)) {
                list[2][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][2] == list[1][1]) && (list[0][0] == 0)) {
                list[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][2] == list[2][0]) && (list[2][1] == 0)) {
                list[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[2][0] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[2][0] == list[2][1]) && (list[2][2] == 0)) {
                list[2][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][0] == list[1][1]) && (list[0][2] == 0)) {
                list[0][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[2][0] == list[1][0]) && (list[0][0] == 0)) {
                list[0][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[0][1] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[0][1] == list[1][1]) && (list[2][1] == 0)) {
                list[2][1] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[0][1] == list[2][1]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[1][0] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[1][0] == list[1][1]) && (list[1][2] == 0)) {
                list[1][2] = (a == 0) ? 'O' : 'X';
                return;
            }
            if ((list[1][0] == list[1][2]) && (list[1][1] == 0)) {
                list[1][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[1][2] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[1][2] == list[1][1]) && (list[1][0] == 0)) {
                list[1][0] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if ((list[2][1] == ((a == 0) ? 'X' : 'O'))) {
            if ((list[2][1] == list[1][1]) && (list[0][1] == 0)) {
                list[0][1] = (a == 0) ? 'O' : 'X';
                return;
            }
        }
        if (list[1][1] == 0) {
            list[1][1] = (a == 0) ? 'O' : 'X';
            return;
        }
        if ((list[0][2] == ((a == 0)? 'X' : 'O'))
            && (list[2][0] == ((a == 0)? 'X' : 'O'))
            && (list[1][1] == ((a == 0)? 'O' : 'X'))
            && (list[1][2] == 0)){
            list[1][2] = (a == 0)? 'O' : 'X';
            return;
        } if ((list[0][2] == ((a == 0)? 'X' : 'O'))
            && (list[2][0] == ((a == 0)? 'X' : 'O'))
            && (list[1][1] == ((a == 0)? 'O' : 'X'))
            && (list[2][1] == 0)){
            list[2][1] = (a == 0)? 'O' : 'X';
            return;
        } if ((list[0][2] == ((a == 0)? 'X' : 'O'))
            && (list[2][1] == ((a == 0)? 'X' : 'O'))
            && (list[1][1] == ((a == 0)? 'O' : 'X'))
            && (list[1][2] == 0)){
            list[1][2] = (a == 0)? 'O' : 'X';
            return;
        }
        
        else {
            for (int i = 0; i < list.length - 1; i++) {
                for (int j = 0; j < list.length - 1; j++) {
                    if ((list[i][j] == ((a == 0) ? 'O' : 'X')) && (list[i + 1][j + 1] == 0)) {
                        list[i + 1][j + 1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i][j] == ((a == 0) ? 'O' : 'X')) && (list[i][j + 1] == 0)) {
                        list[i][j + 1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i][j] == ((a == 0) ? 'O' : 'X')) && (list[i + 1][j] == 0)) {
                        list[i + 1][j] = (a == 0) ? 'O' : 'X';
                        return;
                    }else if ((list[i][j+1] == 0 && (list[i][j] == ((a == 0) ? 'O' : 'X')))) {
                        list[i][j+1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i+1][j] == 0) && (list[i][j] == ((a == 0) ? 'O' : 'X'))) {
                        list[i+1][j] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i+1][j+1] == 0) && (list[i][j] == ((a == 0) ? 'O' : 'X'))) {
                        list[i+1][j+1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i+1][j] == ((a == 0) ? 'O' : 'X')) && (list[i][j] == 0)) {
                        list[i][j] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i][j+1] == ((a == 0) ? 'O' : 'X')) && (list[i][j] == 0)) {
                        list[i][j] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i+1][j+1] == ((a == 0) ? 'O' : 'X')) && (list[i][j] == 0)) {
                        list[i][j] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i][j] != 0) && (list[i + 1][j + 1] == 0)) {
                        list[i + 1][j + 1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i][j] != 0) && (list[i][j + 1] == 0)) {
                        list[i][j + 1] = (a == 0) ? 'O' : 'X';
                        return;
                    } else if ((list[i][j] != 0) && (list[i + 1][j] == 0)) {
                        list[i + 1][j] = (a == 0) ? 'O' : 'X';
                        return;
                    }

                }
            }
        }
        outer:
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i][j] == 0) {
                    list[i][j] = (a == 0) ? 'O' : 'X';
                    break outer;
                }
            }

        }
    }

}
