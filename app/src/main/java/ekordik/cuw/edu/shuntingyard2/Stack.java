package ekordik.cuw.edu.shuntingyard2;


public class Stack {
    private Node top;
    private int count;

    public Stack() {
        this.top = null;
        count = 0;
    }

    public void push(String data) {
        Node n = new Node(data);
        if(this.top == null) {
            this.top = n;
            this.count++;
        } else {
            n.setNextNode(top);
            this.top = n;
            this.count++;
        }
    }

    public String pop(){
        Node curTop = top;
        if(this.top != null) {
            top = top.getNextNode();
            curTop.setNextNode(null);
            this.count--;
        }
        return curTop.getData();
    }

    public String peek() {
        if(top != null) {
            return top.getData();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.count == 0 ? true : false;
    }

}

