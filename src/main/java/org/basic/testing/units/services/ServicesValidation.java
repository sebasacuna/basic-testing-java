package org.basic.testing.units.services;

public interface ServicesValidation {

    boolean isCodeEmpty(String code);

    boolean isOnlyDigits(String code);

    boolean checkCodeIntegrity(String code, String EndsCodeIntegrity);
}
