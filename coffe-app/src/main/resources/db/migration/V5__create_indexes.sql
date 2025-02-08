CREATE UNIQUE INDEX idx_drink_name ON drinks(name);

CREATE INDEX idx_drink_popularity ON drinks(popularity DESC);

CREATE INDEX idx_drink_created_at ON drinks(created_at ASC);