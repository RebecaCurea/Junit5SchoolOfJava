package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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

    @BeforeAll
    void init(){
        score=new Score();
    }

    @Test
    void percentForTwoIncorrectAnswerAndOneCorrectAnswerTest(){
        assertEquals("33.3",score.addIncorrectAnswer().addIncorrectAnswer().addCorrectAnswer().getPercent());
    }
}
