package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FillCheckout implements Task {
    private final String direccion;
    private final String ciudad;
    private final String codPostal;

    public FillCheckout(String direccion, String ciudad, String codPostal){
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
    }

    public static FillCheckout withData(String direccion, String ciudad, String codPostal){
        return new FillCheckout(direccion,ciudad,codPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.ADDRESS_FIELD),
                Enter.theValue(direccion).into(CheckoutPage.ADDRESS_FIELD),

                Click.on(CheckoutPage.CITY_FIELD),
                Enter.theValue(ciudad).into(CheckoutPage.CITY_FIELD),

                Click.on(CheckoutPage.POSTAL_CODE_FIELD),
                Enter.theValue(codPostal).into(CheckoutPage.POSTAL_CODE_FIELD)
        );
    }
}
