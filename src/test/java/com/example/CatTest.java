package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void getSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Неверный звук кота","Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> expectedRes = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Не верно выбрано питание",expectedRes, cat.getFood());
    }
}