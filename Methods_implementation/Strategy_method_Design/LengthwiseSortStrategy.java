package Methods_implementation.Strategy_method_Design;

import java.util.List;
import java.util.Comparator;

public class LengthwiseSortStrategy implements SortStrategy {
    @Override
    public List<String> sort(List<String> items) {
        items.sort(Comparator.comparingInt(String::length));
        return items;
    }
}

