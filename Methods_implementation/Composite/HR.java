package Methods_implementation.Composite;

class HR implements Company {
    private String name;

    public HR(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("HR Employee: " + name);
    }
}