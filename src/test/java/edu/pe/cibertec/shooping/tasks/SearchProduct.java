package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchProduct implements Task {

    private final String product;


    public SearchProduct(String product){
        this.product = product;
    }

    public static SearchProduct named(String product){
        return new SearchProduct(product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(product).into(CatalogPage.SEARCH_INPUT)
        );
    }

}
