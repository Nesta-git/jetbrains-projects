package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class user {
    public static void go(Character[][] veld) {
        Scanner scs = new Scanner(System.in);







        char current = 'y';
        int cross = 0;
        int zero = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (veld[i][j] == 'X') {
                    cross++;
                } else if ( veld[i][j] == 'O') {
                    zero++;
                }
            }
        }

        if(cross > zero) {
            current = 'O';
        }
        if(cross == zero || zero > cross) {
            current = 'X';
        }

        System.out.println("enter coordinates: ");




        while (true) {
            try {
                int b = scs.nextInt() - 1;
                int a = 3 - scs.nextInt();


                if (a < 0 || b > 2 || a > 2 || b < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (veld[a][b] == ' ') {
                    veld[a][b] = current;
                    break;
                } else if (veld[a][b] == 'O' || veld[a][b] == 'X') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scs.next();





                continue;

            }
        }

        showTable(veld);

        return;
    }
    public static void showTable(Character[][] veld){
        System.out.printf("---------%n| %c %c %c |%n| %c %c %c |%n| %c %c %c |%n---------%n",
                veld[0][0], veld[0][1], veld[0][2],
                veld[1][0], veld[1][1], veld[1][2],
                veld[2][0], veld[2][1], veld[2][2]);
    }
}




