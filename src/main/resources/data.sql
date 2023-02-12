-- decks
insert into
  decks (deck_name) values
  ('Java 101');

insert into
  decks (deck_name) values
  ('Programming vocabulary');

-- cards
insert into cards (front, back, deck_id) values
  ('Can constructor return a value?', 'Yes, constructor return the instance of a class.', 1);

insert into cards (front, back, deck_id) values
  ('Czym Jest Autoboxing?', 'Autoboxing, opakowuje typ prymitywny w jego odpowiednik obiektowy (int —> Integer, boolean —> Boolean itd.)', 1);
