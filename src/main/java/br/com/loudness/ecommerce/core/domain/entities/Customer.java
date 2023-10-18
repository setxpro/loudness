package br.com.loudness.ecommerce.core.domain.entities;

import br.com.loudness.ecommerce.core.cases.CustomLocalDateTimeDeserializer;
import br.com.loudness.ecommerce.core.domain.dtos.customer.CustomerDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="customer")
@Getter
@Setter
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="customerId")
public class Customer {

    private static final long SerialVersionUID = 1L;

    @Id
    private UUID customerId;

    private String fullname;

    private String resumeName;

    private String phonenumber;

    private String whatsApp;

    private String password;

    @Email
    private String email;

    //@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dateOfBith;

    public Customer(CustomerDto customerDto) {
        this.fullname = customerDto.fullname();
        this.resumeName = customerDto.resumeName();
        this.phonenumber = customerDto.phonenumber();
        this.whatsApp = customerDto.whatsApp();
        this.password = customerDto.password();
        this.email = customerDto.email();
        this.dateOfBith = customerDto.dateOfBith();
    }
}
