CREATE TABLE factextract.vocab_topic
(
    topic_id SERIAL PRIMARY KEY,
    topic VARCHAR(50) NOT NULL,
    schema VARCHAR(50) DEFAULT 'topic' NOT NULL
);
CREATE UNIQUE INDEX vocab_topic_topic_uindex ON factextract.vocab_topic (topic);

CREATE TABLE vocab_keyword
(
    keyword_id SERIAL PRIMARY KEY,
    topic_id INT NOT NULL,
    keyword VARCHAR(50) NOT NULL,
    UNIQUE (topic_id, keyword),
    CONSTRAINT vocab_keyword_vocab_topic_topic_id_fk FOREIGN KEY (topic_id) REFERENCES factextract.vocab_topic (topic_id)
);
