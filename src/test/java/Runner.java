
import UI.PaginaPrincipal;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tareas.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class Runner {

    public Runner(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver");
    }

    Actor actor;

    @Managed(options = "marionette", driver = "chrome")
    WebDriver nvg;

    @Before
    public void definimosElEsecenario(){
        actor = Actor.named("Poseidón");
        actor.can(BrowseTheWeb.with(nvg));
    }

    @Test
    public void darDeAltaUnItem() {
        /* El actor, abre el navegador */
        actor.has(Decidido.abrirElNavegador());

        /* Luego, el actor quiere ir a la sección de Employees */
        actor.attemptsTo(
                IrHacia.seccion("Employees")
        );

        /* Luego, el actor quiere agregar un nuevo ítem */
        actor.attemptsTo(
                HacerClickEn.boton(PaginaPrincipal.BOTON_ADD_ITEM)
                .then(Rellenar.campos("ZeuS", 3))
        );

        /* Entonces, debería visualizar el alert exitoso */
        actor.attemptsTo(
                Ensure.that(PaginaPrincipal.ALERT_SUCCESS).isDisplayed()
        );
    }

    @Test
    public void darDeAltaUnItemEnDeads() {
        actor.has(Decidido.abrirElNavegador());

        actor.attemptsTo(
                IrHacia.seccion("Deads")
                .then(HacerClickEn.boton(PaginaPrincipal.BOTON_ADD_ITEM))
                .then(Rellenar.campos("Zeus", "Uknown"))
        );
    }

}
