package com.ans.serg.restsecurity.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserSignupDTO {
    private String email;
    private String username;
    private String password;
}
