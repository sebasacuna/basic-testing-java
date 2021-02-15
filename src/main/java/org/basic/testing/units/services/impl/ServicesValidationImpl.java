package org.basic.testing.units.services.impl;

import org.basic.testing.units.services.ExternalCompanyValidationService;
import org.basic.testing.units.services.ServicesValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

public class ServicesValidationImpl implements ServicesValidation {

    private ExternalCompanyValidationService externalCompanyValidationService;

    @Autowired
    public void setExternalCompanyValidationService(ExternalCompanyValidationService externalCompanyValidationService) {
        this.externalCompanyValidationService = externalCompanyValidationService;
    }

    @Override
    public boolean isCodeEmpty(String code) {
       return (code.equals("") || code == null) ? true : false;
    }

    @Override
    public boolean isOnlyDigits(String code) {
        IntStream intStream = code.chars();
        boolean isMatched = intStream.anyMatch(ch -> Character.isDigit(ch));

        return isMatched;
    }

    @Override
    public boolean checkCodeIntegrity(String code, String EndsCodeIntegrity) {

        if(!externalCompanyValidationService.checkValidationCompany(code)) {
            return false;
        }

        if(!code.endsWith(EndsCodeIntegrity)){
            return false;
        }

        return true;
    }

}
