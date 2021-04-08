package com.company;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
        InputStream viejaentrada = System.in;
        StringBufferInputStream nuevaentrada = new StringBufferInputStream("4\n");
        System.setIn(nuevaentrada);

        ByteArrayOutputStream salidaBinaria = new ByteArrayOutputStream();
        PrintStream salida = new PrintStream(salidaBinaria);
        PrintStream viejaSalida = System.out;
        // Use my stream
        System.setOut(salida);

        Game game = new Game();
        exit.expectSystemExitWithStatus(0);
        game.consoleMode();
        exit.checkAssertionAfterwards(
                new Assertion() {
                    @Override
                    public void checkAssertion() throws Exception {

                        assertFalse("El juego no debería estar como iniciado si no lo hemos iniciado explícitamente", game.haEmpezadoJuego());
                        assertEquals(salidaBinaria.toString(),"");
                        // Put things back
                        System.out.flush();
                        System.setOut(viejaSalida);
                        System.setIn(viejaentrada);
                    }
                }
        );
    }
}
