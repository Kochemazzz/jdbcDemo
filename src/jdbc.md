1. Подключение библиотеки с классом-драйвером - driver.jar
2. Установка соединения с БД - Connection
3. Запрос в БД - Statement, ResultSet.TYPE_FORWARD_ONLY
4. Выполнение запроса в БД - ResultSet executeQuery(String sql) - SELECT, 
int executeUpdate(String sql) - INSERT, UPDATE, DELETE, boolean execute(String sql)
5. Обработка результата
6. Закрытие Connection



CRUD - CREATE, INSERT, UPDATE, DELETE



----------типы чтения транзакция
грязное чтение
неповторяющееся чтения
фантомное чтение

ACID
-----------

Savepoint
------------------

DAO=ORM
