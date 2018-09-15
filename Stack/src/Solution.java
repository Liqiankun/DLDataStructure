public class Solution {
    public boolean isValid(String string){
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < string.length(); i ++) {
            char c = string.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
             else {
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
