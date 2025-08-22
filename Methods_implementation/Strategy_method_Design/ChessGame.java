package Methods_implementation.Strategy_method_Design;

class ChessGame {
    private DifficultyStrategy strategy;

    public void setStrategy(DifficultyStrategy strategy) {
        this.strategy = strategy;
    }

    public void playMove() {
        if (strategy != null) {
            strategy.makeMove();
        } else {
            System.out.println("No difficulty level selected.");
        }
    }
}