package Methods_implementation.Composite;

import java.util.ArrayList;
import java.util.List;

class CompanyHead implements Company {
    private String name;
    private List<Company> subordinates = new ArrayList<>();

    public CompanyHead(String name) {
        this.name = name;
    }

    public void addEmployee(Company employee) {
        subordinates.add(employee);
    }

    public void removeEmployee(Company employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Company Head: " + name);
        for (Company emp : subordinates) {
            emp.showDetails();
        }
    }
}
