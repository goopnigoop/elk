package com.goop.auth.models;

import javax.persistence.*;

@Entity
public class Authority {
    @Id
    @GeneratedValue(generator = "authority_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "authority_id_seq",
            sequenceName = "authority_id_seq"
    )
    private Long id;

    @Column(unique = true, nullable = false, name = "AUTHORITY_NAME")
    private String authorityName;
}
