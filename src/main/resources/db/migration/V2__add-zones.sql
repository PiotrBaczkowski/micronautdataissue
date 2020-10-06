insert into category(name, visible, icon_url, create_date)
 values
 (
'Category #1', false, 'https://google.com', now()
),
(
'Category #2', false, 'https://google.com', now()
);


insert into product(name, price, description, image_url, category_id) values ('Product#1', 10, 'description', 'https://google.pl', 1);
