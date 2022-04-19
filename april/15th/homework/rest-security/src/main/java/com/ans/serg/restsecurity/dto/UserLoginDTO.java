package com.ans.serg.restsecurity.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserLoginDTO {
    private String username;
    private String password;
}
