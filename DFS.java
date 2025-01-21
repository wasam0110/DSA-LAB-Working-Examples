/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ghazi
 */
import java.util.*;

class VERTEX {
    String label;
    boolean visited;

    VERTEX(String label) {
        this.label = label;
        this.visited = false;
    }
}

class GRAPH {
    private final List<VERTEX> vertices;
    private final int[][] adjacencyMatrix;
    private final Stack<Integer> stack;

    GRAPH(int size) {
        vertices = new ArrayList<>();
        adjacencyMatrix = new int[size][size];
        stack = new Stack<>();
    }

    public void addVertex(String label) {
        vertices.add(new VERTEX(label));
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void displayVertex(int index) {
        System.out.print(vertices.get(index).label + " ");
    }

    public void dfs() {
        vertices.get(0).visited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int vertexIndex = getUnvisitedNeighbor(stack.peek());

            if (vertexIndex == -1) {
                stack.pop();
            } else {
                vertices.get(vertexIndex).visited = true;
                displayVertex(vertexIndex);
                stack.push(vertexIndex);
            }
        }

        for (VERTEX vertex : vertices) {
            vertex.visited = false;
        }
    }

    private int getUnvisitedNeighbor(int vertexIndex) {
        for (int i = 0; i < vertices.size(); i++) {
            if (adjacencyMatrix[vertexIndex][i] == 1 && !vertices.get(i).visited) {
                return i;
            }
        }
        return -1;
    }
}

public class DFS {
    public static void main(String[] args) {
        GRAPH graph = new GRAPH(5);

        graph.addVertex("W");
        graph.addVertex("A");
        graph.addVertex("A");
        graph.addVertex("S");
        graph.addVertex("M");

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Depth-First Search traversal:");
        graph.dfs();
    }
}
 
