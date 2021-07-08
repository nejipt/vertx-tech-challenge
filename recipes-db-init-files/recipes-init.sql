create table Users
(
    id int auto_increment,
    name varchar(255) not null,
    constraint primary key (id),
    constraint unique (id)
);

create table Recipes
(
    id                   int auto_increment,
    title                varchar(255)   not null,
    instructions         varchar(255)   not null,
    dietary_restrictions enum ('carnivore', 'ovo-lacto', 'vegetarian', 'vegan') not null,
    constraint unique (id),
    constraint primary key (id)
);

create table UserFollowedRecipes
(
    user_id int not null,
    recipe_id int not null,
    constraint primary key (user_id, recipe_id),
    constraint foreign key (user_id) references Users (id),
    constraint foreign key (recipe_id) references Recipes (id),
    constraint unique (user_id, recipe_id)
);

insert into Recipes (title, instructions, dietary_restrictions) values ('Banana bread', 'banana bread instructions', 'vegan');
insert into Recipes (title, instructions, dietary_restrictions) values ('Humus', 'humus instructions', 'vegan');
insert into Recipes (title, instructions, dietary_restrictions) values ('Meat loaf', 'meat loaf instructions', 'carnivore');
insert into Recipes (title, instructions, dietary_restrictions) values ('Mayonnaise', 'mayonnaise instructions', 'ovo-lacto');
insert into Recipes (title, instructions, dietary_restrictions) values ('Ceasar Salad', 'ceasar salad instructions', 'vegetarian');

insert Users (name) values ('NejiPt');
insert Users (name) values ('Bahamut');
insert Users (name) values ('Tiamat');
insert Users (name) values ('Baphomet');

insert into UserFollowedRecipes (user_id, recipe_id) values (1, 1);
insert into UserFollowedRecipes (user_id, recipe_id) values (1, 2);

insert into UserFollowedRecipes (user_id, recipe_id) values (2, 3);

insert into UserFollowedRecipes (user_id, recipe_id) values (3, 3);

insert into UserFollowedRecipes (user_id, recipe_id) values (4, 3);
insert into UserFollowedRecipes (user_id, recipe_id) values (4, 4);
insert into UserFollowedRecipes (user_id, recipe_id) values (4, 5);
