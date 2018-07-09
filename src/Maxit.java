import java.util.Scanner;

public class Maxit {
    final int NUMBER = 20;
    final int MIN = -1000;
    private int len;
    private boolean[][] seen = new boolean[NUMBER][NUMBER];
    private int[][] board;

    Maxit() {
        seen[0][0] = false;
    }

    public static void main(String[] args) throws Exception {
        Maxit maxit = new Maxit();
        maxit.lunch();

    }


    public void lunch() throws Exception {

        int x = -1, y = -1;
        Scanner scanner = new Scanner(System.in);
        len = scanner.nextInt();
        board = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 0) {
                    x = j;
                    y = i;
                    seen[y][x] = true;
                }
            }
        }
        if (x < 0 || y < 0) {
            throw new Exception();
        }
        System.out.println();
        System.out.println("ans :" + this.dfs(x, y, true));
    }

    public int dfs(int x, int y, boolean turn) {
        int copyX=x;
        int copyY =y;
        int max = MIN,temp=0;
        int first = y, second = x;
        for (int i = 0; i < len; i++) {

            if (turn) {
                x = i;
//                if (copyX == x) {
//                    continue;
//                }
            } else {
                y = i;
//                if (copyY == y) {
//                    continue;
//                }
            }

            if (!seen[y][x]) {
                seen[y][x] = true;
                temp = dfs(x, y, !turn);
                seen[y][x] = false;
                if (temp >= max) {
                    max = temp;
                    first = y;
                    second = x;
                }
            }
        }


        seen[first][second] = true;
        if(max==MIN){max = 0;}//say kon pakesh koni
        if (turn) {
            System.out.print("x is " + second + "   ");
            return (max + board[first][second]);
        } else {
            System.out.print("y is " + first + "   ");
            return (max - board[first][second]);
        }
    }
}