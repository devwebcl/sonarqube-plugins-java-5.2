package org.ejemplo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.jdo.PersistenceManager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

class A {
  private static final String CONSTANT = "SELECT * FROM TABLE";
  public void method(String param, String param2, EntityManager entityManager) {
    try {
      JdbcOperations jdbcOperations3 = null;  // Noncompliant
      Connection conn = DriverManager.getConnection("url", "user1", "password");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = 2001");
      rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = "+param); // Noncompliant [[sc=30;ec=79]] {{Use a variable binding mechanism to construct this query instead of concatenation.}}
      String query = "SELECT Lname FROM Customers WHERE Snum = "+param;
      rs = stmt.executeQuery(query); // Noncompliant

      boolean bool = false;
      String query2 = "Select Lname ";
      if(bool) {
        query2 += "FROM Customers";
      }else {
        query2 += "FROM Providers";
      }
      query2 = query2 + " WHERE Snum =2001";
      rs = stmt.executeQuery(query2);

      //Prepared statement
      PreparedStatement ps = conn.prepareStatement("SELECT Lname FROM Customers"+" WHERE Snum = 2001");
      ps.executeQuery(query); // Noncompliant
      ps  = conn.prepareStatement("SELECT Lname FROM Customers WHERE Snum = "+param); // Noncompliant
      ps = conn.prepareStatement(query); // Noncompliant
      ps = conn.prepareStatement(query2);

      //Callable Statement
      CallableStatement cs = conn.prepareCall("SELECT Lname FROM Customers WHERE Snum = 2001");
      cs.executeQuery(query); // Noncompliant
      cs  = conn.prepareCall("SELECT Lname FROM Customers WHERE Snum = "+param2); // Noncompliant
      cs = conn.prepareCall(query); // Noncompliant
      cs = conn.prepareCall(query2);
      cs = conn.prepareCall(CONSTANT);
      cs = conn.prepareCall(foo());
      String query3 = "SELECT * from table";
      cs = conn.prepareCall(query3);

      String s;
      String tableName = "TableName";
      String column = " column ";
      String FROM = " FROM ";
      if(true) {
        s = "SELECT" +column+FROM +tableName;
      } else {
        s = "SELECT" +column+"FROM" +tableName;
      }
      cs = conn.prepareCall(s);
      String request = foo() + " FROM table";
      cs = conn.prepareCall(request);
      //new A().prepareStatement(query);
      A a = new A();
     // a.prepareStatement(query);
      ps.executeQuery();


      Session session = null;
      session.createQuery("From Customer where id > ?");
      session.createQuery("From Customer where id > "+param); // Noncompliant
      session.createQuery(query); // Noncompliant
      conn.prepareStatement(param);
      conn.prepareStatement(sqlQuery + "plop");

      String sql = "SELECT lastname, firstname FROM employee where uid = '" + param + "'";
      entityManager.createNativeQuery(sql); // Noncompliant
    } catch (Exception e) {
    }
  }

  String foo() {
    return "SELECT * ";
  }

  private String sqlQuery;



  private static void makeQuery(Connection p_con) {
    try {
      String query = null;
      StringBuffer qryBuffer = new StringBuffer();

      qryBuffer = new StringBuffer();
      qryBuffer.append(" select abc from xyz ");
      qryBuffer.append(" where bulubulu=?");
      query = qryBuffer.toString();

      p_con.prepareStatement(query); // Compliant
    } catch (Exception e) {
      System.out.println("makeQuery");
    }
  }

  PersistenceManager pm;

  void jdo(int id, String name) {
    javax.jdo.Query q = pm.newQuery(Person.class, id + " > query_id "); // Noncompliant
    q.setFilter("name == " + name); // Noncompliant
  }
}


class Person {
}

class Spring {

  private JdbcTemplate jdbcTemplate;
  private JdbcOperations jdbcOperations;  // Noncompliant
  JdbcOperations jdbcOperations2;
  private PreparedStatementCreatorFactory preparedStatementCreatorFactory;

  void test(String parameter) {
    java.lang.String sqlInjection = "select count(*) from t_actor where column =  " + parameter;
    jdbcTemplate.queryForObject(sqlInjection, Integer.class); // Noncompliant
    jdbcOperations.queryForObject(sqlInjection, Integer.class);  // Noncompliant

    new PreparedStatementCreatorFactory(sqlInjection);  // Noncompliant
    //preparedStatementCreatorFactory.  newPreparedStatementCreator(sqlInjection, new int[] {});  // Noncompliant
  }
}


class Test {
  public void foo() {
    String from = "from ResourceDBO r, ProjectDBO p where p.id = r.entityId and r.type = :entityType and r.mimeType in :mimeTypes";
    Object projectUuid = null;
    if (projectUuid != null) {
      from += " and p.uuid = :projectUuid";
    }
    String sortField = "lastUpdateTime";
    boolean asc = false;
    Object page = null;
    if (page != null) {
      String countJql = "select count(*) " + from;
      Session session = null;
      session.createQuery(countJql);

    }
  }
}

  class BlogDataSourceFactory {

    public static DataSource getBlogDataSource() {
        // TODO Auto-generated method stub
        return null;
    }

  }


  class Blog {

  }

 class MybatisTest {

     public  void testConn() throws IOException {
         String resource = "org/mybatis/example/mybatis-config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory1 =
           new SqlSessionFactoryBuilder().build(inputStream);

         // -------
         DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
         TransactionFactory transactionFactory =
           new JdbcTransactionFactory();
         Environment environment =
           new Environment("development", transactionFactory, dataSource);
         Configuration configuration = new Configuration(environment);
         //configuration.addMapper(BlogMapper.class);
         SqlSessionFactory sqlSessionFactory =
           new SqlSessionFactoryBuilder().build(configuration);

         // -----
         SqlSession session = sqlSessionFactory1.openSession();

         try {
           Blog blog = session.selectOne(
             "org.mybatis.example.BlogMapper.selectBlog", 101);
         } finally {
           session.close();
         }
     }

     @Select(value= {"SELECT * FROM blog WHERE id = #{id}"})
     Blog selectBlog(int t) {
        return null;

     }

 }




