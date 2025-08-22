package Methods_implementation.Strategy_method_Design;

import java.util.ArrayList;
import java.util.List;

public class DManager {


    private static DManager instance;


    private final List<String> itemList;


    private DManager() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create a new instance. Use getInstance() method.");
        }
        itemList = new ArrayList<>();

    }

    public static synchronized DManager getInstance() {
        if (instance == null) {
            instance = new DManager();
        }
        return instance;
    }


    public synchronized void addItem(String item) {
        itemList.add(item);
    }

    public synchronized boolean removeItem(String item) {
        return itemList.remove(item);
    }


    public synchronized List<String> list() {
        return new ArrayList<>(itemList); // return a copy for safety
    }
}
