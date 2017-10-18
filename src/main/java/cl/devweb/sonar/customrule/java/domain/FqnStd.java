package cl.devweb.sonar.customrule.java.domain;

public enum FqnStd {

    JAVAX_JDO_PERSISTENCEMANAGER("javax.jdo.PersistenceManager"),
    JAVAX_JDO_QUERY("javax.jdo.Query"),

    JAVAX_PERSISTENCE_ENTITYMANAGER("javax.persistence.EntityManager"),
    JAVAX_PERSISTENCE_QUERY("javax.persistence.Query"),

    JAVAX_SQL_DATASOURCE("javax.sql.DataSource"),

    JAVA_SQL_CALLABLESTATEMENT("java.sql.CallableStatement"),
    JAVA_SQL_DRIVERMANAGER("java.sql.DriverManager"),
    JAVA_SQL_PREPAREDSTATEMENT("java.sql.PreparedStatement"),
    JAVA_SQL_STATEMENT("java.sql.Statement"),

    ORG_APACHE_IBATIS_ANNOTATIONS_SELECT("org.apache.ibatis.annotations.Select"),
    ORG_APACHE_IBATIS_IO_RESOURCES("org.apache.ibatis.io.Resources"),
    ORG_APACHE_IBATIS_MAPPING_ENVIRONMENT("org.apache.ibatis.mapping.Environment"),
    ORG_APACHE_IBATIS_SESSION_CONFIGURATION("org.apache.ibatis.session.Configuration"),
    ORG_APACHE_IBATIS_SESSION_SQLSESSION("org.apache.ibatis.session.SqlSession"),
    ORG_APACHE_IBATIS_SESSION_SQLSESSIONFACTORY("org.apache.ibatis.session.SqlSessionFactory"),
    ORG_APACHE_IBATIS_SESSION_SQLSESSIONFACTORYBUILDER("org.apache.ibatis.session.SqlSessionFactoryBuilder"),
    ORG_APACHE_IBATIS_TRANSACTION_JDBC_JDBCTRANSACTIONFACTORY("org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory"),
    ORG_APACHE_IBATIS_TRANSACTION_TRANSACTIONFACTORY("org.apache.ibatis.transaction.TransactionFactory"),

    ORG_HIBERNATE_CFG_CONFIGURATION("org.hibernate.cfg.Configuration"),
    ORG_HIBERNATE_SESSION("org.hibernate.Session"),
    ORG_HIBERNATE_SESSIONFACTORY("org.hibernate.SessionFactory"),

    SPRING_JDBC_OPERATIONS("org.springframework.jdbc.core.JdbcOperations"),
    SPRING_JDBC_PREPAREDSTATEMENTCREATORFACTORY("org.springframework.jdbc.core.PreparedStatementCreatorFactory"),
    SPRING_JDBC_TEMPLATE("org.springframework.jdbc.core.JdbcTemplate");


    private String name;

    FqnStd(String name) {
        this.name = name;
    }

    public String fqn() {
        return name;
    }

}
