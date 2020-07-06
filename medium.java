package tictactoe;

import java.util.Random;

public class medium {
    static Random rd = new Random();


    static int done2 = Main.getdone();



    public static void go(Character[][] veld) {
        if (done2 < 2) {
            System.out.println("Making move level "+ "\"medium\"");
            char current = checkcurrent(veld);

            if (smartMove(veld, current) != 5) {
                Showtable(veld);
                return;
            }

            current = checkcurrent(veld);
            if (stopWin(veld, current) != 5) {
                Showtable(veld);
                return;
            }
            current = checkcurrent(veld);

            randomMove(veld, current);
            return;


        } else return;
    }


    public static char checkcurrent(Character[][] veld) {

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
            return 'O';
        }
        if(cross == zero || zero > cross) {
            return 'X';

        }else return '0';
    }

    // check win 9999999999999999999999999999999999999999999999999999999999999999999999999999999999
    public static int smartMove(Character[][] veld, char current) {
        char opponent = 'j';

        if (current == 'X') {
            opponent = 'O';
        } else {
            opponent = 'X';
        }

        int winR = 0;
        int winC = 0;
        int windr = 0;
        int windl = 0;

        int a = 0;
        int b = 0;

        for(int i = 0; i < 3; i++) {
            winR = 0;
            for(int j = 0; j < 3; j++) {

                if (veld[i][j] == opponent) {
                    break;
                } else if(veld[i][j] == current) {
                    winR++;
                } else if(veld[i][j] == ' ') {
                    a = i;
                    b = j;
                }
                if(winR == 2 && j == 2) {
                    veld[a][b] = current;
                    return 4;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            winC = 0;
            for(int j = 0; j < 3; j++) {

                if (veld[j][i] == opponent) {
                    break;
                } else if(veld[j][i] == current) {
                    winC++;
                } else if(veld[j][i] == ' ') {
                    a = j;
                    b = i;
                }
                if(winC == 2 && j == 2) {
                    veld[a][b] = current;
                    return 4;
                }
            }
        }

        for(int i = 0; i < 3; i++) {

            if (veld[i][i] == opponent) {
                break;
            } else if(veld[i][i] == current) {
                windr++;
            } else if(veld[i][i] == ' ') {
                a = i;
                b = i;
            }
            if(windr == 2 && i == 2) {
                veld[a][b] = current;
                return 4;
            }
        }
        int hoi = 2;
        for(int i = 0; i < 3; i++) {

            if (veld[hoi][i] == opponent) {
                break;
            } else if(veld[hoi][i] == current) {
                windl++;
            } else if(veld[hoi][i] == ' ') {
                a = hoi;
                b = i;
            }
            if(windl == 2 && i == 2) {
                veld[a][b] = current;
                return 4;
            }
            hoi--;
        }

        // einde

        return 5;
    }






    // stop win 999999999999999999999999999999999999999999999999999999999999999999999999999999999
    public static int stopWin(Character[][] veld, char current) {
        char opponent = 'j';

        if (current == 'X') {
            opponent = 'O';
        } else {
            opponent = 'X';
        }

        int winR = 0;
        int winC = 0;
        int windr = 0;
        int windl = 0;

        int a = 0;
        int b = 0;

        for(int i = 0; i < 3; i++) {
            winR = 0;
            for(int j = 0; j < 3; j++) {

                if (veld[i][j] == current) {
                    break;
                } else if(veld[i][j] == opponent) {
                    winR++;
                } else if(veld[i][j] == ' ') {
                    a = i;
                    b = j;
                }
                if(winR == 2 && j == 2) {
                    veld[a][b] = current;
                    return 4;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            winC = 0;
            for(int j = 0; j < 3; j++) {

                if (veld[j][i] == current) {
                    break;
                } else if(veld[j][i] == opponent) {
                    winC++;
                } else if(veld[j][i] == ' ') {
                    a = j;
                    b = i;
                }
                if(winC == 2 && j == 2) {
                    veld[a][b] = current;
                    return 4;
                }
            }
        }

        for(int i = 0; i < 3; i++) {

            if (veld[i][i] == current) {
                break;
            } else if(veld[i][i] == opponent) {
                windr++;
            } else if(veld[i][i] == ' ') {
                a = i;
                b = i;
            }
            if(windr == 2 && i == 2) {
                veld[a][b] = current;
                return 4;
            }
        }

        int hoi = 2;
        for(int i = 0; i < 3; i++) {

            if (veld[hoi][i] == current) {
                break;
            } else if(veld[hoi][i] == opponent) {
                windl++;
            } else if(veld[hoi][i] == ' ') {
                a = i;
                b = i;
            }
            if(windl == 2 && i == 2) {
                veld[a][b] = current;
                return 4;
            }
            hoi--;
        }

        // einde

        return 5;
    }

    // random move 999999999999999999999999999999999999999999999999999999999999999999999999999999
    public static void randomMove(Character[][] veld, char current) {
        int klaar = 0;
        while (klaar < 3) {
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

    }



    // yeah




    private static void Showtable(Character[][] veld) {
        System.out.printf("---------%n| %c %c %c |%n| %c %c %c |%n| %c %c %c |%n---------%n",
                veld[0][0], veld[0][1], veld[0][2],
                veld[1][0], veld[1][1], veld[1][2],
                veld[2][0], veld[2][1], veld[2][2]);

    }

}



