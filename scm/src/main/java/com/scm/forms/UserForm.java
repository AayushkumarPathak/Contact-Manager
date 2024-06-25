package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "UserName is required")
    @Size(min = 3,message = "Name must be 3 characters")
    private String name;

    @Email(message = "Please enter a valid email")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Password must be of 6 characters")
    private String password;

    @Size(min = 8, max = 10 ,message = "Phone number must be 8 characters and maximum 10")
    private String phoneNumber;

    @NotBlank(message = "About is required")
    private String about;

}
