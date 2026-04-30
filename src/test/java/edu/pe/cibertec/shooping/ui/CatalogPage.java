package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CatalogPage {

    public static final Target SEARCH_INPUT =
            Target.the("Buscador de Productos")
                    .located(AppiumBy.xpath("//android.widget.EditText"));

    public static Target categoria(String categoria) {
        return Target
                .the(categoria + " categoria filter")
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + categoria + "']"));
    }

    public static Target productoPorNombre(String producto) {
        return Target.the("Producto que contiene: " + producto)
                .located(AppiumBy.xpath(
                        "//android.widget.TextView[contains(@text,'" + producto + "')]"
                ));
    }

    public static final Target FIRST_ADD_BUTTON =
            Target.the("primer botón agregar al carrito")
                    .located(AppiumBy.xpath(
                            "(//*[@content-desc='Agregar al carrito'])[1]"
                    ));
    public static final Target CART_BUTTON =
            Target.the("cart button")
                    .located(AppiumBy.xpath("//android.widget.TextView[@text=\"Carrito\"]"));
}
