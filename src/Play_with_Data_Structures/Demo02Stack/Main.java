package Play_with_Data_Structures.Demo02Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Object> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
