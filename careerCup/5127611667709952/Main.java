public class Main
{
    public static class BoxIndex {
        int row;
        int col;
        public BoxIndex(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static char[][] c_arr = {
        {'a', 'b', 'c', 'd', 'e'},
        {'f', 'g', 'h', 'i', 'j'},
        {'k', 'l', 'm', 'n', 'o'},
        {'p', 'q', 'r', 's', 't'},
        {'u', 'v', 'w', 'x', 'y'},
        {'z'}
    };

    public static void findChar(char c, BoxIndex b)
    {
        char curr = c_arr[b.row][b.col];
        System.out.println("Now we are at " + curr);

        while(curr != c) {
            if(c > curr) {
                char max = c_arr[b.row][c_arr[b.row].length - 1];
                //down
                if(c > max)
                {
                    System.out.println("DOWN");
                    b.row++;
                }
                else {
                    //right
                    System.out.println("RIGHT");
                    b.col++;
                }
            }
            else if( c < curr){
                char min = c_arr[b.row][0];
                if( c < min) {
                    //up
                    System.out.println("UP");
                    b.row--;
                }
                else
                {
                    System.out.println("LEFT");
                    b.col--;
                }
            }

            curr = c_arr[b.row][b.col];
        }

        System.out.println("OK SELECT " + c_arr[b.row][b.col]);
    }

    public static void main(String[] args)
    {
        char[] str = args[0].toCharArray();
        BoxIndex b = new BoxIndex(0, 0);

        for(char c : str)
        {
            findChar(Character.toLowerCase(c), b);
        }
    }
}
