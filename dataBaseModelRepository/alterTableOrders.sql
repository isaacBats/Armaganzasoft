ALTER TABLE `orders` 
ADD COLUMN `num_orden` VARCHAR(45) NULL AFTER `total_price`,
ADD COLUMN `num_remision` VARCHAR(45) NULL AFTER `num_orden`;

ALTER TABLE `orders` 
CHANGE COLUMN `num_remision` `remission_id` INT(11) NULL DEFAULT NULL ;


ALTER TABLE `arma`.`orders` 
ADD INDEX `remission_idx` (`remission_id` ASC);
ALTER TABLE `arma`.`orders` 
ADD CONSTRAINT `remission`
  FOREIGN KEY (`remission_id`)
  REFERENCES `arma`.`remission` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;