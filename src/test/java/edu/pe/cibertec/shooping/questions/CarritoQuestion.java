package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class CarritoQuestion {
    public static Question<Boolean> isEmpty(){
        return Visibility.of(CarritoPage.MENSAJE_CARRITO_VACIO).asBoolean();
    }

}
