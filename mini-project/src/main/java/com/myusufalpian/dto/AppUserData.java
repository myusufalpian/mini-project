package com.myusufalpian.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppUserData {
    private String email;
    private String nama;
    private String password;
    private String appUserRole;
}
