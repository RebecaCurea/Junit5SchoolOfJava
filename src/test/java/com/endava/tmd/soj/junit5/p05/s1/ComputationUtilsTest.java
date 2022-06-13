package com.endava.tmd.soj.junit5.p05.s1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Provocare: Copiati metodele de test din tema precedenta, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare
class ComputationUtilsTest {

    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
       // assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
        //ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        //assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
       assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        // AssertJ
        assertThatThrownBy(() -> sum(-2147483648, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }


    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(0, 0));

        // AssertJ Assertion
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(0, 0)).isZero();
    }

    @Test
    void zeroShouldNotChangePositive() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(0,3)).isEqualTo(3);
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(0,-3)).isEqualTo(-3);
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(7,8)).isEqualTo(15);
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(-7,-8)).isEqualTo(-15);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(-7,9)).isEqualTo(2);
    }

    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(-7,5)).isEqualTo(-2);
    }
    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void maxIntAndANegativeNumber() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(Integer.MAX_VALUE, -2)).isEqualTo(2147483645);
    }
    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(0, Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    void minIntAndAPositiveNumber() { assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(Integer.MIN_VALUE,2)).isEqualTo(-2147483646); }
    @Test
    void minIntAndMaxInt() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }
    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(com.endava.tmd.soj.junit5.p01.ComputationUtils.sum(2, Integer.MAX_VALUE)).isEqualTo(2147483649L);
    }
}


