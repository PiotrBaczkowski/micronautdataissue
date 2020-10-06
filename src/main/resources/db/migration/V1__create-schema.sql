
create table category
(
    id          bigint unique generated always as identity,
    name        varchar(255)                   not null,
    visible     boolean                        not null default true,
    icon_url    varchar(255),
    create_date timestamp                               default now()
);


create table product
(
    id          bigint unique generated always as identity,
    name        varchar(255)                    not null,
    price       numeric                         not null,
    visible     boolean                         not null default true,
    description text                            not null,
    image_url   varchar(255),
    category_id bigint references category (id) not null,
    create_date timestamp                                default now()
);


create table product_option
(
    id          bigint unique generated always as identity,
    product_id  bigint references product (id) not null,
    required    boolean                        not null,
    multiple    boolean                        not null,
    name        text                           not null,
    create_date timestamp default now()
);

create table option
(
    id                bigint unique generated always as identity,
    product_option_id bigint references product_option (id) not null,
    value             text                                  not null,
    price             numeric,
    create_date       timestamp default now()
);;



