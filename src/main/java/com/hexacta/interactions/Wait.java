package com.hexacta.interactions;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.Objects;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.exceptions.ElementShouldBePresentException;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.NoSuchElementException;
import static com.hexacta.utils.CurrentActor.actor;
import static com.hexacta.utils.enums.GenericEnums.IS_NOT_PRESENT;
import static com.hexacta.utils.enums.GenericEnums.IS_PRESENT;

public class Wait implements Interaction {
    private final Target element;
    private long atMostSeconds = 30L;
    private long pollIntervalSeconds = 1L;
    private String expectedState;

    public Wait(Target element) {
        this.element = element;
    }

    @Step("{0} espera poder interactuar con el #element por #atMostSeconds segundos en intervalos de #pollIntervalSeconds segundos")
    public <T extends Actor> void performAs(T actor) {
        try {
            Awaitility.with().await().pollInSameThread().atMost(Duration.ofSeconds(this.atMostSeconds)).pollInterval(Duration.ofSeconds(this.pollIntervalSeconds)).ignoreException(NoSuchElementException.class).ignoreException(ElementShouldBePresentException.class).until(askForThe(this.element, this.expectedState));
        } catch (ConditionTimeoutException var3) {
            if (!Objects.equals(IS_NOT_PRESENT.getValue(), this.expectedState)) {
                throw new AssertionError(String.format("No fue posible interactuar con el elemento '%s' - '%s'", this.element.getName(), var3));
            }
        }

    }

    private static Callable<Boolean> askForThe(Target element, String expectedState) {
        return () -> actor().asksFor(stateOfThe(element, expectedState));
    }

    public static Question<Boolean> stateOfThe(Target element, String expectedState) {
        return Question.about("Verifica si el elemento tiene alguno de los siguientes estados : visible, habilitado, disponible, presente").answeredBy((actor) -> {
            try {
                return IS_PRESENT.getValue().equals(expectedState) ? element.resolveFor(actor()).isPresent() || element.resolveFor(actor()).isVisible() || element.resolveFor(actor()).isEnabled() || element.resolveFor(actor()).isDisplayed() || element.resolveFor(actor()).isClickable()
                        : !element.resolveFor(actor()).isPresent() || !element.resolveFor(actor()).isVisible() || !element.resolveFor(actor()).isEnabled() || !element.resolveFor(actor()).isDisplayed() || !element.resolveFor(actor()).isClickable();
            } catch (ElementShouldBePresentException | IllegalArgumentException | NoSuchElementException var4) {
                return false;
            }
        }
        );
    }

    public Wait forAtMost(long atMostSeconds) {
        this.atMostSeconds = atMostSeconds;
        return this;
    }

    public Wait andPollInterval(long pollIntervalSeconds) {
        this.pollIntervalSeconds = pollIntervalSeconds;
        return this;
    }

    public static Wait waitTheElement(Target element) {
        return new Wait(element);
    }

    public Wait expectedState(String expectedState) {
        this.expectedState = expectedState;
        return this;
    }

    public static boolean checkElementState(Target element, String expectedState) {
        return stateOfThe(element, expectedState).answeredBy(actor());
    }
}