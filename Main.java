import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Board b = new Board(3,3,8);
        b.random_conf(50);
        //int[][] boa = {{0,2,-1},{3,1,5},{6,4,7}};
        //b.setBoard(boa);
        b.print_board();
        Search se = new Search(b);
        System.out.println(se.heuristique2(b));
        System.out.println(se.heuristique3(b));
        System.out.println(se.profondeur_limite(12));
        System.out.println(se.distance_algo());

        //System.out.println(se.largeur_d_abord());
        //System.out.println(se.profondeur_d_abord());
        //System.out.println(se.profondeur_iterative());
        System.out.println(se.full_algo());

        //System.out.println(se.mal_placees());

    }
}
