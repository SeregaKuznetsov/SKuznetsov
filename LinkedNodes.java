public class LinkedNodes<T> {

    private Node<T> startNode;
    private Node<T> lastNode;
    private static int numberOfNodes = 0;

    /**
     * Инициализирует начальные данные
     */
    public void init() {
        startNode = null;
        lastNode = null;
    }

    /**
     * Добавляет последний элемент в списке с указанным в параметре
     * значением
     * @param value
     */
    public void addLastNode(T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);
        if (startNode == null) {
            startNode = newNode;
        }
        if (lastNode != null) {
            lastNode.setNode(newNode);
        }
        lastNode = newNode;
        numberOfNodes++;
    }

    public void addLastNode(Node<T> node) {
        lastNode = startNode;
    }

    public Node<T> getStartNode() {
        return startNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    /**
     * Удаляет последний элемент в списке
     */
    public void removeLastNode() {
        if (startNode != null) {
            Node<T> someNode = startNode.getNextNode();
            while (someNode != null) {
                someNode = someNode.getNextNode();
            }
            lastNode = someNode;
            numberOfNodes--;
        }
        else {
            System.out.println("You must create some node, before removed");
        }
    }



}
