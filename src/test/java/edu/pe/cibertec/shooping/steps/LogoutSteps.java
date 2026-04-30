package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.LoginQuestion;
import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.tasks.OpenProfile;
import edu.pe.cibertec.shooping.ui.ProfilePage;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actions.Click.on;
import static org.hamcrest.Matchers.equalTo;

public class LogoutSteps {

//    @Given("que el usuario esta logueado en la aplicacion")
//    public void usuarioLogueado() {
//        OnStage.theActorInTheSpotlight().should(
//                seeThat(TheMainScreen.isVisible(), equalTo(true))
//        );
//    }

    @When("hace clic en el menu de usuario")
    public void abrePerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenProfile.now()
        );
    }

    @And("hace clic en cerrar sesion")
    public void haceCerrarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.LOGOUT_BUTTON),
                Click.on(ProfilePage.CONFIRM_LOGOUT)
        );
    }

    @Then("deberia regresar a la pantalla de login")
    public void validaLogin() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginQuestion.loginTitleVisible(), equalTo(true))
        );
    }
}
