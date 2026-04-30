package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.FilterByCategory;
import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.tasks.SearchProduct;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Assertions;

public class CatalogSteps {
    @Given("que el usuario esta logueado en la aplicacion")
    public void usuarioLogueado() {

        OnStage.theActorCalled("Andrea");

        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials("user1@test.com", "password1")
        );
    }

    @When("navega al catalogo de productos")
    public void navegaCatalogo(){
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheMainScreen.isVisible(), equalTo(true)));
    }

    @Given("que el usuario esta en el catalogo")
    public void usuarioEnCatalogo(){
        OnStage.theActorCalled("Andrea");

        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials("user1@test.com", "password1")
        );

        theActorInTheSpotlight()
                .should(seeThat(TheMainScreen.isVisible(), equalTo(true)));
    }


    @When("busca el producto {string}")
    public void buscaProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(
                SearchProduct.named(producto)
        );
    }

    @Then("deberia ver productos que contengan {string}")
    public void validarBusqueda(String producto) {

        boolean visible = CatalogPage.productoPorNombre(producto)
                .resolveFor(theActorInTheSpotlight())
                .isVisible();

        Assertions.assertTrue(visible,
                "No se encontraron productos con: " + producto);
    }

    @When("filtra productos por la categoria {string}")
    public void filtrarCategoria(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                FilterByCategory.of(categoria)
        );
    }

    @Then("deberia ver la lista de productos disponibles")
    public void validarListaProductos() {

        boolean visible = CatalogPage.SEARCH_INPUT
                .resolveFor(theActorInTheSpotlight())
                .isVisible();

        Assertions.assertTrue(visible,
                "No se muestra el catálogo de productos");
    }

    @Then("deberia ver solo productos de la categoria {string}")
    public void validarCategoria(String categoria) {

        boolean visible = CatalogPage.categoria(categoria)
                .resolveFor(theActorInTheSpotlight())
                .isVisible();

        Assertions.assertTrue(visible,
                "El filtro por categoría falló: " + categoria);
    }
}
