## LetMeIn Password Manager

## How to use

1. Create a database called "letMeIn" in your localhost

2. Create table under the database "letMeIn"

```
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` tinyblob,
  `mail` tinyblob,
  `pass` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
