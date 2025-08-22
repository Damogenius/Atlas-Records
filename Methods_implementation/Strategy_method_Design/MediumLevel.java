package Methods_implementation.Strategy_method_Design;

class MediumLevel implements DifficultyStrategy {
    public void makeMove() {
        System.out.println("Medium move: Chooses a good piece to move.");
    }
}