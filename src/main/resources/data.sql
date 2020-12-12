use kotlin_test_app;

INSERT INTO users (id, login, firstname, lastname, description)
VALUES ('1', 'kimhuor', 'kimhuor', 'lim', 'test');

INSERT INTO articles (id, title, headline, content, slug, author_id)
VALUES ('1', 'Whey', 'Powder', 'Muscle', 'whey', '1');
