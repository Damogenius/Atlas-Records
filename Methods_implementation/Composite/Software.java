package Methods_implementation.Composite;

class Software implements Company {
    private String name;

    public Software(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Software Employee: " + name);
    }
}

