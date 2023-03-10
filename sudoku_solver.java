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
        //step1- establish board, display board

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

        //step2- user inputs puzzle- 1 shortcut
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
        for(int i = 1; i < 10; i++){
            candidateall.add(i);
        }

        /*candidatelist.add(candidateall);
        System.out.println(candidatelist);
        System.out.println(candidatelist.get(11));
        candidateedit = candidatelist.get(11);
        System.out.println(candidateedit);
        candidateedit.remove(4);
        System.out.println(candidateedit);
        candidatelist.set(11, candidateedit);
        System.out.println(candidatelist);*/
        
        
        for(int i = 0; i < 3; i++){ //shortcut for debug- 'i' will be 9 at finish
            //int tot = i+1;
            System.out.println("Enter line " + (i+1) +" of puzzle (horizontal)");
            candidate0 = new ArrayList<Integer>();
            candidate0.add(0);
            candidatelist.add(candidate0);
            for(int j = 0; j < 9; j++){
                while(notok){
                    //tot = j+1;
                    System.out.print("Number " + (j+1) + " (if empty, enter 0):");
                    ee = input.nextLine();//.charAt(0);
                    e = ee.charAt(0);
                    if(Character.isDigit(ee.charAt(0))){
                        num =  e - '0';// bug fix- casting char to int mixed up ascii table
                        //System.out.println(num);// bug actually here
                        if(num == 0){
                            candidatelist.add(candidateall);
                        }
                        else{
                            //candidate0.set(0, num);
                            //System.out.println(candidatelist);
                            candidate0 = new ArrayList<Integer>();
                            candidate0.add(num);
                            candidatelist.add(candidate0); //maybe make new candidate0 every time?
                            //System.out.println(candidatelist);
                            board[i][j] = e;
                        }
                        //board[i][j] = e;
                        //System.out.println(board[i][j]);// bug here/ always adds 48 to input?
                        num2 = (i+1) * 10;
                        num2 = num2 + (j+1);
                        //System.out.println(num2);
                        //System.out.println(candidatelist.get(num2));
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
                if(i < 2){// shortcut for debug- should be (i < 8)
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
                //System.out.println();
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

        //System.out.println(candidatelist);
        //end enterpuzzle

        //step3- narrow down possibilities in boxes
        for(int i = 11; i < 20; i++){
            System.out.print(candidatelist.get(i));
        }
        System.out.println();



        narrow_down(candidatelist, candidateedit, board);
        //int[] box1 = {11,12,13,21,22,23,31,32,33};
        //int[] box2 = {14,15,16,24,25,26,34,35,36};
        //int[] box3 = {17,18,19,27,28,29,37,38,39};
        //int[] box4 = {41,42,43,51,52,53,61,62,63};
        //int[] box5 = {44,45,46,54,55,56,64,65,66};
        //int[] box6 = {47,48,49,57,58,59,67,68,69};
        //int[] box7 = {71,72,73,81,82,83,91,92,93};
        //int[] box8 = {74,75,76,84,85,86,94,95,96};
        //int[] box9 = {77,78,79,87,88,89,97,98,99};
        //box_nd(box1, num, list, e, b);
        //box_nd(box2, num, list, e, b);

        //ArrayList<Integer> nu = new ArrayList<Integer>();
        //box_nd(box3, nu, candidatelist, candidateedit, board);
        /*int n;
        for(int i : box3){
            int v = i % 10;
            int h = (i - v) / 10;
            if(board[h-1][v-1] != '-'){
                n = (int) board[h-1][v-1] - '0';
                nu.add(n);
            }
        }
        System.out.println(nu);
        for(int i : box3){
            int v = i % 10;
            int h = (i - v) / 10;
            if(board[h-1][v-1] == '-'){
                candidateedit = candidatelist.get(i);
                for(int j = 0; j < nu.size(); j++){
                    for(int k = 0; k < candidateedit.size(); k++){
                        if(nu.get(j) == candidateedit.get(k)){
                            candidateedit.remove(k);
                        }
                    }                    
                }
                candidatelist.set(i, candidateedit);
            }
        }*/



        for(int i = 11; i < 20; i++){
            System.out.print(candidatelist.get(i));
        }
        System.out.println();

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
    public static ArrayList<ArrayList> narrow_down(ArrayList<ArrayList> l, ArrayList<Integer> e, char[][] b){
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        list = l;
        ArrayList<Integer> num = new ArrayList<Integer>(); 
        //char[][] puzzle = b;
        //boolean sfsg = true;
        //boolean notok = true;
        //char e = '0';
        //String ee = "";
        //int n;
        /*candidatelist.add(candidateall);
        System.out.println(candidatelist);
        System.out.println(candidatelist.get(11));
        candidateedit = candidatelist.get(11);
        System.out.println(candidateedit);
        candidateedit.remove(4);
        System.out.println(candidateedit);
        candidatelist.set(11, candidateedit);
        System.out.println(candidatelist);*/

        //boxes, horizontal, vertical
        //boxes
        //box1
        int[] box1 = {11,12,13,21,22,23,31,32,33};
        int[] box2 = {14,15,16,24,25,26,34,35,36};
        int[] box3 = {17,18,19,27,28,29,37,38,39};
        int[] box4 = {41,42,43,51,52,53,61,62,63};
        int[] box5 = {44,45,46,54,55,56,64,65,66};
        int[] box6 = {47,48,49,57,58,59,67,68,69};
        int[] box7 = {71,72,73,81,82,83,91,92,93};
        int[] box8 = {74,75,76,84,85,86,94,95,96};
        int[] box9 = {77,78,79,87,88,89,97,98,99};
        box_nd(box1, num, list, e, b);
        num.clear();
        box_nd(box2, num, list, e, b);
        num.clear();
        box_nd(box3, num, list, e, b);
        //num.clear();
        //box_nd(box4, num, list, e, b);
        //box_nd(box5, num, list, e, b);
        //box_nd(box6, num, list, e, b);
        //box_nd(box7, num, list, e, b);
        //box_nd(box8, num, list, e, b);
        //box_nd(box9, num, list, e, b);

        /*for(int i : box){
            v = i % 10;
            h = (i - v) / 10;
            if(b[h][v] != '-'){
                n = (int) b[h][v];
                num.add(n);
            }
        }
        for(int i : box){
            v = i % 10;
            h = (i - v) / 10;
            if(b[h][v] == '-'){
                e = list.get(i);
                for(int j = 0; j < num.size(); j++){
                    for(int k = 0; k < e.size(); k++){
                        if(num.get(j) == e.get(k)){
                            e.remove(k);
                        }
                    }                    
                }
            }
        }*/

        

        return list;
    }
    public static void box_nd(int[] bx, ArrayList<Integer> num, ArrayList<ArrayList> l, ArrayList<Integer> e, char[][] b){
        int n;
        for(int i : bx){
            int v = i % 10;
            int h = (i - v) / 10;
            if(b[h-1][v-1] != '-'){
                n = (int) b[h-1][v-1] - '0';
                num.add(n);
            }
        }
        System.out.println(num);
        for(int i : bx){
            int v = i % 10;
            int h = (i - v) / 10;
            if(b[h-1][v-1] == '-'){
                e = l.get(i);
                for(int j = 0; j < num.size(); j++){
                    for(int k = 0; k < e.size(); k++){
                        if(num.get(j) == e.get(k)){
                            e.remove(k);
                        }
                    }                    
                }
                l.set(i, e);
            }
        }
    }
    

}
