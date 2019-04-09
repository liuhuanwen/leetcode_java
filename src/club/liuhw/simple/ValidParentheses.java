package club.liuhw.simple;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(()){}"));
    }

    /**
     * 利用stack来实现
     * */
    private static boolean isValid(String s) {
        if (s.length() == 1 || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')') {
                    if (stack.pop() != '(') return false;
                }
                if (c == ']') {
                    if (stack.pop() != '[') return false;
                }
                if (c == '}') {
                    if (stack.pop() != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
