public class Board implements Cloneable{

    private int height;
    private int width;
    private int blank;
    private int initBlank;
    private int count;
    private int[][] board;

    public enum Direction {NORTH, SOUTH, EAST, WEST}

    /**
     * Constructor
     * @param width
     * @param height
     * @param blank
     */
    public Board(int width, int height, int blank) throws Exception{
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
        this.initBlank = blank;
    }

    public void print_board(){
        for(int i = 0 ; i < this.height ; i++){
            System.out.print("|");
            for(int j = 0 ; j < this.width ; j++){
                System.out.print(this.board[i][j]);
                System.out.print("|");
            }
            System.out.println(" ");
        }
    }

    public void move(Direction d) throws ArrayIndexOutOfBoundsException{
        this.blank = whereisblank();
        int row = blank/this.width;
        int col = blank%this.width;
        switch (d) {
            case NORTH:
                if(row == 0){
                    System.err.println("Error move to NORTH is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                this.board[row][col]=this.board[row-1][col];
                this.board[row-1][col]=-1;
                this.blank = this.blank - width;
                break;

            case SOUTH:
                if(row >= this.height-1){
                    System.err.println("Error move to SOUTH is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                this.board[row][col]=this.board[row+1][col];
                this.board[row+1][col]=-1;
                this.blank = this.blank + width;
                break;
            case EAST:
                if(col >= this.width-1){
                    System.err.println("Error move to EAST is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                this.board[row][col]=this.board[row][col+1];
                this.board[row][col+1]=-1;
                this.blank = this.blank + 1;
                break;

            case WEST:
                if(col == 0){
                    System.err.println("Error move to WEST is impossible");
                    throw new ArrayIndexOutOfBoundsException();
                }
                this.board[row][col]=this.board[row][col-1];
                this.board[row][col-1]=-1;
                this.blank = this.blank - 1;
                break;        
        
            default:
                break;
        }
    }

    public boolean check_final(){
        int number = 0;
        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j < this.width ; j++){
                if(this.board[i][j]  != number && number != this.blank) {
                    return false;
                }
                number++;
            }
        }
        return true;
    }

    public void random_conf(int numberShuffle){
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
                move(d);
            }catch(ArrayIndexOutOfBoundsException e){
                //e.printStackTrace();
            }
        }
    }

    public int whereisblank(){
        int bl = 0;
        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j < this.width ; j++){
                if(this.board[i][j]  == -1)return bl;
                bl++;
            }
        }
        return -1;
    }

    public int[][] getBoard(){
        return this.board;
    }

    public int getBlank(){
        return this.initBlank;
    }

    public Board clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        return (Board) o;
    }

    public void setBoard(int[][] copy){
        this.board = copy;
    }
}
