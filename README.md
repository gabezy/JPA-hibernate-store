# JPA Life cycle

<img src="https://i.imgur.com/tGGdt8g.png">


- Transient: never persisted, so the JPA do not manage the entity, basically a Java object.
- Managed: main state, all that happened to the entity yhe JPA will observer and can synchronize with the database, for example, change the field name, the JPA automatically will update into the database when committed or flushed. 
- Detached: the entity is already in the database, have id by is not long managed by JPA

## Strategy on @GeneratedValue 
The @GeneratedValue annotation in JPA (Java Persistence API) is used to specify the strategy for generating primary key values for entities. There are different strategies available for generating primary keys, and the strategy parameter of the @GeneratedValue annotation is used to specify which strategy should be used.

The strategy parameter can take one of the following values:

GenerationType.AUTO: This strategy lets the persistence provider choose the appropriate strategy based on the database and mapping metadata.

GenerationType.IDENTITY: This strategy generates primary key values using an identity column in the database. This is typically used with databases like MySQL, PostgreSQL, and SQL Server.

GenerationType.SEQUENCE: This strategy generates primary key values using a database sequence. This is typically used with databases like Oracle and DB2.

GenerationType.TABLE: This strategy generates primary key values using a separate table in the database. This is a portable strategy that can be used with any database.

For example, if you want to use the IDENTITY strategy to generate primary keys, you can use the @GeneratedValue(strategy = GenerationType.IDENTITY) annotation on the primary key field of your entity.
<br>
<br>
#### by default all toOne relationship is Eager, so always load and join the field, even if isn't necessary