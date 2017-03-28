package ekordik.cuw.edu.shuntingyard2;

public class Node {
    private String data;
    private Node nextNode;

    public Node(String data){
        this.data = data;
        this.nextNode = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}