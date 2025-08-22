package Methods_implementation.Strategy_method_Design;

public class Main {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();


        game.setStrategy(new EasyLevel());
        game.playMove();

        game.setStrategy(new MediumLevel());
        game.playMove();

        game.setStrategy(new HardLevel());
        game.playMove();
    }
}