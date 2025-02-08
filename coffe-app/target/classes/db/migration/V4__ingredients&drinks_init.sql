INSERT INTO ingredients (name, quantity)
VALUES ('milk', 1000), ('coffee', 1000), ('water', 1000);

INSERT INTO recipes (drink) VALUES ('espresso');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) VALUES
(1, (SELECT id FROM ingredients WHERE name = 'coffee'), 30),
(1, (SELECT id FROM ingredients WHERE name = 'water'), 30);

INSERT INTO recipes (drink) VALUES ('americano');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount)
VALUES
(2, (SELECT id FROM ingredients WHERE name = 'coffee'), 30),
(2, (SELECT id FROM ingredients WHERE name = 'water'), 210);

INSERT INTO recipes (drink) VALUES ('cappuccino');
INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount)
VALUES
(3, (SELECT id FROM ingredients WHERE name = 'coffee'), 30),
(3, (SELECT id FROM ingredients WHERE name = 'water'), 30),
(3, (SELECT id FROM ingredients WHERE name = 'milk'), 180);

INSERT INTO drinks (name, recipe_id, popularity, created_at) VALUES
('espresso', 1, 0, CURRENT_DATE),
('americano', 2, 0, CURRENT_DATE),
('cappuccino', 3, 0, CURRENT_DATE);