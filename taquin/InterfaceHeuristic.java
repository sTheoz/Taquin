package taquin;

public class InterfaceHeuristic{
    public interface IntHeur {
        public int execute(int g);
    }

    public static int heuristicDistanceCase(int g) {
        return g;
    }

    public static void uneFonction(IntHeur h, int grid) {
        System.out.println(h.execute(grid));
    }

    public static void main(String[] args) {
        IntHeur h1 = (grid) -> heuristicDistanceCase(grid);
        uneFonction(h1, 5);
    }
}