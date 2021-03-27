import java.util.Stack;

public class Search {
    private Interface board;
    public Search(Interface b){
        this.board = b;
    }
    public boolean profondeur_d_abord(int[][] b) {
        Stack<int[][]> st = new Stack<int[][]>();
        int initialBlank =  this.board.getBlank();
        int[][] currentBoard;
        int count = 0;
        int[][] tempBoard;
        st.push(this.getBoard());
        while(!st.empty()){
            currentBoard = st.pop();
            if (board.check_final(currentBoard, initialBlank)) {
                System.out.println("Fin de parcours YES! Nombre d'itérations: " + count);
                return true;
            }
            int bl = getBlank(currentBoard);
            count++;
            try {
                Thread.sleep(2000);
                System.out.println("NOOOOOOOOOW");
                this.board.print_board(currentBoard);
                System.out.println("------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("NOOOORD");
                tempBoard = board.move(currentBoard, Interface.Direction.NORTH, bl).clone();
                this.board.print_board(tempBoard);
                st.push(tempBoard);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                System.out.println("SUUUUD");
                tempBoard = board.move(currentBoard, Interface.Direction.SOUTH, bl).clone();
                this.board.print_board(tempBoard);
                st.push(tempBoard);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                System.out.println("WEEEEEST");
                tempBoard = board.move(currentBoard, Interface.Direction.WEST, bl).clone();
                this.board.print_board(tempBoard);
                st.push(tempBoard);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                System.out.println("ESSSSST");
                tempBoard = board.move(currentBoard, Interface.Direction.EAST, bl).clone();
                this.board.print_board(tempBoard);
                st.push(tempBoard);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }

        }
        return false;
    }

    public int[][] getBoard(){
        return this.board.getBoard();
    }

    public int getBlank(int[][] b){
        int c = 0;
        for (int[] ints : b) {
            for (int anInt : ints) {
                if (anInt == -1) return c;
                c++;
            }
        }
        return -1;
    }
}
