package org.sergey.ans.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void contain() {
        assertTrue(Operation.contain("SUM"));
        assertTrue(Operation.contain("sum"));
        assertTrue(Operation.contain("SUBTRACT"));
        assertTrue(Operation.contain("DIVIDE"));
        assertTrue(Operation.contain("MULTIPLY"));

        assertFalse(Operation.contain("sum "));
        assertFalse(Operation.contain(" "));
    }

    @Test
    void calculate() {
        assertEquals(8, Operation.SUM.calculate(2, 6));
        assertEquals(8.4, Operation.SUM.calculate(2.1, 6.3));
        assertEquals(-4, Operation.SUBTRACT.calculate(2, 6));
        assertEquals(-4.7, Operation.SUBTRACT.calculate(2.2, 6.9));
        assertEquals(0.5, Operation.DIVIDE.calculate(3, 6));
        assertEquals(7, Operation.DIVIDE.calculate(3.5, 0.5));
        assertEquals(20, Operation.MULTIPLY.calculate(10, 2));
        assertEquals(2.2, Operation.MULTIPLY.calculate(1.1, 2));
    }
}