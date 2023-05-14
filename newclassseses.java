import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OuderTest{
    @Test
    void testRedenGeaccepteerdTrue(){
        Ouder moeder = new Ouder("Hanan" , "Mahamud", 47);
        // Reden wordt geaccepteert
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(true,true, true , true ));
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(true,false, true, true ));
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(true,true, false ,true ));

        //Reden wordt niet geaccepteert
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(true,false, false, false));
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(false,true, true, false ));
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(false,false, true, false ));
        Assertions.assertDoesNotThrow(() -> moeder.accepteerOfWeigerRedenVanKind(false,false, false , false ));
    }
}