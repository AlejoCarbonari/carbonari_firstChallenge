package tareas;

import UI.PaginaPrincipal;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class HacerClickEn implements Task {

    private Target boton;
    private String descripcion_boton;

    public HacerClickEn(Target boton){
        this.boton = boton;
        this.descripcion_boton = devuelveDescripcionBoton(boton);
    }

    public String devuelveDescripcionBoton(Target boton){
        String descripcion_boton;

        if (boton == PaginaPrincipal.BOTON_ADD_ITEM) {
            return "agregar ítem";
        } else if (boton == PaginaPrincipal.BOTON_EDIT_ITEM) {
            return "editar ítem";
        } else if (boton == PaginaPrincipal.BOTON_DELETE_ITEM) {
            return "eliminar ítem";
        } else {
            return "";
        }
    }

    public static Performable boton(Target boton){
        return Instrumented
                .instanceOf(HacerClickEn.class)
                .withProperties(boton);
    }

    @Override
    @Step("{0} decide hacer click en: #descripcion_boton")
    public <T extends Actor> void performAs(T actor) {
        if (this.boton == PaginaPrincipal.BOTON_DELETE_ITEM) {
            actor.attemptsTo(
                 Click.on(this.boton)
                    .then(Switch.toAlert())
            );
        } else {
            actor.attemptsTo(
                 Click.on(this.boton)
            );
        }
    }

}
