import java.util.Scanner;

public class sudoku_solver {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);                
                if (j == 2 || j == 5){
                    System.out.print("|");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (i == 2 || i == 5){
                System.out.print("-----------------");
                System.out.println();
            }
        }

        board = enterPuzzle(board, input);

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);                
                if (j == 2 || j == 5){
                    System.out.print("|");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (i == 2 || i == 5){
                System.out.print("-----------------");
                System.out.println();
            }
        }
        
        input.close();
    }
    public static int[][] enterPuzzle(int[][] b, Scanner input){
        int[][] puzzle = b;
        //boolean sfsg = true;
        boolean nsfsg = true;
        //int v = 0;
        //int h = 0;
        char e = '0';
        String ee = "";
        //int num;

        for(int i = 0; i < 9; i++){
            //int tot = i+1;
            System.out.println("Enter line " + (i+1) +" of puzzle (horizontal)");
            for(int j = 0; j < 9; j++){
                while(nsfsg){
                    //tot = j+1;
                    System.out.print("Number " + (j+1) + ":");
                    ee = input.nextLine();//.charAt(0);
                    e = ee.charAt(0);
                    if(Character.isDigit(ee.charAt(0))){
                        puzzle[i][j] = e;
                        System.out.println(puzzle[i][j]);// bug here/ always adds 48 to input?
                        nsfsg = false;                
                    }
                }
                nsfsg = true;
                System.out.println();
            }

            System.out.println("Is this correct? (Y/N):");
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j]);                
                if (j == 2 || j == 5){
                    System.out.print("|");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            e = input.nextLine().charAt(0);
            if(e == 'Y' || e == 'y'){
                if(i < 8){
                    continue;
                }
            }
            else{
                i--;
                continue;
            }

            System.out.println("Is this puzzle correct? (Y/N):");
            while(nsfsg){
                for (int ii = 0; ii < puzzle.length; ii++){
                    for (int j = 0; j < puzzle[ii].length; j++) {
                        System.out.print(puzzle[ii][j]);                
                        if (j == 2 || j == 5){
                            System.out.print("|");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    if (ii == 2 || ii == 5){
                        System.out.print("-----------------");
                        System.out.println();
                    }
                }
            }
            System.out.println();
            e = input.nextLine().charAt(0);
            if(e == 'Y' || e == 'y'){
                
            }
            else{
                i = -1;
                continue;
            }
        }
        

        return puzzle;
    }
    

}
