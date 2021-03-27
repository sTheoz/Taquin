public class Main {
    public static void main(String[] args) throws Exception {
        Interface i = new Interface(3,3,8);
        // i.print_board(i.getBoard());
        System.out.println(i.check_final(i.getBoard(), i.getBlank()));
        i.random_conf(i.getBoard(), 1000);
        i.print_board(i.getBoard());
        Search se = new Search(i);
        System.out.println(se.profondeur_d_abord(se.getBoard()));
    }
}
