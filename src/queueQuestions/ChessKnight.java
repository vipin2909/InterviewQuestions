package queueQuestions;

import java.util.*;
import java.util.Queue;

class ChessNode {
    int x, y, dist;
    public ChessNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ChessNode(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    // As we are using the class Object as a key in HashMap
    // we need to implement hashCode() and equals()

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessNode node = (ChessNode) o;
        return x == node.x && y == node.y && dist == node.dist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dist);
    }
}
public class ChessKnight {

    private static int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int[] col = {-1, 1, 1, -1, 2, -2, 2, -2};


    // check if the board cells are in range and the upcoming cell is not visited before
    public static boolean isValid(int row, int col, int M) {
        return (row < M && row >= 0) && (col >= 0 && col < M);
    }
    public static int findShortestDistance(ChessNode src, ChessNode dest, int N) {

        // set to check the matrix cell is visited before or not
        Set<ChessNode> visited = new HashSet<>();

        // create a queue and enqueue the first node
        Queue<ChessNode> q = new ArrayDeque<>();
        q.add(src);

        while(!q.isEmpty()) {
            ChessNode node = q.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            // if the destination is reached, return distance
            if(x == dest.x && y == dest.y) {
                return dist;
            }

            if(!visited.contains(node)) {
                // mark the current node visited
                visited.add(node);

                // check for all eight possible movements for a knight
                // and enqueue each valid movement
                for(int i = 0; i < row.length; i++) {
                    // get the knight's valid position from the current position on
                    // the chessboard and enqueue it with +1 distance
                    int x1 = x + row[i];
                    int y1 = y + col[i];

                    if(isValid(x1, y1, N)) {
                        q.add(new ChessNode(x1, y1, dist+1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int N = 8;
        ChessNode src = new ChessNode(0, 7);
        ChessNode dest = new ChessNode(7, 0);

        System.out.println("The minimum steps required is " + findShortestDistance(src, dest, N));
    }
}
