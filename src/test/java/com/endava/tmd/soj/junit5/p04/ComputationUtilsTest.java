package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
class ComputationUtilsTest {

    @DisplayName("0+0=0")
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }
    @DisplayName("0+3=3")
    @Test
    void zeroShouldNotChangePositive() {
        assertThat(sum(0,3)).isEqualTo(3);
    }
    @DisplayName("0-3=-3")
    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0,-3)).isEqualTo(-3);
    }
    @DisplayName("7+8=15")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(7,8)).isEqualTo(15);
    }
    @DisplayName("-7-8=-15")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-7,-8)).isEqualTo(-15);
    }
    @DisplayName("-7+9=2")
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-7,9)).isEqualTo(2);
    }
    @DisplayName("-7+5=-2")
    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-7,5)).isEqualTo(-2);
    }
    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(Integer.MAX_VALUE, -2)).isEqualTo(2147483645);
    }
    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(0, Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    void minIntAndAPositiveNumber() { assertThat(sum(Integer.MIN_VALUE,2)).isEqualTo(-2147483646); }
    @Test
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }
    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(2, Integer.MAX_VALUE)).isEqualTo(2147483649L);
    }

}
