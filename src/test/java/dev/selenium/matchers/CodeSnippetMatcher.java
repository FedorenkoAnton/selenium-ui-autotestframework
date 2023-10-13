package dev.selenium.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CodeSnippetMatcher extends TypeSafeMatcher<Map<String, String>> {
    private final Map<String, String> expectedMap;
    private Map<String, String> actualMap;
    private final Map<String, Boolean> compareResultsMap = new HashMap<>();


    public CodeSnippetMatcher(Map<String, String> expectedMap) {
        this.expectedMap = expectedMap;
    }

    @Override
    protected boolean matchesSafely(Map<String, String> actualMap) {
        this.actualMap = actualMap;
        Set<String> expectedMapKeySet = expectedMap.keySet();
        for (var key : expectedMapKeySet) {
            Boolean compareResult = expectedMap.get(key).equals(actualMap.get(key));
            compareResultsMap.put(key, compareResult);
        }
        return !compareResultsMap.containsValue(false);
    }

    @Override
    protected void describeMismatchSafely(Map<String, String> item, Description mismatchDescription) {
        if (item == null) {
            super.describeMismatchSafely(null, mismatchDescription);
        } else {
            mismatchDescription.appendText(createMismatchMessage(actualMap));
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(createMismatchMessage(expectedMap));
    }

    public static Matcher<Map<String, String>> hasSameCodeExamples(Map<String, String> expectedMap) {
        return new CodeSnippetMatcher(expectedMap);
    }

    private String createMismatchMessage(Map<String, String> mapWithItems) {
        final StringBuilder mismatchMessage = new StringBuilder();
        for (var key : compareResultsMap.keySet()) {
            if (!compareResultsMap.get(key)) {
                mismatchMessage.append(key).append(" = ");
                mapWithItems.get(key).chars()
                        .forEach(c -> mismatchMessage.append(toJavaSyntax((char) c)));
                mismatchMessage.append("\n").append("============================").append("\n");
            }
        }
        return mismatchMessage.toString();
    }

    private String toJavaSyntax(char ch) {
        switch (ch) {
            case '"':
                return ("\\\"");
            case '\n':
                return ("\\n");
            case '\r':
                return ("\\r");
            case '\t':
                return ("\\t");
            case '\\':
                return ("\\\\");
            default:
                return (String.valueOf(ch));
        }
    }
}
