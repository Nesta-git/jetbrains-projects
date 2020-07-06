package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static int done =  0;

    protected static int getdone() {
        return done;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character[][] veld = new Character[3][3]; // lengte is geen index

        System.out.println("enter 3 commands: \n 1e start or exit \n 2e and 3e choose from: easy, user or medium");
        while(true) {


            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    veld[i][j] = ' ';
                }
            }


            String para = sc.nextLine();
            String[] Parray = para.split(" ");
            String begin = Parray[0];

            if(Parray.length != 3) {
                if(begin.equals("exit")) {
                    break;
                }
                System.out.println("Bad parameters!");
                continue;
            }


            String playerX = Parray[1];
            String playerO = Parray[2];

            if (begin.equals("start"))    {
                if(playerX.equals("user") || playerX.equals("easy") || playerX.equals("medium") || playerX.equals("hard") && playerO.equals("user") || playerO.equals("easy") || playerO.equals("medium") || playerO.equals("hard")) {
                    showTable(veld);
                    startgame(playerX, playerO, veld);
                } else {
                    System.out.println("Bad paramaters!");
                }

            } else {
                System.out.println("Bad parameters!");
                continue;
            }

        }
    }




    private static void startgame(String playerX, String playerO, Character[][] veld) {
        while (true) {
            if (playerX.equals("easy")) {
                easy.go(veld);
            } else if (playerX.equals("user")) {
                user.go(veld);
            } else if (playerX.equals("medium")) {
                medium.go(veld);
            } else if (playerX.equals("hard")){
                medium.go(veld);
            }
            checkgamestate(veld);

            if (done > 3) {
                done = 0;
                return;
            }


            if (playerO.equals("easy")) {
                easy.go(veld);
            } else if (playerO.equals("user")) {
                user.go(veld);

            } else if (playerO.equals("medium")) {
                medium.go(veld);


            }else if (playerO.equals("hard")){
                medium.go(veld);
            }
            checkgamestate(veld);

            if (done > 3) {
                done = 0;
                return;
            }
        }
    }

// methods


    private static void checkgamestate(Character[][] veld) {
        // TODO Auto-generated method stub
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
            current = 'X';
        }
        if(cross == zero || zero > cross) {
            current = 'O';
        }

        int klaar = 0;
        int draw = 0;
        int winR = 0;
        int winC = 0;


        for(int i = 0; i < 3; i++) {
            winR = 0;
            winC = 0;
            for(int j = 0; j < 3; j++) {
                if (veld[i][j] == current && klaar < 1) {
                    winR++;
                    if( winR == 3) {
                        klaar = 6;
                        done = 4;
                        System.out.println(current + " wins");
                        break;
                    }
                }
                if (veld[i][j] != current) {
                    winR = 0;
                }
                if (veld[j][i] == current && klaar < 1) {
                    winC++;
                    if( winC == 3) {
                        klaar = 6;
                        done = 4;
                        System.out.println(current + " wins");
                        break;
                    }
                }
                if (veld[j][i] != current) {
                    winC = 0;
                }
            }
        }



        if (veld[0][0] == current && veld[1][1] == current && veld[2][2] == current && klaar < 1) {
            System.out.println(current + " wins");
            klaar = 6;
            done = 4;
        }
        if (veld[2][0] == current && veld[1][1] == current && veld[0][2] == current && klaar < 1) {
            System.out.println(current + " wins");
            klaar = 6;
            done = 4;
        }
        int doei = 0;
        for(int i = 0; i < 3 && doei < 5 && klaar < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (veld[i][j] == ' ' ) {
                    draw = 3;

                    doei = 6;

                    break;
                }
            }
        }

        if(draw < 1 && klaar < 1) {
            System.out.println("Draw");
            klaar = 6;
            done = 4;
        }
        draw = 0;

    }




    public static void showTable(Character[][] veld){
        System.out.printf("---------%n| %c %c %c |%n| %c %c %c |%n| %c %c %c |%n---------%n",
                veld[0][0], veld[0][1], veld[0][2],
                veld[1][0], veld[1][1], veld[1][2],
                veld[2][0], veld[2][1], veld[2][2]);
    }


}
