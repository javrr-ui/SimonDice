package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void elJuegoNoComienzaHastaQueComienza() {
        Game game = new Game();
        assertFalse( "El juego no debería estar como iniciado si no lo hemos iniciado explícitamente",game.haEmpezadoJuego());
        game.startWindowMode();
        assertTrue( "El juego debería estar iniciado tras tratar de iniciarlo",game.haEmpezadoJuego());

        assertTrue( "reiniciar el juego debería de dejarlo iniciado",game.haEmpezadoJuego());
        Game game1 = new Game();
        assertFalse( "El juego no debería estar como iniciado si no lo hemos iniciado explícitamente",game1.haEmpezadoJuego());


    }
}
