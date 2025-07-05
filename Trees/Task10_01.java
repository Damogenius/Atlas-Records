package Trees;

import java.util.*;

class GraphNode {
    int id;
    List<GraphNode> neighbors;

    GraphNode(int id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }
}
 class GraphOOP {
     private Map<Integer, GraphNode> nodes;

     public GraphOOP() {
         nodes = new HashMap<>();
     }

     public void addVertex(int id) {
         nodes.putIfAbsent(id, new GraphNode(id));
     }

     public void addEdge(int src, int dest) {
         GraphNode srcNode = nodes.get(src);
         GraphNode destNode = nodes.get(dest);

         if (srcNode != null && destNode != null) {
             srcNode.neighbors.add(destNode);
             destNode.neighbors.add(srcNode);
         }
     }

     public void displayGraph() {
         for (GraphNode node : nodes.values()) {
             System.out.print("Node " + node.id + " connects to: ");
             for (GraphNode neighbor : node.neighbors) {
                 System.out.print(neighbor.id + " ");
             }
             System.out.println();
         }
     }
 }
 class Task10_1{
    public static void main(String[] args) {
        GraphOOP graph = new GraphOOP();

        for (int i = 1; i <= 5; i++) {
            graph.addVertex(i);
        }


        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.displayGraph();
    }
}
