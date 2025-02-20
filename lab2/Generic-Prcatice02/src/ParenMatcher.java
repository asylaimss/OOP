import java.util.Deque;
import java.util.ArrayDeque;

public class ParenMatcher {
    private Deque<Character> stack = new ArrayDeque<>();

    public boolean processLine(String line) {
        stack.clear();
        char[] curLine = line.toCharArray();

        for (char c : curLine) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false; // Закрывающая скобка без открывающей
                    }
                    stack.pop();
                    break;
            }
        }

        return stack.isEmpty(); // Если стек пуст — всё правильно, иначе есть незакрытые скобки
    }
}