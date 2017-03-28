package ekordik.cuw.edu.shuntingyard2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private EditText inputExpression;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputExpression = (EditText)findViewById(R.id.etExpression);
        output = (TextView)findViewById(R.id.txtOutput);
    }

    public void processExpression(View view) {
        if(inputExpression.getText().length() > 0) {
            Queue input = new Queue();
            StringTokenizer st = new StringTokenizer(this.inputExpression.getText().toString(), "+-/*", true);
            while(st.hasMoreTokens()) {
                input.enqueue(st.nextToken());
            }
            Queue output = new Queue();
            Stack operators = new Stack();
            while(input.getCount() > 0) {
                String s = input.dequeue();
                switch(s) {
                    case "/":
                        if(!operators.isEmpty() && operators.peek().equals("*")) {
                            output.enqueue(operators.pop());
                        }
                        operators.push(s);
                        break;
                    case "*":
                        if(!operators.isEmpty() && operators.peek().equals("/")) {
                            output.enqueue(operators.pop());
                        }
                        operators.push(s);
                        break;
                    case "+":
                        if(!operators.isEmpty()) {
                            if(operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("-")) {
                                output.enqueue(operators.pop());
                            }
                        }
                        operators.push(s);
                        break;
                    case "-":
                        if(!operators.isEmpty()) {
                            if (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("+")) {
                                output.enqueue(operators.pop());
                            }
                        }
                        operators.push(s);
                        break;
                    default:
                        output.enqueue(s);
                }
            }
            while(!operators.isEmpty()) {
                output.enqueue(operators.pop());
            }
            display(output);
        }
    }

    private void display(Queue queue) {
        int size = queue.getCount();
        String expression = "";
        for(int i = 0; i < size; i++) {
            String s = queue.dequeue();
            expression += s + " ,";
            queue.enqueue(s);
        }
        output.setText(expression);
    }
}
