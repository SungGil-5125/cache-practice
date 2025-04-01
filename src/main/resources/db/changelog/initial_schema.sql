CREATE TABLE IF NOT EXISTS `posts`
(
    id         bigint primary key,
    title      varchar(100),
    content    varchar(255),
    created_at timestamp not null,
    updated_at timestamp not null
);
