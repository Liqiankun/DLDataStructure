import java.util.Stack;

public class Solution {
    public boolean isValid(String string){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i ++) {
            char c = string.charAt(i);
            System.out.print(c);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
             else {
                System.out.print("else");
                System.out.print(c);
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
