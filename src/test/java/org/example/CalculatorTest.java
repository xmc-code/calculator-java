package org.example;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CalculatorTest {
    private void simulateInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
    @Test
    void testAddition() {
        simulateInput("5\n+\n3\n");
        Calculator.main(new String[]{});
    }
    @Test
    void testDivision() {
        simulateInput("10\n/\n2\n");
        Calculator.main(new String[]{});
    }
    @Test
    void testDivisionByZero() {
        simulateInput("5\n/\n0\n");
        Calculator.main(new String[]{});
    }
    @Test
    void testInvalidOperator() {
        simulateInput("5\n^\n3\n");
        Calculator.main(new String[]{});
    }
    @Test
    void testInvalidNumber() {
        simulateInput("afd\n+\n3\n");
        Calculator.main(new String[]{});
    }
}
