package taquin;

public class Couple {
    private Board board;
    private int value;
    private int depth;
    private String path;

    public Couple(Board b, int v, int d, String p){
        board = b;
        value = v;
        depth = d;
        path = p;
    }

    public int getValue(){
        return this.value;
    }

    public int getDepth(){
        return this.depth;
    }

    public String getPath(){
        return this.path;
    }

    public Board getBoard(){
        return this.board;
    }
}
