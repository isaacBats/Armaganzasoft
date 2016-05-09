ALTER TABLE `armaganza`.`detail_form` 
DROP FOREIGN KEY `detail_material`;
ALTER TABLE `armaganza`.`detail_form` 
CHANGE COLUMN `material_id` `material_id` INT(11) NULL ;
ALTER TABLE `armaganza`.`detail_form` 
ADD CONSTRAINT `detail_material`
  FOREIGN KEY (`material_id`)
  REFERENCES `armaganza`.`materials` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `armaganza`.`detail_form` 
DROP FOREIGN KEY `detail_material`;
ALTER TABLE `armaganza`.`detail_form` 
DROP INDEX `material_idx` ;
