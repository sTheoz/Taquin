import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Search {
    private Board board;
    public Search(Board b){
        this.board = b;
    }


    public boolean largeur_d_abord(){
        ArrayDeque<Board> queue = new ArrayDeque<Board>();
        Board currentBoard;
        Board tempBoard;
        int count = 0;
        queue.add(this.getBoard());
        while(!queue.isEmpty()){
            //System.out.println(st.toString());
            currentBoard = queue.remove();
            if (currentBoard.check_final()) {
                System.out.println("Fin de parcours YES! Nombre d'itérations: " + count);
                return true;
            }
            count++;
            //if(count % 10000 == 0)System.out.println(count);
            /*System.out.println("NOOOOOOOOOW");
            currentBoard.print_board();
            System.out.println("------------");*/

            try {
                //System.out.println("NOOOORD");
                currentBoard.move(Board.Direction.NORTH);
                //currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                queue.add(tempBoard);
                currentBoard.move(Board.Direction.SOUTH);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                //System.out.println("SUUUUD");
                currentBoard.move(Board.Direction.SOUTH);
                //currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                queue.add(tempBoard);
                currentBoard.move(Board.Direction.NORTH);

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                //System.out.println("WEEEEEST");
                currentBoard.move(Board.Direction.WEST);
                //currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                queue.add(tempBoard);
                currentBoard.move(Board.Direction.EAST);

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                //System.out.println("ESSSSST");
                currentBoard.move(Board.Direction.EAST);
                //currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                queue.add(tempBoard);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }

        }
        return false;
    }

    public boolean profondeur_d_abord() {
        Stack<Board> st = new Stack<Board>();
        Board currentBoard;
        Board tempBoard;
        int count = 0;
        st.push(this.getBoard());
        while(!st.empty()){
            //System.out.println(st.toString());
            currentBoard = st.pop();
            if (currentBoard.check_final()) {
                System.out.println("Fin de parcours YES! Nombre d'itérations: " + count);
                return true;
            }
            count++;
            System.out.println("NOOOOOOOOOW");
            currentBoard.print_board();
            System.out.println("------------");

            try {
                System.out.println("NOOOORD");
                currentBoard.move(Board.Direction.NORTH);
                currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                currentBoard.move(Board.Direction.SOUTH);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                System.out.println("SUUUUD");
                currentBoard.move(Board.Direction.SOUTH);
                currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                currentBoard.move(Board.Direction.NORTH);

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                System.out.println("WEEEEEST");
                currentBoard.move(Board.Direction.WEST);
                currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                currentBoard.move(Board.Direction.EAST);

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                System.out.println("ESSSSST");
                currentBoard.move(Board.Direction.EAST);
                currentBoard.print_board();
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }

        }
        return false;
    }

    public boolean profondeur_d_abord(int depth) {
        Stack<Board> st = new Stack<Board>();
        Stack<String[]> stck = new Stack<String[]>();
        Board currentBoard;
        Board tempBoard;
        int count = 0;
        String[] key = {"0", ""};
        String[] tempkey = {"0", ""};
        st.push(this.getBoard());
        stck.push(key);
        while(!st.empty()){
            currentBoard = st.pop();
            while (!stck.empty() && Integer.parseInt((key = stck.pop())[0]) > depth){
                currentBoard = st.pop();
            }
            if(stck.empty() && Integer.parseInt(key[0]) > depth)return false;
            if (currentBoard.check_final()) {
                System.out.println("Fin de parcours YES! Nombre d'itérations: " + count);
                System.out.println(key[0] + " nombres de profondeurs avec le chemin " + key[1]);
                return true;
            }
            count++;

            try {
                currentBoard.move(Board.Direction.NORTH);
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                tempkey[0] = String.valueOf(Integer.parseInt(key[0]) + 1);
                tempkey[1] = key[1] + "N";
                stck.push(Arrays.copyOf(tempkey,2));
                currentBoard.move(Board.Direction.SOUTH);
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                currentBoard.move(Board.Direction.SOUTH);
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                tempkey[0] = String.valueOf(Integer.parseInt(key[0]) + 1);
                tempkey[1] = key[1]+"S";
                stck.push(Arrays.copyOf(tempkey,2));
                currentBoard.move(Board.Direction.NORTH);

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                currentBoard.move(Board.Direction.WEST);
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                tempkey[0] = String.valueOf(Integer.parseInt(key[0]) + 1);
                tempkey[1] = key[1]+"W";
                stck.push(Arrays.copyOf(tempkey,2));
                currentBoard.move(Board.Direction.EAST);

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                currentBoard.move(Board.Direction.EAST);
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                st.push(tempBoard);
                tempkey[0] = String.valueOf(Integer.parseInt(key[0]) + 1);
                tempkey[1] = key[1]+"E";
                stck.push(Arrays.copyOf(tempkey,2));
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }

        }
        return false;
    }

    public Board getBoard(){
        return this.board;
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

    int[][] deepCopy(int[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
}
