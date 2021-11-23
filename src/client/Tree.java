package client;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    // Root, Left, Right
    public static < T > void preOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /*public static < T > void iterativePreOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        // We create an empty stack and we push root to it
        Stack < Node < T >> nodeStack = new Stack < > ();
        nodeStack.push(node);

        // We pop all items one by one. 
        // For each item, we make the following steps : print data, push its right child, push its left child
        // We push right child in first for that left is processed first
        while (!nodeStack.empty()) {
            Node < T > currentNode = nodeStack.pop();
            System.out.print(currentNode.data + " ");

            if (currentNode.right != null)
                nodeStack.push(currentNode.right);

            if (currentNode.left != null)
                nodeStack.push(currentNode.left);
        }

    }*/

    // Left, Root, Right
    public static < T > void inOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        inOrderTraverse(node.right);
    }

    /*public static < T > void iterativeInOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        // We create an empty stack
        Stack < Node < T >> nodeStack = new Stack < > ();
        Node < T > currentNode = node;

        // We traverse the tree
        while (currentNode != null || nodeStack.size() > 0) {
            // We try to reach the most left node of the current node
            while (currentNode != null) {
                // We add the pointer to the stack before traversing to the left node
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Current Node is null a this point
            currentNode = nodeStack.pop();
            System.out.print(currentNode.data + " ");

            // Now, it's time to visit the right subtree
            currentNode = currentNode.right;
        }

    }*/

    // Left, Right, Root
    public static < T > void postOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    /*public static < T > void iterativePostOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        // We create two stacks
        Stack < Node < T >> nodeStack1 = new Stack < > ();
        Stack < Node < T >> nodeStack2 = new Stack < > ();

        // We push root to first stack
        nodeStack1.push(node);

        // We iterate while first stack is not empty
        while (!nodeStack1.isEmpty()) {
            // We pop an item from nodeStack1 and we push it to nodeStack2
            Node < T > tmpNode = nodeStack1.pop();
            nodeStack2.push(tmpNode);

            // We push left and right children of removed item to nodeStack1
            if (tmpNode.left != null)
                nodeStack1.push(tmpNode.left);

            if (tmpNode.right != null)
                nodeStack1.push(tmpNode.right);
        }

        // We print all elements of nodeStack2
        while (!nodeStack2.isEmpty()) {
            Node < T > tmpNode = nodeStack2.pop();
            System.out.print(tmpNode.data + " ");
        }
    }*/

    
    // Level traversal (Breadth-first search)
    public static < T > void levelOrderTraverse(Node < T > node) {
        if (node == null)
            return;

        Queue < Node < T >> queue = new LinkedList < > ();
        // we add start node
        queue.add(node);

        // iterate while queue not empty
        while (!queue.isEmpty()) {
            // dequeue and print data
            Node < T > next = queue.remove();
            System.out.print(next.data + " ");

            // we add children nodes if not null
            if (next.left != null)
                queue.add(next.left);

            if (next.right != null)
                queue.add(next.right);
        }
    }

    public static void main(String[] args) {
        // We create the nodes of our tree
        Node < String > A = new Node < String > ("A");
        Node < String > B = new Node < String > ("B");
        Node < String > C = new Node < String > ("C");
        Node < String > D = new Node < String > ("D");
        Node < String > E = new Node < String > ("E");
        Node < String > F = new Node < String > ("F");
        Node < String > G = new Node < String > ("G");
        Node < String > H = new Node < String > ("H");
        Node < String > I = new Node < String > ("I");
        Node < String > J = new Node < String > ("J");
        Node < String > K = new Node < String > ("K");

        // Root and building of the tree
        Node < String > root = A;
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.left = J;
        C.left = F;
        C.right = G;
        G.left = K;

        System.out.println("Pre Order Traversal");
        preOrderTraverse(root);

//        System.out.println("\n");
//        System.out.println("Iterative Pre Order Traversal");
//        iterativePreOrderTraverse(root);

        System.out.println("\n");
        System.out.println("========");
        System.out.println();
        System.out.println("In Order Traversal");
        inOrderTraverse(root);

//        System.out.println("\n");
//        System.out.println("Iterative In Order Traversal");
//        iterativeInOrderTraverse(root);

        System.out.println("\n");
        System.out.println("========");
        System.out.println();
        System.out.println("Post Order Traversal");
        postOrderTraverse(root);

//        System.out.println("\n");
//        System.out.println("Iterative Post Order Traversal");
//        iterativePostOrderTraverse(root);

        System.out.println("\n");
        System.out.println("========");
        System.out.println();
        System.out.println("Level Order Traversal");
        levelOrderTraverse(root);

        System.out.println("\n");
    }
}