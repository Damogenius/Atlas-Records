package Methods_implementation.Strategy_method_Design;

class EasyLevel implements DifficultyStrategy {
    public void makeMove() {
        System.out.println("Easy move: Random piece moved.");
    }
}
