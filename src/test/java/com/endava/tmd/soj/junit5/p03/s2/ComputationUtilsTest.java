package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {

    @Test
    @Order(1)
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @Test
    @Order(3)
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 3)).isEqualTo(3);
    }

    @Test
    @Order(2)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -3)).isEqualTo(-3);
    }

    @Test
    @Order(5)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(7, 8)).isEqualTo(15);
    }

    @Test
    @Order(4)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-7, -8)).isEqualTo(-15);
    }

    @Test
    @Order(7)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-7, 9)).isEqualTo(2);
    }

    @Test
    @Order(6)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-7, 5)).isEqualTo(-2);
    }

}
