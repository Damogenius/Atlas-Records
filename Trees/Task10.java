package Trees;

public class Task10 {
    public static void main(String[] args) {
        int vertices = 5;
        int edges = 8;
        int[][] edgeList = {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 4},
                {2, 5},
                {3, 4},
                {3, 5},
                {4, 5}
        };
        System.out.println("Graph with " + vertices + " vertices and " + edges + " edges:");
        System.out.println("Edges:");
        for (int[] i : edgeList) {
            System.out.println(i[0] + " - " + i[1]);
        }
    }
}
