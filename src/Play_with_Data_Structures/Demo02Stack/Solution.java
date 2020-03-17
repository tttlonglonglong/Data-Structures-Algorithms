package Play_with_Data_Structures.Demo02Stack;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                // 入栈
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return  false;
                // 出栈
                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("()[]{}"));
    }
}
