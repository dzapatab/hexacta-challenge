package com.hexacta.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Home {

    public static final Target CLOSE_IMAGE = Target.the("home CLOSE IMAGE")
            .locatedBy("//span[@aria-label='close']");
    public static final Target HEADER_OPTIONS = Target.the("home HEADER OPTIONS")
            .locatedBy("//a[contains(text(), '{0}')]");
    public static final Target SELECT_OPTIONS_IN_THE_HEADER = Target.the("home SELECT OPTIONS IN THE HEADER")
            .locatedBy("//ul[@class='sub-menu']/descendant::a[contains(text(), 'About us')]");
    public static final Target SEARCH_ICON = Target.the("home SELECT SEARCH ICON")
            .locatedBy("//a[@class='searchbox']");

    public static final Target INPUT_SEARCH = Target.the("home SELECT ENTER VALUE IN INPUT")
            .locatedBy("//input[@type='search']");


    public static final Target ELEMENT = Target.the("home ELEMENT TO AFTER SEARCH")
            .locatedBy("//a[contains(text(), '{0}')]");

}
