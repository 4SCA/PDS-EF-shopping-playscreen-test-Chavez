package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {

    public AddProductToCart () { }

    public static AddProductToCart first() {
        return new AddProductToCart();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CatalogPage.FIRST_ADD_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CatalogPage.FIRST_ADD_BUTTON)
        );
    }
}
