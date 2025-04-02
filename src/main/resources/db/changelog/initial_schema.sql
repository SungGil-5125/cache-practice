CREATE TABLE IF NOT EXISTS `posts`
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(100),
    content    VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
