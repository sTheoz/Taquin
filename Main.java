import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Board b = new Board(3,3,8);
        // b.print_board();
        // System.out.println(b.check_final());
        b.random_conf(10);
        b.print_board();
        //System.out.println(b.getBlank());
        /*Stack<Board> st = new Stack<Board>();
        Board currentBoard;
        st.push((Board) b.clone());
        currentBoard = st.pop();

        currentBoard.move(Board.Direction.NORTH);

        System.out.println(currentBoard.getBlank());
        System.out.println(b.getBlank());*/
        Search se = new Search(b);
        //System.out.println(se.largeur_d_abord());
        //System.out.println(se.profondeur_d_abord());
        //System.out.println(se.profondeur_limite(2));
        //System.out.println(se.profondeur_iterative());
        System.out.println(se.mal_placees());
    }
}
