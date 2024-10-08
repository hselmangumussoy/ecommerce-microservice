package com.hsgumussoy.auth.user.impl;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = User.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    public static final String TABLE = "user";
    private static final String COL_NAME = "name";
    private static final String COL_SURNAME = "surname";
    private static final String COL_PASSWORD = "password";
    public static final String COL_EMAIL = "email";
    private static final String COL_PHONE_NUMBER = "phone_number";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_SURNAME)
    private String surname;

    @Column(name = COL_PASSWORD)
    private String password;

    @Column(name = COL_EMAIL)
    private String email;

    @Column(name = COL_PHONE_NUMBER)
    private String phoneNumber;
}
