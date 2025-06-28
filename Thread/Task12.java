package Thread;

import java.util.stream.*;
class Task12 {
    public static void main(String[] args) {
        Stream<String> stream
                = Stream.of("Hello", "My",
                "name", "is",
                "Damo",
                ".K");

        stream.forEach(n -> System.out.printf("%s ",n));
    }
}
