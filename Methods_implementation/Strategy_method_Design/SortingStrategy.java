package Methods_implementation.Strategy_method_Design;

import java.util.ArrayList;
import java.util.List;

public class SortingStrategy {
    private List<String> items = new ArrayList<>();
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public List<String> performSort() {
        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy not set.");
        }
        return strategy.sort(new ArrayList<>(items)); // Use a copy to preserve original list if needed
    }

    public List<String> getList() {
        return new ArrayList<>(items);
    }
}
