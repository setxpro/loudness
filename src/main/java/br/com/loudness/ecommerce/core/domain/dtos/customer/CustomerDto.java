package br.com.loudness.ecommerce.core.domain.dtos.customer;

import br.com.loudness.ecommerce.core.cases.CustomLocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerDto(
        UUID customerId,
        String fullname,
        String resumeName,
        String phonenumber,
        String whatsApp,
        String password,
        String email,
        //@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
        LocalDateTime dateOfBith
) {
}
