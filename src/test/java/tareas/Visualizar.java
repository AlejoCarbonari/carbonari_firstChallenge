package tareas;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Visualizar implements Task {

    public Visualizar() {
    }

    @Override
    @Step("{} debería ver el alert exitoso")
    public <T extends Actor> void performAs(T actor) {

    }

    public static Performable alertSuccess() {
        return (Performable) Instrumented.instanceOf(Visualizar.class);
    }

}
