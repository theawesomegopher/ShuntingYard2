package ekordik.cuw.edu.shuntingyard2;

public class Queue {
    private Node front;
    private Node end;
    private int count;

    public Queue(){
        this.front = null;
        this.end = null;
        this.count = 0;
    }

    public void enqueue(String value) {
        Node n = new Node(value);

        if(this.end == null) {
            front = n;
            end = n;
        } else {
            end.setNextNode(n);
            end = n;
        }
        this.count++;
    }

    public String dequeue() {
        Node nodeToReturn = this.front;

        if(this.front != null) {
            this.front = this.front.getNextNode();
            nodeToReturn.setNextNode(null);

            this.count--;
        }

        return nodeToReturn.getData();
    }

    public int getCount() {
        return this.count;
    }
}
