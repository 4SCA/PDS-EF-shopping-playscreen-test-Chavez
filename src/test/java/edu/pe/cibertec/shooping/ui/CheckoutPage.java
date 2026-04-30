package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    public static final Target ADDRESS_FIELD =
            Target.the("address field")
                    .located(AppiumBy.xpath("(//android.widget.EditText)[1]"));

    public static final Target CITY_FIELD =
            Target.the("city field")
                    .located(AppiumBy.xpath("(//android.widget.EditText)[2]"));

    public static final Target POSTAL_CODE_FIELD =
            Target.the("postal code field")
                    .located(AppiumBy.xpath("(//android.widget.EditText)[3]"));

    public static final Target YAPE_OPTION =
            Target.the("Yape payment option")
                    .located(AppiumBy.xpath("//android.widget.TextView[@text='Yape']"));

    public static final Target CONFIRM_BUTTON =
            Target.the("confirm checkout button")
                    .located(AppiumBy.xpath("//*[contains(@text,'Confirmar Compra')]"));

    public static final Target SUCCESS_TITLE =
            Target.the("order success title")
                    .located(AppiumBy.xpath("//android.widget.TextView[@text='¡Pedido Confirmado!']"));


    public static final Target ERROR_MESSAGE =
            Target.the("checkout error message")
                    .located(AppiumBy.xpath("//*[contains(@text,'dirección') and contains(@text,'requerida')]"));
}
