package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class OpenProfile implements Task {

    public static OpenProfile now() { return new OpenProfile();}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CatalogPage.PROFILE_BUTTON));
    }
}
