package com.goop.auth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(generator = "appUser_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "appUser_id_seq",
            sequenceName = "appUser_id_seq"
    )
    private Long id;

    private String username;

    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")}
    )
    Set<Authority> authoritySet = new HashSet<>();
}
