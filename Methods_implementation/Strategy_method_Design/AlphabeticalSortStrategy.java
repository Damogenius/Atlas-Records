package Methods_implementation.Strategy_method_Design;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class AlphabeticalSortStrategy implements SortStrategy {
    @Override
    public List<String> sort(List<String> items) {
        items.sort(String.CASE_INSENSITIVE_ORDER);
        return items;
    }
}

