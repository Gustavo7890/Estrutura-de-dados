import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void printLeafNodes(Node node) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        if (node.left != null)
            printLeafNodes(node.left);

        if (node.right != null)
            printLeafNodes(node.right);
    }

    boolean printAncestors(Node node, int target) {
        if (node == null)
            return false;

        if (node.data == target)
            return true;

        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }

    void printDescendants(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }

    void printRightSubtree(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printRightSubtree(node.right);
    }

    void printLeftSubtree(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printLeftSubtree(node.left);
    }

    
    void printNodeAndChildren(int key) {
        Node current = root;
        Node parent = null;

        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data)
                current = current.left;
            else
                current = current.right;
        }

        if (current == null) {
            System.out.println("Nó não encontrado na árvore.");
            return;
        }

        System.out.print("Nó pai: ");
        if (parent != null)
            System.out.print(parent.data);
        else
            System.out.print("Não tem pai (é a raiz)");
        System.out.print(", Nós filhos: ");
        if (current.left != null)
            System.out.print(current.left.data + " ");
        if (current.right != null)
            System.out.print(current.right.data);
        System.out.println();
    }

    // Mostrar todos os nós com a seguinte representação: 6(2(1 4(3)) 8)
    void printTreeRepresentation(Node node) {
        if (node == null)
            return;

        System.out.print(node.data);
        if (node.left != null || node.right != null) {
            System.out.print("(");
            printTreeRepresentation(node.left);
            if (node.right != null) {
                System.out.print(" ");
                printTreeRepresentation(node.right);
            }
            System.out.print(")");
        }
    }

    // Realizar um percurso em ordem na árvore
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Exemplo de inserção de nós */
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(8);

        System.out.print("Percurso em ordem: ");
        tree.inorder();
        System.out.println();

        System.out.print("Nós folha: ");
        tree.printLeafNodes(tree.root);
        System.out.println();

        System.out.print("Nós ancestrais de 4: ");
        tree.printAncestors(tree.root, 4);
        System.out.println();

        System.out.print("Nós descendentes: ");
        tree.printDescendants(tree.root);
        System.out.println();

        System.out.print("Subárvore da direita: ");
        tree.printRightSubtree(tree.root);
        System.out.println();

        System.out.print("Subárvore da esquerda: ");
        tree.printLeftSubtree(tree.root);
        System.out.println();

        System.out.print("Nó pai e nós filhos de 2: ");
        tree.printNodeAndChildren(2);
        System.out.println();

        System.out.print("Representação da árvore: ");
        tree.printTreeRepresentation(tree.root);
        System.out.println();
    }
}
