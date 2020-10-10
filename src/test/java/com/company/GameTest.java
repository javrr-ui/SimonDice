package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void elJuegoNoComienzaHastaQueComienza() {
        Game game = new Game();
        assertFalse(game.haEmpezadoJuego(), "El juego no debería estar como iniciado si no lo hemos iniciado explícitamente");
        game.start();
        assertTrue(game.haEmpezadoJuego(), "El juego debería estar iniciado tras tratar de iniciarlo");
        game.restart();
        assertTrue(game.haEmpezadoJuego(), "reiniciar el juego debería de dejarlo iniciado");
        Game game1 = new Game();
        assertFalse(game1.haEmpezadoJuego(), "El juego no debería estar como iniciado si no lo hemos iniciado explícitamente");
        game1.restart();
        assertTrue(game1.haEmpezadoJuego(), "reiniciar el juego al inicio debería de dejarlo iniciado");
    }
}
