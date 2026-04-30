package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {

    public static final Target MENSAJE_CARRITO_VACIO =
            Target.the("empty cart message")
                    .located(AppiumBy.xpath("//android.widget.TextView[@text='Tu carrito está vacío']"));

    public static final Target BUTTON_CHECKOUT =
            Target.the("checkout button")
                    .located(AppiumBy.xpath("//android.widget.TextView[@text='Proceder al Pago']"));
}
