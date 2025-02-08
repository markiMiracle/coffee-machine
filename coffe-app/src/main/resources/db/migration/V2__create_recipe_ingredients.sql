CREATE TABLE recipe_ingredients (
    recipe_id BIGINT NOT NULL,
    ingredient_id BIGINT NOT NULL,
    amount INT NOT NULL,
    PRIMARY KEY (recipe_id, ingredient_id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE,
    FOREIGN KEY (ingredient_id) REFERENCES ingredients(id) ON DELETE CASCADE
);