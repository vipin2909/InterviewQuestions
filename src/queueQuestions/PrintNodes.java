package queueQuestions;

import java.util.ArrayDeque;
import java.util.Queue;

class QueueNode {
    int data;
    QueueNode left, right;

    public QueueNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class PrintNodes {
    public void printNodes(QueueNode root, int start, int end) {
        if(root == null) {
            return;
        }
        // create an empty queue and enqueue the root node
        Queue<QueueNode> queue = new ArrayDeque<>();
        queue.add(root);
        // to store the curr node
        QueueNode curr = null;
        // maintains the level of the current node
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            // calculate the total number of nodes at the current level
            int size = queue.size();

            while(size-- > 0) {
                curr = queue.poll();
                // print nodes if its level is between given levels
                if(level >= start && level <= end) {
                    System.out.print(curr.data + " ");
                }

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }

            if(level >= start && level <= end) {
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        QueueNode root = new QueueNode(15);
        root.left = new QueueNode(10);
        root.right = new QueueNode(20);
        root.left.left = new QueueNode(8);
        root.left.right = new QueueNode(12);
        root.right.left = new QueueNode(16);
        root.right.right = new QueueNode(25);
        root.right.right.right = new QueueNode(30);

        int start = 2, end = 3;
        PrintNodes prntNds = new PrintNodes();
        prntNds.printNodes(root, start, end  );
    }
}
