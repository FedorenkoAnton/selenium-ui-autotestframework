package dev.selenium.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.selenium.matchers.CodeSnippetMatcher.hasSameCodeExamples;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CodeSnippetMatcherTests {
    private final Map<String, String> actualMap = Map.of(
            "string1", "example of string1",
            "string2", "example of string2",
            "string3", "example of string3"
    );

    private final Map<String, String> expectedMap = Map.of(
            "string1", "example of string1",
            "string2", "example of string2",
            "string3", "example of string3"
    );

    private final Map<String, String> mapWithDifferentValues = Map.of(
            "string1", "example of string11",
            "string2", "example of string22",
            "string3", "example of string33"
    );

    @Test
    void twoMapsWithSameValuesAreEqual() {
        assertThat(actualMap, hasSameCodeExamples(expectedMap));
    }

    @Test
    void differentMapsNotEqual() {
        assertThrows(AssertionError.class , ()-> assertThat(actualMap, hasSameCodeExamples(mapWithDifferentValues)));
    }

    @Test
    void expectedErrorMessageDisplays() {
        String expectedMessage =
                "\r\n" +
                        "Expected: string3 = example of string33\n" +
                        "============================\n" +
                        "string1 = example of string11\n" +
                        "============================\n" +
                        "string2 = example of string22\n" +
                        "============================\n" +
                        "\r\n" +
                        "     but: string3 = example of string3\n" +
                        "============================\n" +
                        "string1 = example of string1\n" +
                        "============================\n" +
                        "string2 = example of string2\n" +
                        "============================\n";
        AssertionError thrown = Assertions
                .assertThrows(AssertionError.class,
                        () -> assertThat(actualMap, hasSameCodeExamples(mapWithDifferentValues)));
        assertEquals(expectedMessage, thrown.getMessage());
    }
}
