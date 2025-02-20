public class Main {
    public static void main(String[] args) {
        ParenMatcher matcher = new ParenMatcher();
        String[] testLines = {
                "(a + b) * (c - d)",  // valid
                "((a + b) * (c - d)", // invalid
                "(a + b))",           // invalid
                "((a + b) * (c - d))" // valid
        };

        for (int i = 0; i < testLines.length; i++) {
            boolean isValid = matcher.processLine(testLines[i]);
            System.out.println("Line " + i + " is " + (isValid ? "valid" : "invalid"));
        }
    }
}