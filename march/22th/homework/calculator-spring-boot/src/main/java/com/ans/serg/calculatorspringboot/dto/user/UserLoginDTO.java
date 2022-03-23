package com.ans.serg.calculatorspringboot.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@ToString
public class UserLoginDTO {
    @NotBlank
    @NotEmpty
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    private String email;

    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 30)
    private String password;
}
