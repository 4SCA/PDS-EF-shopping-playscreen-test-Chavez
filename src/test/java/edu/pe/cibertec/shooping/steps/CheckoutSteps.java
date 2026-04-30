package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.CarritoQuestion;
import edu.pe.cibertec.shooping.questions.CheckoutQuestion;
import edu.pe.cibertec.shooping.tasks.*;
import edu.pe.cibertec.shooping.ui.CarritoPage;
import edu.pe.cibertec.shooping.ui.CheckoutPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSteps {
    private String direccion;
    private String ciudad;
    private String codPostal;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
    }

    @After
    public void tearDown() {
        OnStage.drawTheCurtain();
    }

    @Given("que el usuario tiene productos en el carrito")
    public void usuarioConProductos() {
        OnStage.theActorCalled("Andrea").attemptsTo(Login.withCredentials("user1@test.com", "password1"),
                AddProductToCart.first(),
                OpenCart.now());
    }

    @When("procede al checkout")
    public void procedeCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(CarritoPage.BUTTON_CHECKOUT));
    }

    @And("ingresa los datos de envio")
    public void ingresaDatos() {
        direccion = "Av. Test 123";
        ciudad = "Lima";
        codPostal = "15001";
        OnStage.theActorInTheSpotlight().attemptsTo(FillCheckout.withData(direccion, ciudad, codPostal),
                SelectYape.metodoPago());
    }

    @And("confirma la compra")
    public void confirmaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConfirmCheckout.now());
    }

    @Then("deberia ver el mensaje de compra exitosa")
    public void validarCompraExitosa() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CheckoutQuestion.ordenConfirmada(), equalTo(true))
        );
    }

    @Given("que el usuario tiene el carrito vacio")
    public void carritoVacio() {
        OnStage.theActorCalled("Andrea").attemptsTo(
                Login.withCredentials("user1@test.com", "password1")

        );
    }

    @When("intenta proceder al checkout")
    public void intentaProcederCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenCart.now()
        );
    }

    @Then("deberia ver mensaje de carrito vacio")
    public void valida_carrito_vacio() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CarritoQuestion.isEmpty(), equalTo(true))
        );
    }

    @And("ingresa los datos de envio sin direccion")
    public void datos_sin_direccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.ADDRESS_FIELD, isVisible()).forNoMoreThan(10).seconds(),

                // Dirección vacía
                Click.on(CheckoutPage.ADDRESS_FIELD),
                Clear.field(CheckoutPage.ADDRESS_FIELD),

                Click.on(CheckoutPage.CITY_FIELD),
                Clear.field(CheckoutPage.CITY_FIELD),

                Click.on(CheckoutPage.POSTAL_CODE_FIELD),
                Clear.field(CheckoutPage.POSTAL_CODE_FIELD),

                SelectYape.metodoPago()
        );
    }

    @And("intenta confirmar la compra")
    public void intenta_confirmar_compra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmCheckout.now()
        );
    }

    @Then("deberia ver el mensaje de error {string}")
    public void valida_error(String mensaje) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CheckoutQuestion.errorVisible(), equalTo(true))
        );
    }
}