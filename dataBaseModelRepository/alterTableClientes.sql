ALTER TABLE `customers` 
CHANGE COLUMN `customer_id` `customer_id` INT(11) NULL ,
CHANGE COLUMN `created_at` `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
ADD COLUMN `identified` VARCHAR(45) NULL AFTER `id`;

ALTER TABLE `customers` 
ADD UNIQUE INDEX `identified_UNIQUE` (`identified` ASC);

DROP TABLE IF EXISTS `partitions` ;

CREATE TABLE IF NOT EXISTS `partitions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `detail_order_id` INT NOT NULL,
  `contact` VARCHAR(140) NULL,
  `mobil` VARCHAR(15) NULL,
  `address` VARCHAR(140) NULL,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `detail:order_partitions_idx` (`detail_order_id` ASC),
  CONSTRAINT `detail:order_partitions`
    FOREIGN KEY (`detail_order_id`)
    REFERENCES `armaganza`.`detail_orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;