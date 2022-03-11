package org.anshin.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void contain() {
        assertAll(
                () -> assertTrue(Operation.contain("SUM")),
                () -> assertTrue(Operation.contain("SUBTRACT")),
                () -> assertTrue(Operation.contain("DIVIDE")),
                () -> assertTrue(Operation.contain("MULTIPLY"))
        );

        assertAll(
                () -> assertTrue(Operation.contain("SUM")),
                () -> assertTrue(Operation.contain("sum")),
                () -> assertFalse(Operation.contain("   SUM   ")),
                () -> assertFalse(Operation.contain("   sum   "))
        );
    }

    @Test
    void calculate() {
        assertAll(
                () -> assertEquals(2.0, Operation.SUM.calculate(1.5, 0.5)),
                () -> assertEquals(3, Operation.SUM.calculate(1, 2)),
                () -> assertEquals(4.5, Operation.SUM.calculate(5, -0.5))
        );

        assertAll(
                () -> assertEquals(1.0, Operation.SUBTRACT.calculate(1.5, 0.5)),
                () -> assertEquals(-1, Operation.SUBTRACT.calculate(1, 2)),
                () -> assertEquals(5.5, Operation.SUBTRACT.calculate(5, -0.5))
        );

        assertAll(
                () -> assertEquals(3, Operation.DIVIDE.calculate(1.5, 0.5)),
                () -> assertEquals(0.5, Operation.DIVIDE.calculate(1, 2)),
                () -> assertEquals(-10, Operation.DIVIDE.calculate(5, -0.5))
        );

        assertAll(
                () -> assertEquals(0.75, Operation.MULTIPLY.calculate(1.5, 0.5)),
                () -> assertEquals(2, Operation.MULTIPLY.calculate(1, 2)),
                () -> assertEquals(-2.5, Operation.MULTIPLY.calculate(5, -0.5))
        );
    }

    @Test
    void getDBId() {
        assertAll(
                () -> assertEquals(1, Operation.SUM.getDBId()),
                () -> assertEquals(2, Operation.SUBTRACT.getDBId()),
                () -> assertEquals(3, Operation.DIVIDE.getDBId()),
                () -> assertEquals(4, Operation.MULTIPLY.getDBId())
        );
    }
}