package com.company;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ColorsTest {

    private static final int NUM_PRUEBAS = 1000;

    @Test
    public void getRandomColor() {
        for (int i = 0; i < NUM_PRUEBAS; i++) {
            final String randomColor = ColorConstants.getRandomColor();
            assertNotNull(randomColor);

            assertThat(randomColor, anyOf(
                    equalTo("verde"),
                    equalTo("rojo"),
                    equalTo("azul"),
                    equalTo("amarillo")
            ));
        }
    }
}
