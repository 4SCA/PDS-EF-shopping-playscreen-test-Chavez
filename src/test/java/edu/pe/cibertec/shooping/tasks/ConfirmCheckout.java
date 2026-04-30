package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmCheckout implements Task {

    public ConfirmCheckout(){}

    public static ConfirmCheckout now(){
        return new ConfirmCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CheckoutPage.CONFIRM_BUTTON));
    }
}
