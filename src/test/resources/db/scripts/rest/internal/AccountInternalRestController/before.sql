INSERT INTO categories(id, name)
VALUES (101, 'categoriesName1');

INSERT INTO collections(id, name, enable, preview_id, description, collection_category_id)
VALUES  (100, 'collection100', 'true', 100, null , 101),
        (101, 'collection101', 'true', 100, null , 101),
        (102, 'collection102', 'true', 100, null , 101),
        (103, 'collection103', 'true', 100, null , 101);

INSERT INTO collection_movie(id, movie_id, collection_id)
VALUES  (1, 110, 100),
        (2, 111, 100),
        (3, 112, 101),
        (4, 110, 102),
        (5, 111, 102),
        (6, 112, 102),
        (7, 113, 103);

