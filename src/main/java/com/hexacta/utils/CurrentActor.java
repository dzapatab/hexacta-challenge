package com.hexacta.utils;

import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

@NoArgsConstructor
public class CurrentActor {

    public static Actor actor(){
        return OnStage.theActorInTheSpotlight();
    }
}
