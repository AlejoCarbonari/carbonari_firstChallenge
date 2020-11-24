package tareas;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Visualizar implements Task {

    private String contenido;

    public Visualizar(String contenido) {
        this.contenido = contenido;
    }

    @Override
    @Step("{} debería ver el alert exitoso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            /* p/realizar pruebas con la documentacion [IGNORAR CLASE] */
        );
    }

    public static Performable alertSuccess(String contenido) {
        return Instrumented.instanceOf(Visualizar.class).withProperties(contenido);
    }

}
