package com.hexacta.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target CLOSE_IMAGE = Target.the("home CLOSE IMAGE")
            .locatedBy("//span[@aria-label='close']");
    public static final Target HEADER_OPTIONS = Target.the("home HEADER OPTIONS")
            .locatedBy("//a[contains(text(), '{0}')]");
    public static final Target SELECT_OPTIONS_IN_THE_HEADER = Target.the("home SELECT OPTIONS IN THE HEADER")
            .locatedBy("//ul[@class='sub-menu']/descendant::a[contains(text(), 'About us')]");
}
