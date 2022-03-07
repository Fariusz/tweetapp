package com.tweetapp.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Data
@Document(collection = "user")
public class User implements UserDetails {

    @Id
    private String id;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    @Field("is_female")
    private Boolean isFemale;
    @Field("date_of_birth")
    private LocalDate dateOfBirth;
    @Field("username")
    @Indexed(unique = true, background = true)
    private String username;
    @Field("email")
    @Indexed(unique = true, background = true)
    private String email;
    @Field("password")
    private String password;
    @Field("enabled")
    private Boolean enabled;
    @Field("is_logged_in")
    private Boolean isLoggedIn;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}