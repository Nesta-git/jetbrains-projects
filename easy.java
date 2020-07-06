package tictactoe;

import java.util.Random;

public class easy {
    static Random rd = new Random();


    static int done2 = Main.getdone();



    public static void go(Character[][] veld) {
        if (done2 < 2) {
            System.out.println("Making move level "+ "\"easy\"");
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

            while (true) {
                int a = rd.nextInt(3);
                int b = rd.nextInt(3);



                if (a < 0 || b > 3 || a > 3 || b < 0) {

                    continue;
                }
                if (veld[a][b] == ' ') {
                    veld[a][b] = current;
                    break;
                } else if (veld[a][b] == 'O' || veld[a][b] == 'X') {

                    continue;
                }

            }

            Showtable(veld);
            return;
        } else return;
    }

    // yeah




    private static void Showtable(Character[][] veld) {
        System.out.printf("---------%n| %c %c %c |%n| %c %c %c |%n| %c %c %c |%n---------%n",
                veld[0][0], veld[0][1], veld[0][2],
                veld[1][0], veld[1][1], veld[1][2],
                veld[2][0], veld[2][1], veld[2][2]);

    }

}


