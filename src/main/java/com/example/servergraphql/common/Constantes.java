package com.example.servergraphql.common;

public class Constantes {
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String SECURITY_JWT_KEYSTORE_NAME = "${application.security.jwt.keystoreName}";
    public static final String APPLICATION_SECURITY_JWT_CLAVE = "${application.security.jwt.clave}";
    public static final String SECURITY_JWT_SERVER_NAME = "${application.security.jwt.serverName}";

    private Constantes(){}
    public static final String CLAVEKEYSTORE = "clave";
    public static final String KEYSTORE_NAME = "keystoreName";
    public static final String SERVER_NAME = "serverName";
    public static final String COMMANDS = "commands";
    public static final String COMMANDID = "command_Id";
    public static final String COMMAND_NAME = "commandName";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String CREDENTIALS = "credentials";
    public static final String IDCREDENTIALS = "_id";
    public static final String USERNAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String ROL = "rol";
    public static final String CUSTOMERS = "customers";
    public static final String ID = "id";
    public static final String FIRSTNAME = "first_name";
    public static final String LASTNAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String DATEOFBIRTH = "date_of_birth";
    public static final String CUSTOMERS_ENTITY = "customersEntity";
    public static final String ORDERITEMS = "order_items";
    public static final String ORDERITEMID = "order_item_id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";
    public static final String ORDER_ID = "order_id";
    public static final String ORDERS = "orders";
    public static final String ORDERDATE = "orderDate";
    public static final String CUSTOMERID = "customer_id";
    public static final String ORDER = "order";
    public static final String TABLE_CUSTOMERS = "table_customers";
    public static final String TABLENUMBERID = "table_number_id";
    public static final String RESTAURANTTABLES = "restaurant_tables";
    public static final String NUMBEROFSEATS = "number_of_seats";
    public static final String TABLES = "tables";
    public static final String SELECT_RT_FROM_RESTAURANT_TABLES_ENTITY_RT_JOIN_RT_ORDERS_O_WHERE_O_ORDER_ID_ID = "SELECT rt FROM RestaurantTablesEntity rt JOIN rt.customer o WHERE o.customer_id = :id";
    public static final String CONFIG_CLAVE_KEYSTORE_XML = "config/claveKeystore.xml";
    public static final String FROM_COMMANDS_ENTITY_WHERE_CUSTOMERS_ENTITY_ID_ID = "from CommandsEntity where customersEntity.id=:id";
    public static final String SELECT_RT_FROM_RESTAURANT_TABLES_ENTITY_RT_JOIN_RT_CUSTOMER_C_WHERE_C_ID_ID = "SELECT rt FROM RestaurantTablesEntity rt JOIN rt.customer c where  c.id=:id";
    public static final String SPRING = "spring";
    public static final String COMMAND_NO_ENCONTRADA = "Command no encontrada";
    public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String ORDER_ITEM_NOT_FOUND = "OrderItem not found";
    public static final String ORDER_NO_ENCONTRADA = "Order no encontrada";
    public static final String MESA_NO_ENCONTRADA = "Mesa no encontrada";
    public static final String ID_INTRODUCIDA_NO_ES_VALIDA = "Id introducida no es valida";
    public static final String TOKEN_CADUCADO = "Token caducado";
    public static final String HAS_ROLE_ADMIN_OR_HAS_ROLE_USER = "hasRole('admin') OR hasRole('user')";
    public static final String HAS_ROLE_ADMIN = "hasRole('admin')";
    public static final String BEARER = "Bearer ";
    public static final String PKCS_12 = "PKCS12";
    public static final String ROLE = "role";
    public static final String ERROR_AL_COGER_LA_CLAVE = "error al coger la clave";
    public static final String ALGUNO_DE_LOS_ELEMENTOS_INTRODUCIDOS_NO_ES_VALIDO = "Alguno de los elementos introducidos no es valido";
}
