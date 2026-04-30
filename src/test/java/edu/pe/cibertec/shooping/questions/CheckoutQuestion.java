package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class CheckoutQuestion {

    public static Question<Boolean> ordenConfirmada(){
        return Visibility.of(CheckoutPage.SUCCESS_TITLE).asBoolean();
    }

    public static Question<Boolean> errorVisible(){
        return Visibility.of(CheckoutPage.ERROR_MESSAGE).asBoolean();
    }
}
