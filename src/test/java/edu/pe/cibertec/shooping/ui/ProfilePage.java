package edu.pe.cibertec.shooping.ui;

import net.serenitybdd.screenplay.targets.Target;
import io.appium.java_client.AppiumBy;

public class ProfilePage {
    public static final Target LOGOUT_BUTTON =
            Target.the("Boton cerrar sesion")
                    .located(AppiumBy.xpath("//*[@content-desc='Cerrar sesión']"));

    public static final Target CONFIRM_LOGOUT = Target.the("confirm logout button")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Sí, cerrar sesión']"));
}
