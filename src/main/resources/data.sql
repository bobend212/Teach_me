-- decks
insert into
  decks (deck_name) values
  ('Java 101');

insert into
  decks (deck_name) values
  ('Programming vocabulary');

-- cards
insert into cards (front, back, status, deck_id) values
  ('Can constructor return a value?', 'Yes, constructor return the instance of a class.', 'NEW', 1);

insert into cards (front, back, status, deck_id) values
  ('Czym Jest Autoboxing?', 'Autoboxing, opakowuje typ prymitywny w jego odpowiednik obiektowy (int —> Integer, boolean —> Boolean itd.)', 'NEW', 1);

insert into cards (front, back, status, deck_id) values
  ('Co to jest TDD?', 'Test-driven-development, czyli najpierw pisanie testów, a potem funkcjonalności.)', 'NEW', 1);

insert into cards (front, back, status, deck_id) values
  ('What is Spy?', 'To częściowo mock, a częściowo rzeczywisty obiekt przez co nazywane są też partial-mock. Nowy obiekt jest sklonowany na podstawie prawdziwego obiektu ale jest możliwość mockowania jego.)', 'NEW', 1);

insert into cards (front, back, status, deck_id) values
  ('git cherry-pick', 'git cherry-pick <commit_sha> - umożliwia wybranie i skopiowanie jednego lub wielu commitów z innej gałęzi na gałąź docelowa.', 'NEW', 1);