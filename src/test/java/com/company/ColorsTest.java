package com.company;


//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorsTest {

    @Test
    public void getRandomColor() {
        String randomColor = Colors.getRandomColor();
        assertNotNull(randomColor);
    }
}
