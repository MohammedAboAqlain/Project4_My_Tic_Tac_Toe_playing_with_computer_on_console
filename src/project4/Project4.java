
package project4;

public class Project4 {

    
    public static void main(String[] args) {
        
        int[][] XOBoard = new int[3][3];
        XOBoard[1][1] = 'X';
        XOBoard[2][2] = 'O';
        
        printBoard(XOBoard);
    }
    
    public static void printBoard(int[][] list){
            System.out.println("-------------");
            
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if((list[i][j] == 'X' || list[i][j] == 'O') && j == list.length-1)
                    System.out.println("| " + ((char) list[i][j])+ " |");
                else if((list[i][j] == 'X' || list[i][j] == 'O'))
                    System.out.print("| " + ((char) list[i][j])+ " ");                
                else if(j == list.length-1)
                    System.out.println("|   |");
                else
                    System.out.print("|   ");
                
            }
            System.out.println("-------------");
        }
    }
    
}
