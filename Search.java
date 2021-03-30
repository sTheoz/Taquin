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
            currentBoard = queue.remove();
            if (currentBoard.check_final()) {
                System.out.println("Fin de parcours YES! Nombre d'itérations: " + count);
                return true;
            }
            count++;
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

    public boolean profondeur_limite(int depth) {
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
            while (Integer.parseInt((key = stck.pop())[0]) > depth && !st.empty()){
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

    public boolean profondeur_iterative(){
        int depth = 0;
        boolean res;
        while(!(res=profondeur_limite(depth)))depth++;
        return res;
    }

    public Board getBoard(){
        return this.board;
    }

    public boolean mal_placees(){
        PrioList list = new PrioList();
        Board currentBoard = this.board;
        Board tempBoard;
        list.addElement(currentBoard, 99, 0, "");
        Couple currentCouple;
        int count = 0;
        while(!list.isEmpty()){
            currentCouple = list.getFirst();
            currentBoard = currentCouple.getBoard();
            if (currentBoard.check_final()) {
                System.out.println("Fin de parcours YES! Nombre d'itérations: " + count);
                System.out.println(currentCouple.getDepth() + " nombres de profondeurs avec le chemin " + currentCouple.getPath());
                return true;
            }
            try {
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                tempBoard.move(Board.Direction.NORTH);
                list.addElement(tempBoard, heuristique1(tempBoard), currentCouple.getDepth()+1, currentCouple.getPath()+"N");
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                tempBoard.move(Board.Direction.SOUTH);
                list.addElement(tempBoard, heuristique1(tempBoard), currentCouple.getDepth()+1, currentCouple.getPath()+"S");

            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                tempBoard.move(Board.Direction.EAST);
                list.addElement(tempBoard, heuristique1(tempBoard), currentCouple.getDepth()+1, currentCouple.getPath()+"E");
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            try {
                tempBoard = currentBoard.clone();
                tempBoard.setBoard(this.deepCopy(currentBoard.getBoard()));
                tempBoard.move(Board.Direction.WEST);
                list.addElement(tempBoard, heuristique1(tempBoard), currentCouple.getDepth()+1, currentCouple.getPath()+"W");
            }catch (ArrayIndexOutOfBoundsException e){
                // nothing
            }
            count++;
        }
        return false;
    }

    public int heuristique1(Board b){
        int[][] board = b.getBoard();
        int value = 0;
        int count = 0;
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt != count) value++;
                count++;
            }
        }
        return value;
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
