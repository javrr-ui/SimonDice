package com.company;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ColorsTest {

    @Test
    public void getRandomColor() {
        String randomColor = Colors.getRandomColor();
        assertNotNull(randomColor);
    }

    public static void main(String[] args) {

    }
}
