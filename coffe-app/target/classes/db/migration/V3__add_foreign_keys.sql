ALTER TABLE drinks
ADD CONSTRAINT fk_drink_recipe
FOREIGN KEY (recipe_id)
REFERENCES recipes(id) ON DELETE SET NULL;