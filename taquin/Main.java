package taquin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        logger.setLevel(Level.SEVERE);
        Board b = new Board(3,3,8);
        b.random_conf(50);
        //int[][] boa = {{2,5,-1},{1,4,0},{3,6,7}};
        //b.setBoard(boa);
        b.print_board();
        Search se = new Search(b);
        System.out.println(se.heuristique2(b));
        System.out.println(se.heuristique3(b));
        //System.out.println(se.profondeur_limite(20));

        //System.out.println(se.largeur_d_abord());
        //System.out.println(se.profondeur_d_abord());
        System.out.println("-------- Iterative ---------");
        //System.out.println(se.profondeur_iterative());
        //System.out.println("-------- H3 ---------");
        //System.out.println(se.full_algo());

        System.out.println("-------- H1 ---------");
        Search.Heuritisque h1 = (currentBoard) -> se.heuristique1(currentBoard);
        System.out.println(se.mal_placees(h1));

        System.out.println("-------- H2 ---------");
        Search.Heuritisque h2 = (currentBoard) -> se.heuristique2(currentBoard);
        System.out.println(se.mal_placees(h2));

        System.out.println("-------- H3 ---------");
        Search.Heuritisque h3 = (currentBoard) -> se.heuristique3(currentBoard);
        System.out.println(se.mal_placees(h3));
        //
        //System.out.println(se.distance_algo());
    }
}
