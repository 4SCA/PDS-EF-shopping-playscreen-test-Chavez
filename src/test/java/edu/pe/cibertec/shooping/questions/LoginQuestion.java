package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.LoginScreen;
import net.serenitybdd.screenplay.Question;

public class LoginQuestion {
    public static Question<Boolean> loginTitleVisible() {
        return Question.about("login title visible").answeredBy(
                actor -> LoginScreen.LOGIN_TITLE.resolveFor(actor).isVisible()
        );
    }
}
