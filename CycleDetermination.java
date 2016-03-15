public class CycleDetermination {
    /**
     * Возвращает true, если есть цикл. В противном случае возвращает false
     * @return
     */
    public boolean hasCycle(LinkedNodes<Boolean> nodes) {
        if (nodes.getStartNode() == null) {
            return false;
        }
        if (nodes.getNumberOfNodes() < 2) {
            return false;
        }
        else if (nodes.getStartNode().equals(nodes.getLastNode())) {
            return true;
        }
        return false;
    }
}
