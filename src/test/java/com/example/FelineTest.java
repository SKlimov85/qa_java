package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedRes = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Не верно выбрано питание",expectedRes, feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        assertEquals("Неверно названо семейство","Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        assertEquals("Ошибочное число котят",1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals("Ошибочное число котят",5, feline.getKittens(5));
    }
}