package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    @Parameterized.Parameter()
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedSex;

    @Parameterized.Parameters(name = "Lion sex: {0}, expectedHasMane: {1}")
    public static Object[][] params() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }


    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals("принадлежность к полу указана неверно",expectedSex, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectedRes = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals("Ошибочный рацион животного",expectedRes, lion.getFood());
    }
    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, feline);
        assertEquals("Ошибочное число котят",1, lion.getKittens());
    }
}