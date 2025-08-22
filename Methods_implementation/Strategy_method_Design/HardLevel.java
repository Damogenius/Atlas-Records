package Methods_implementation.Strategy_method_Design;

class HardLevel implements DifficultyStrategy {
    public void makeMove() {
        System.out.println("Hard move: Analyzes best possible move.");
    }
}
