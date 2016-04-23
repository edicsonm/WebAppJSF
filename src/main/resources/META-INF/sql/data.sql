INSERT INTO `WildflySecurity`.`Users` (`username`, `passwod`) VALUES ('edicson', '56yqqD0Rrw0waFEsbNWlOKl1EB00A6y61ZQ+ZOBAUoE=');
INSERT INTO `WildflySecurity`.`UserRoles` (`username`, `role`) VALUES ('edicson', 'ADMIN');

INSERT INTO `WildflySecurity`.`ADMIN_USER` (`SSO`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PASSWORD`) VALUES ('edicson', 'edicsonm@gmail.com', 'Edicson', 'Morales', '56yqqD0Rrw0waFEsbNWlOKl1EB00A6y61ZQ+ZOBAUoE=');
INSERT INTO `WildflySecurity`.`ADMIN_USER` (`SSO`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PASSWORD`) VALUES ('hamilton', 'hamoto@gmail.com', 'Hamilton', 'Morales', '56yqqD0Rrw0waFEsbNWlOKl1EB00A6y61ZQ+ZOBAUoE=');

INSERT INTO `WildflySecurity`.`ADMIN_ROLE` (`NAME`, `DESCRIPTION`) VALUES ('ADMIN', 'Administration Role');
INSERT INTO `WildflySecurity`.`ADMIN_ROLE` (`NAME`, `DESCRIPTION`) VALUES ('DBA', 'Data Base Administrator Role');

INSERT INTO `WildflySecurity`.`ADMIN_USER_ROLE` (`ROLE`, `SSO`) VALUES ('ADMIN', 'edicson');
INSERT INTO `WildflySecurity`.`ADMIN_USER_ROLE` (`ROLE`, `SSO`) VALUES ('DBA', 'edicson');
INSERT INTO `WildflySecurity`.`ADMIN_USER_ROLE` (`ROLE`, `SSO`) VALUES ('DBA', 'hamilton');

-- INSERT INTO `WildflySecurity`.`parent` (`IDENT`, `NOMBRE`) VALUES ('1', 'Isauro');
-- INSERT INTO `WildflySecurity`.`parent` (`IDENT`, `NOMBRE`) VALUES ('2', 'Nelcy');
-- INSERT INTO `WildflySecurity`.`parent` (`IDENT`, `NOMBRE`) VALUES ('3', 'Hamilton');

-- INSERT INTO `WildflySecurity`.`child` (`IDENTCHILD`, `NOMBRE`, `IDPARENT`) VALUES ('1', 'Edicson', '1');
-- INSERT INTO `WildflySecurity`.`child` (`IDENTCHILD`, `NOMBRE`, `IDPARENT`) VALUES ('2', 'Nidia', '1');
-- INSERT INTO `WildflySecurity`.`child` (`IDENTCHILD`, `NOMBRE`, `IDPARENT`) VALUES ('3', 'Emerson', '2');
-- INSERT INTO `WildflySecurity`.`child` (`IDENTCHILD`, `NOMBRE`, `IDPARENT`) VALUES ('4', 'Hamilton', '2');

-- INSERT INTO `WildflySecurity`.`Test` (`idTest`, `description`, `sSOParent`) VALUES ('1', 'Descripcion', 'edicson');
-- INSERT INTO `WildflySecurity`.`Test` (`idTest`, `description`, `sSOParent`) VALUES ('2', 'Descripcion', 'edicson');
