package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectYape implements Task {
    public SelectYape(){}

    public static SelectYape metodoPago(){
        return new SelectYape();
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CheckoutPage.YAPE_OPTION));
    }
}
