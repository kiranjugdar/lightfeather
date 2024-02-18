package io.lightfeather.management.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Person {
    @JsonProperty("id")
    private String id;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("jurisdiction")
    private String jurisdiction;
    @JsonProperty("identificationNumber")
    private String identificationNumber;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;


}