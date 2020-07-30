package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeTest {
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;
    private BibliotecaApp bibliotecaApp = null;

    @Before
    public void before() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void shouldPrintWelcomeMsg() {
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcome();
        String expected = new String("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        assertEquals(expected, bytes.toString().trim().replace("\r",""));
    }

    @Test
    public void chooseInvalidNumberForNextStep() {
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.choosePart(5);
        String expected = new String("Please select a valid option");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }



    @After
    public void After() {
        System.setOut(console);
    }

}
