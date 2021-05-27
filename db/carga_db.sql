LOCK TABLES `usuarios` WRITE;
INSERT INTO `usuarios` VALUES (1,'Nuñez Caballero','38926305','manuelnc53@gmail.com','ACTIVO','Manuel','M','2664000614'),(2,'Perez','38926305','manuelnc53@gmail.com','ACTIVO','Juan','M','2664000614');
UNLOCK TABLES;

LOCK TABLES `billeteras` WRITE;
INSERT INTO `billeteras` VALUES (1,'ACTIVO',1),(2,'ACTIVO',2);
UNLOCK TABLES;

LOCK TABLES `divisas` WRITE;
INSERT INTO `divisas` VALUES (1,'ACTIVO','BTC',100),(2,'ACTIVO','ETH',20);
UNLOCK TABLES;

LOCK TABLES `billeteradivisa` WRITE;
INSERT INTO `billeteradivisa` VALUES (1,1,1),(2,1,1),(3,1,1),(4,1,1),(5,1,1),(6,1,1),(7,1,1),(8,1,1),(9,1,1),(10,1,1),(11,1,2),(12,1,2),(13,1,2),(14,1,2),(15,1,2),(16,1,2),(17,1,2),(18,1,2),(19,1,2),(20,1,2),(21,2,2),(22,2,2),(23,2,2),(24,2,2),(25,2,2),(26,2,2),(27,2,2),(28,2,2),(29,2,2),(30,2,2),(31,2,1),(32,2,1),(33,2,1),(34,2,1),(35,2,1),(36,2,1),(37,2,1),(38,2,1),(39,2,1),(40,2,1);
UNLOCK TABLES;