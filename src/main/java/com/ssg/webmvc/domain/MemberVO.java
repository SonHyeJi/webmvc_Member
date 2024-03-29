package com.ssg.webmvc.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
    private String id;
    private String username;
    private String email;
    private String password;
    private LocalDate joindate;
}
