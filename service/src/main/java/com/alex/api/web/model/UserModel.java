package com.alex.api.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    Long id;
    String firstName;
    String lastName;
    String emailAddress;
    String profilePicture;
}
