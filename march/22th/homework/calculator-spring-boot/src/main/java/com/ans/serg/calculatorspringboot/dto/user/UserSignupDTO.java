package com.ans.serg.calculatorspringboot.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
public class UserSignupDTO {
    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    private String email;

    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 30)
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birthday must be in the past")
    private Date birthday;
}
