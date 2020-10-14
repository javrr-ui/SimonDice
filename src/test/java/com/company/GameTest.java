package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void elJuegoNoComienzaHastaQueComienza() {
        Game game = new Game();
        assertFalse("El juego no debería estar como iniciado si no lo hemos iniciado explícitamente", game.haEmpezadoJuego());
        game.startWindowMode();
        assertTrue("El juego debería estar iniciado tras tratar de iniciarlo", game.haEmpezadoJuego());
    }

    @Test
    public void happyPath() {
        Game game = new Game();
        assertFalse("El juego no debería estar como iniciado si no lo hemos iniciado explícitamente", game.haEmpezadoJuego());
        game.startJuego();
        assertTrue("El juego debería estar iniciado tras tratar de iniciarlo", game.haEmpezadoJuego());
        assertTrue(game.isJuegoEnCurso());
        assertTrue(game.tamanoStackIguales());
        assertNotNull(game.getSecuencia());
        assertTrue(game.getSecuencia().empty());
    }

    @Test
    public void consoleMode() {

        //viendo que funcione ._.XD
        Game game = new Game();
        assertFalse("El juego no debería estar como iniciado si no lo hemos iniciado explícitamente", game.haEmpezadoJuego());
        game.consoleMode();
        assertTrue("El juego debería estar iniciado tras tratar de iniciarlo", game.haEmpezadoJuego());
        assertTrue(game.isJuegoEnCurso());
        assertTrue(game.tamanoStackIguales());
        assertNotNull(game.getSecuencia());
        assertTrue(game.getSecuencia().empty());
    }
}
