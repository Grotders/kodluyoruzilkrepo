package MayinTarlasi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {


    public static void main(String[] args) {
        init();
    }

    static void init() {
        int row= 3;
        int coloumn= 3;

        String board[][] = setBoard(row,coloumn);
        String mineBoard[][] = setBoard(row,coloumn);
        setMines(mineBoard);

        System.out.println("Mayınların Konumu");
        printBoard(mineBoard);

        boardController(board, mineBoard);
    }

    static void boardController(String[][] board, String[][] mineBoard) {
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        int row, column;
        boolean isGameOver= false;
        boolean isWin= false;

        Scanner keyboard = new Scanner(System.in);

        while (!isGameOver) {
            printBoard(board);
            System.out.print("Satır Giriniz(0-" + (board.length-1) + "): ");
            row = keyboard.nextInt();
            System.out.print("Sütun Giriniz(0-" + (board[0].length-1) + "): ");
            column= keyboard.nextInt();

            if (row >= board.length || column >= board[0].length) {
                System.out.println("Geçersiz girdi. Lütfen matris sınırları içerisinde değer giriniz.");
                continue;
            }

            if (mineControl(mineBoard, row, column)) {
                System.out.println("Kaybettiniz");
                isGameOver = true;
                break;
            }
            int totalMine= minesAround(mineBoard, row, column);
            board[row][column]="" + totalMine;

            if(isGameFinish(board, mineBoard)){
                isGameOver= true;
                isWin= true;
                printBoard(board);
                System.out.println("Congrats");
            }
        }
    }

    static boolean isGameFinish(String[][] board, String[][] mineBoard) {
        for(int i=0; i< board.length; i++) {
            for (int j=0; j<board[0].length; j++){
                if(board[i][j].equals("-") && !mineBoard[i][j].equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }

    static int minesAround(String[][] mineBoard, int row, int column) {
        int mineCount=0;
        int rowMin=row-1, rowMax=row+1;
        int columnMin=row-1, columnMax=column+1;

        if(mineBoard.length == rowMax)
            --rowMax;
        if(rowMin == -1)
            ++rowMin;
        if(mineBoard[0].length == columnMax)
            --columnMax;
        if(columnMin == -1)
            ++columnMin;


        for (int i=rowMin; i<=rowMax; i++)
            for (int j=columnMin; j<=columnMax; j++) {
                if (mineBoard[i][j].equals("*"))
                    ++mineCount;
            }
        return mineCount;
    }

    static boolean mineControl(String[][] mineBoard, int row, int column) {
        if(mineBoard[row][column].equals("*")) {
            return true;
        }
        return false;
    }

    static void setMines(String[][] board) {
        int totalMines = board.length * board.length / 4;

        for (int i=0; i<totalMines; i++) {
            int firstRandom= 0;
            int secondRandom= 0;

            // check location already mined (repeat check)
            do {
                firstRandom= randomizer(board.length);
                secondRandom= randomizer(board[0].length);
            } while (board[firstRandom][secondRandom].equals("*"));

            board[firstRandom][secondRandom] = "*";
        }
    }

    static int randomizer(int bound) {
        Random rand= new Random();
        return  rand.nextInt(bound);
    }



    static String[][] setBoard(int row, int column) {
        String board[][] = new String[row][column];
        for (var temp : board) {
            Arrays.fill(temp, "-");
        }
        return board;
    }
    static void printBoard(String matrix[][]) {
        for (var line: matrix) {
            for (var number : line) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }
}
