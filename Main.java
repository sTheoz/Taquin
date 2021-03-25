public class Main {
    public static void main(String[] args) {
        Interface i = new Interface(4,4,9);
        // i.print_board(i.getBoard());
        System.out.println(i.check_final(i.getBoard(), i.getBlank()));
        i.random_conf(i.getBoard(), 1000);
        i.print_board(i.getBoard());
    }
}
