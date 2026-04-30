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
}
