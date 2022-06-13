package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.MethodName.class)
class ComputationUtilsTest {
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @Test
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 3)).isEqualTo(3);
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -3)).isEqualTo(-3);
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(7, 8)).isEqualTo(15);
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-7, -8)).isEqualTo(-15);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-7, 9)).isEqualTo(2);
    }

    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-7, 5)).isEqualTo(-2);
    }
}
