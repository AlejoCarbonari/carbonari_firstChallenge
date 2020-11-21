package tareas;

import UI.PaginaPrincipal;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class IrHacia implements Task {

    private Target seccion;
    private static String seccionElegida;

    public IrHacia(Target seccion){
        this.seccion = seccion;
    }

    public static Performable seccion(String seccion){
        seccionElegida = seccion;
        Target tgt; /* target auxiliar */

        if (seccionElegida == "Employees") {
            tgt = PaginaPrincipal.SECCION_EMPLOYEES;
        } else if (seccionElegida == "Deads") {
            tgt = PaginaPrincipal.SECCION_DEADS;
        } else if (seccionElegida == "Extras") {
            tgt = PaginaPrincipal.SECCION_EXTRAS;
        } else {
            tgt = null;
        }

        return Instrumented.instanceOf(IrHacia.class).withProperties(tgt);
    }

    @Override
    @Step("{0} decide ir a la sección de: #seccionElegida")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(this.seccion)
        );
    }
}
