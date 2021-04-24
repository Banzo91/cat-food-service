CREATE USER 'catfoodapp'@'%' IDENTIFIED BY 'catfoodapp';

GRANT ALL PRIVILEGES ON cat_food_tracker.* TO 'catfoodapp'@'%';