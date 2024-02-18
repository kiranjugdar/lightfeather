package io.lightfeather.management.model;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetails {

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Supervisor is required")
    private String supervisor;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be a 10-digit number")
    private String phoneNumber;

    @Email(message = "Email address must be valid")
    private String email;
}