package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.*;

import java.text.NumberFormat;
import java.util.Locale;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class ScoreTest{
    private Score score;
    private static NumberFormat nf;
    @BeforeAll
    static void setupLocale(){
       Locale.setDefault(Locale.US);
        //Locale.setDefault(Locale.FRANCE);
        nf= NumberFormat.getInstance(Locale.getDefault());
        nf.setMinimumFractionDigits(1);

    }

    @BeforeEach
    void setupScore(){
        score=new Score();
    }
    @Test
    void noAnswer(){
        assertThat(score.getPercent()).isEqualTo(nf.format(100.0));
    }

    @Test
    void noneIncorrect(){
        assertThat(score.addCorrectAnswer().getPercent()).isEqualTo(nf.format(100.0));
    }

    @Test
    void percentForTwoIncorrectAnswerAndOneCorrectAnswerTest(){
        assertThat(score.addIncorrectAnswer().addIncorrectAnswer().addCorrectAnswer().getPercent()).isEqualTo(nf.format(33.3));
    }

    @Test
    void percentForOneIncorrectAnswerAndTwoCorrectAnswerTest(){
        assertThat(score.addIncorrectAnswer().addCorrectAnswer().addCorrectAnswer().getPercent()).isEqualTo(nf.format(66.7));
    }


}
