public class Interface {

    private int height;
    private int width;
    private int blank;
    private int count;
    private int[][] board;

    public enum Direction {NORTH, SOUTH, EAST, WEST}

    /**
     * Constructor
     * @param width
     * @param height
     * @param blank
     */
    public Interface(int width, int height, int blank) throws Exception{
        if(blank >= width*height)throw new Exception();
        int number = 0;
        int[][] board = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width ; j++){
                if(blank == number){
                    board[i][j] = -1;
                }else{
                    board[i][j] = number;
                }
                number++;
            }
        }
        this.board = board;
        this.count = 0;
        this.width = width;
        this.height = height;
        this.blank = blank;
    }

    public void print_board(int[][] b){
        for(int i = 0 ; i < this.height ; i++){
            System.out.print("|");
            for(int j = 0 ; j < this.width ; j++){
                System.out.print(b[i][j]);
                System.out.print("|");
            }
            System.out.println(" ");
        }
        return;
    }

    public int[][] move(int[][] b, Direction d, int blank) throws ArrayIndexOutOfBoundsException{
        int row = blank/this.width;
        int col = blank%this.width;
        switch (d) {
            case NORTH:
                if(row == 0){
                    System.err.println("Error move to NORTH is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                b[row][col]=b[row-1][col];
                b[row-1][col]=-1;
                this.blank = this.blank - width;
                break;

            case SOUTH:
                if(row >= this.height-1){
                    System.err.println("Error move to SOUTH is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                b[row][col]=b[row+1][col];
                b[row+1][col]=-1;
                this.blank = this.blank + width;
                break;
            case EAST:
                if(col >= this.width-1){
                    System.err.println("Error move to EAST is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                b[row][col]=b[row][col+1];
                b[row][col+1]=-1;
                this.blank = this.blank + 1;
                break;

            case WEST:
                if(col == 0){
                    System.err.println("Error move to WEST is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                b[row][col]=b[row][col-1];
                b[row][col-1]=-1;
                this.blank = this.blank - 1;
                break;        
        
            default:
                break;
        }
        return b;
    }

    public boolean check_final(int[][] b, int blank){
        int number = 0;
        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j < this.width ; j++){
                if(b[i][j]  != number && number != blank)return false;
                number++;
            }
        }
        return true;
    }

    public int[][] random_conf(int[][] b, int numberShuffle){
        Direction d;       
        for(int i = 0 ; i < numberShuffle ; i++){
            int rand = (int)(Math.random() * (10)%4);
            switch (rand) {
                case 1:
                    d = Direction.SOUTH;
                    break;

                case 2:
                    d = Direction.WEST;
                    break;
                case 3:
                    d = Direction.EAST;
                    break;
                default:
                    d = Direction.NORTH;
                    break;
            }
            try {
                b = move(b, d, this.getBlank());
            }catch(ArrayIndexOutOfBoundsException e){
                //e.printStackTrace();
            }
        }
        this.board = b;
        return b;
    }

    public int[][] getBoard(){
        return this.board;
    }

    public int getBlank(){
        return this.blank;
    }
}
