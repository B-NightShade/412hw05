import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean balance = true;
        System.out.println("enter some chars: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = bufferedReader.readLine();
            String input = line;
            char []ch = input.toCharArray();
            Stack <Character> stack = new Stack <Character>();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                    stack.push(ch[i]);
                }
                else if (ch[i] == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        balance = false;
                    }
                }
                else if (ch[i] == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        balance = false;
                    }
                }
                else if (ch[i] == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        balance = false;
                    }
                }
                if(balance == true) {
                    balance = stack.isEmpty();
                }
            }
            String msg = String.format("input = %s, balanced = %s", input, balance);
            System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
