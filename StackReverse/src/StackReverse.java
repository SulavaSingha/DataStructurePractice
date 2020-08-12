import java.util.Stack;

public class StackReverse {
    public void reverse(int p, Stack<Integer>stack){
        stack.push(p);
        System.out.println(stack.peek());
    }
    public void pushToReverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;

            int p=stack.pop();
            pushToReverse(stack);
            reverse(p,stack);

    }
    public static void main(String[] agrs){
        Stack<Integer> stack= new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack ");
        StackReverse s= new StackReverse();
        s.pushToReverse(stack);
    }
}
