import java.util.Scanner;
import java.util.ArrayList;

public class sudoku_solver {

    public static void main(String[] args) {
        char[][] board = {{'-','-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-','-'},{'-','-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-','-'},{'-','-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-','-'},{'-','-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-','-'},{'-','-','-','-','-','-','-','-','-'}};

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

        //board = enterPuzzle(board, input);

        //char[][] puzzle = b;
        //boolean sfsg = true;
        //boolean nsfsg = true;
        boolean notok = true;
        char e = '0';
        String ee = "";
        int num = 0;
        int num2 = 0;
        ArrayList<Integer> candidate0 = new ArrayList<Integer>();
        ArrayList<Integer> candidateall = new ArrayList<Integer>();
        ArrayList<Integer> candidateedit = new ArrayList<Integer>();
        ArrayList<ArrayList> candidatelist = new ArrayList<ArrayList>();
        candidate0.add(0);
        for(int i = 0; i < 10; i++){
            candidatelist.add(candidate0);
        }
        for(int i = 0; i < 10; i++){
            candidateall.add(i);
        }

        //candidatelist.add(candidateall);



        System.out.println(candidatelist);
        /*System.out.println(candidatelist.get(11));

        candidateedit = candidatelist.get(11);
        System.out.println(candidateedit);
        candidateedit.remove(4);
        System.out.println(candidateedit);
        candidatelist.set(11, candidateedit);
        System.out.println(candidatelist);*/


        
        
        for(int i = 0; i < 9; i++){
            //int tot = i+1;
            System.out.println("Enter line " + (i+1) +" of puzzle (horizontal)");
            candidatelist.add(candidate0);
            for(int j = 0; j < 9; j++){
                while(notok){
                    //tot = j+1;
                    System.out.print("Number " + (j+1) + " (if empty, enter 0):");
                    ee = input.nextLine();//.charAt(0);
                    e = ee.charAt(0);
                    if(Character.isDigit(ee.charAt(0))){
                        num =  e - '0';// bug fix- casting char to int mixed up ascii table
                        System.out.println(num);// bug actually here
                        if(num == 0){
                            candidatelist.add(candidateall);
                        }
                        else{
                            //candidate0.set(0, num);
                            //System.out.println(candidatelist);
                            candidate0 = new ArrayList<Integer>();
                            candidate0.add(num);
                            candidatelist.add(candidate0); //maybe make new candidate0 every time?
                            //candidate0.set(0, 0);
                            System.out.println(candidatelist);
                            board[i][j] = e;
                        }
                        //board[i][j] = e;
                        System.out.println(board[i][j]);// bug here/ always adds 48 to input?
                        num2 = (i+1) * 10;
                        num2 = num2 + (j+1);
                        System.out.println(num2);
                        System.out.println(candidatelist.get(num2));
                        notok = false;                
                    }
                }
                notok = true;
                System.out.println();
            }

            System.out.println("Is this correct? (Y/N):");
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
            while(notok){
                for (int ii = 0; ii < board.length; ii++){
                    for (int j = 0; j < board[ii].length; j++) {
                        System.out.print(board[ii][j]);                
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
                notok = false;
                System.out.println();
                e = input.nextLine().charAt(0);
                if(e == 'Y' || e == 'y'){

                }
                else{
                    i = -1;
                    //continue;
                }
            }
            notok = true;
        }

        System.out.println(candidatelist);
        //end enterpuzzle

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
    public static char[][] enterPuzzle(char[][] b, Scanner input){
        char[][] puzzle = b;
        //boolean sfsg = true;
        //boolean nsfsg = true;
        boolean notok = true;
        char e = '0';
        String ee = "";
        //int num;

        for(int i = 0; i < 9; i++){
            //int tot = i+1;
            System.out.println("Enter line " + (i+1) +" of puzzle (horizontal)");
            for(int j = 0; j < 9; j++){
                while(notok){
                    //tot = j+1;
                    System.out.print("Number " + (j+1) + ":");
                    ee = input.nextLine();//.charAt(0);
                    e = ee.charAt(0);
                    if(Character.isDigit(ee.charAt(0))){
                        puzzle[i][j] = e;
                        System.out.println(puzzle[i][j]);// bug here/ always adds 48 to input?
                        notok = false;                
                    }
                }
                notok = true;
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
            while(notok){
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
