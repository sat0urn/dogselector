# __*DogSelector {Console}*__

Change __*DBConfig*__ class in *src/DBProperties* to add your DataBase properties such that

```
package com.example;

public class DBConfig {
   public final static String URL = "jdbc:postgresql://localhost:{your_port}/{database_exact_name}";
   public final static String NAME = "{db_name}";
   public final static String PASSWORD = "{db_password}";
}
```
