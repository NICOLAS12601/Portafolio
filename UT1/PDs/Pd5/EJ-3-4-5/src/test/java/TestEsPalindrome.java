package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEsPalindrome {

    @Test
    public void testPalindrome(){
        String coca=new String("coca");
        esPalindromo palindromo=new esPalindromo();
        boolean result=palindromo.esPalindromo(coca);
        assertFalse(result, "La variable debería ser falsa");
    }
}
