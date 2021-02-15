package org.basic.testing.units.services;

import org.basic.testing.units.services.impl.ExternalCompanyValidationServiceImpl;
import org.basic.testing.units.services.impl.ServicesValidationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicesValidationTests {

    @InjectMocks
    private ServicesValidationImpl servicesValidationImpl;

    @BeforeEach
    public void setup() {
        servicesValidationImpl.setExternalCompanyValidationService(externalCompanyValidationService);
    }

    @Mock
    private ExternalCompanyValidationServiceImpl externalCompanyValidationService;

    @Test
    void shouldReturnTrueIfIntegrityItsOk() {

        boolean expect = true;

        final String testCode = "ABCD_DECODE";

        final String endCodeIntegrity = "DECODE";

        when(externalCompanyValidationService.checkValidationCompany(anyString()))
                .thenReturn(true);

        boolean actual = servicesValidationImpl
                .checkCodeIntegrity(testCode, endCodeIntegrity);

        assertEquals(expect, actual);
    }

    @Test
    void shouldBeFalseIfCodeIsNotEmpty() {

        boolean expectValidationCode = false;

        final String testCode = "ABCD";

        boolean actualValidationCode = servicesValidationImpl.isCodeEmpty(testCode);

        assertEquals(expectValidationCode, actualValidationCode);

    }



}