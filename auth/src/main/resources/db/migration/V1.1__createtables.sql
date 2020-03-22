create table app_user
(
    id       bigint not null
        constraint app_user_pkey
            primary key,
    password varchar(255),
    username varchar(255)
);

create table authority
(
    id             bigint       not null
        constraint authority_pkey
            primary key,
    authority_name varchar(255) not null
        constraint uk_6ct98mcqw43jw46da6tbapvie
            unique
);


create table user_authorities
(
    user_id      bigint not null
        constraint fk9eroh5pg8uo79m5i211drb471
            references app_user,
    authority_id bigint not null
        constraint fk2n9bab2v62l3y2jgu3qup4etw
            references authority,
    constraint user_authorities_pkey
        primary key (user_id, authority_id)
);


