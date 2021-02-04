DROP TABLE IF EXISTS `cat_food`;

DROP TABLE IF EXISTS `cat_food_type`;

CREATE TABLE `cat_food_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cat_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `rating` int(5) DEFAULT 0,
  `image` varchar(200) DEFAULT '',
  `net_mass` decimal(8, 2) DEFAULT 0,
  `protein` decimal(3, 2) DEFAULT 0,
  `carbohydrates` decimal(3, 2) DEFAULT 0,
  `fat` decimal(3, 2) DEFAULT 0,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`type_id`) REFERENCES `cat_food_type` (`id`)
);

INSERT INTO cat_food_type VALUES
    (1, 'Wet'),
    (2, 'Dry');

INSERT INTO `cat_food`(`id`, `name`, `type_id`, `price`, `rating`, `image`, `net_mass`) VALUES
	(1,'Feringa','2', 28.00, 5, 'https://shop-cdn-m.shpp.ext.zooplus.io/bilder/mieszany/pakiet/prbny/feringa/adult/karma/sucha/2/400/64588_pla_feringa_trofu_truthahn_400g_2.jpg', 750),
	(2,'Macs','1', 25.20, 4, 'https://shop-cdn-m.shpp.ext.zooplus.io/bilder/macs/cat/karma/dla/kota/x/g/8/400/69644_pla_macs_ente_pute_huhn_800g_8.jpg', 400),
    (3,'Catz Finefood','1', 28.75, 5, 'https://shop-cdn-m.shpp.ext.zooplus.io/bilder/pakiet/prbny/catz/finefood/x/g/6/400/349318_catzfine_geflueggarn_6.jpg', 400),
    (4,'Applaws','2', 23.25, 3, 'https://shop-cdn-m.mediazs.com/bilder/applaws/adult/z/kurczakiem/9/400/135371_applawsadulthuhn_9.jpg', 1000),
    (5,'Smilla Adult Sensitive','2', 24.75, 2, 'https://shop-cdn-m.mediazs.com/bilder/smilla/adult/sensitive/bez/zb/2/400/110020_pla_smilla_sensitiveadult_poultry_1kg_2.jpg', 1000),
    (6,'Royal Canin Sterilised 7+','2', 32.50, 2, 'https://shop-cdn-m.mediazs.com/bilder/royal/canin/sterilised/0/400/rc_fhn_sterilised7_mv_eretailkit_pl_pl_0.jpg', 1000),
    (7,'Animonda Carny Adult','1', 18.00, 2, 'https://shop-cdn-m.mediazs.com/bilder/animonda/carny/adult/x/g/6/400/51013_pla_animonda_carny_adult_multifleisch_cocktail_400g_hs_01_6.jpg', 400),
    (8,'Miamor Feine Filets','1', 19.00, 2, 'https://shop-cdn-m.mediazs.com/bilder/miamor/feine/filets/w/puszkach/x/g/9/400/62025_pla_finnern_miamor_feinefilets_jelly_thunreis_185g_hs_01_9.jpg', 185),
    (9,'Cosma Original','1', 24.75, 4, 'https://shop-cdn-m.mediazs.com/bilder/cosma/original/w/galarecie/x/g/0/400/1_36637_pla_cosma_original_chicken_400g_0.jpg', 400),
    (10,'Josera Nature Cat','2', 28.15, 3, 'https://shop-cdn-m.mediazs.com/bilder/josera/nature/cat/3/400/97618_pla_foodforplanet_josera_naturecat_10kg_3.jpg', 1000);