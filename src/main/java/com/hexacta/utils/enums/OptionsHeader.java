package com.hexacta.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionsHeader {

    COMPANY("Company"),
    ABOUT_US("About us");

    private final String value;

}
