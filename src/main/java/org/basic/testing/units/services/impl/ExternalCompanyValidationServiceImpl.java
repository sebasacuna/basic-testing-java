package org.basic.testing.units.services.impl;

import org.basic.testing.units.services.ExternalCompanyValidationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExternalCompanyValidationServiceImpl implements ExternalCompanyValidationService {

    public boolean checkValidationCompany(String code){
        // private methods
        // logics stuffs
        return true;
    }

    public LocalDateTime getMyDatePlusFiveMinute(LocalDateTime localDateTime){
        return localDateTime.plusMinutes(5);
    }

}
