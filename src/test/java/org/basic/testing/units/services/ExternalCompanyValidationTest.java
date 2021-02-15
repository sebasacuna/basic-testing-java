package org.basic.testing.units.services;

import org.basic.testing.units.services.impl.ExternalCompanyValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExternalCompanyValidationTest {

    @InjectMocks
    private ExternalCompanyValidationServiceImpl externalCompanyValidationService;

    @BeforeEach
    public void setup() {

    }

    @Test
    void shouldReturnDatePlusFiveMinutes() {

        boolean expect = true;

        final LocalDateTime localDateTimeToTest =
                LocalDateTime.of(2020, Month.JANUARY, 10, 12, 5);

        final LocalDateTime expectLocalDateTime =
                LocalDateTime.of(2020, Month.JANUARY, 10, 12, 10);

        boolean equalsDate = expectLocalDateTime.isEqual(externalCompanyValidationService
                .getMyDatePlusFiveMinute(localDateTimeToTest));

        assertEquals(expect, equalsDate);
    }

}
