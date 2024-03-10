package com.hexacta.questions.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class GetElement implements Question<String> {
    private Target target;

    public GetElement(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).answeredBy(actor);
    }

    public static GetElement OfFront(Target target) {
        return new GetElement(target);
    }
}