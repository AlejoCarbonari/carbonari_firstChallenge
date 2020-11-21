package UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal {

    /* BOTONES DE REDIRECCIÓN */
    public static final Target SECCION_EMPLOYEES = Target.the("BOTÓN_SECCION_EMPLOYEES")
                                                             .located(By.cssSelector("a:nth-child(2)")),

                               SECCION_DEADS     = Target.the("BOTÓN_SECCION_DEADS")
                                                             .located(By.cssSelector("a:nth-child(3)")),

                               SECCION_EXTRAS    = Target.the("BOTÓN_SECCION_EXTRAS")
                                                             .located(By.cssSelector("a:nth-child(4)"));

    /* BOTONES DE ACCIONES */
    public static final Target BOTON_ADD_ITEM = Target.the("BOTÓN_AGREGAR_ITEM")
                                                          .located(By.cssSelector(".green:nth-child(2)")),
                               BOTON_EDIT_ITEM = Target.the("BOTON_EDITAR_ITEM")
                                                          .located(By.cssSelector("tr:nth-child(1) .button:nth-child(1)")),
                               BOTON_DELETE_ITEM = Target.the("BOTÓN_ELIMINAR_ITEM")
                                                          .located(By.cssSelector("tr:nth-child(1) .button:nth-child(2)")),
                               BOTON_SUBMIT = Target.the("BOTÓN_GUARDAR_NUEVO_ITEM")
                                                          .located(By.cssSelector("div.popup.form-popup button.button.green"));


    /* ALERTA */
    public static final Target ALERT_SUCCESS = Target.the("ALERT_SUCCESS")
                                                          .located(By.cssSelector("div.Toastify__toast.Toastify__toast--success"));


    /* CAMPOS */
    public static final Target CAMPO_NAME = Target.the("CAMPO_NOMBRE")
                                                      .located(By.xpath("//label[text()='Name']/following-sibling::input"));
}
