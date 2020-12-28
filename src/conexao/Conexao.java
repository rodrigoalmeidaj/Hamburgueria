// package conexao;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class Conexao {

// private Connection con = null;

// private String hostName = null;
// private String root = null;
// private String password = "";
// private String url = null;
// private String jdbcDriver = null;
// private String dataBaseName = null;
// private String dataBasePrefix = null;
// private String dabaBasePort = null;

// super();

// /**
// * Os dados setados abaixo servem para uma conexão em MySQL. Altere de acordo
// * com seu BD. Aconselhamos carregar estes dados de um arquivo.
// */

// "jdbc:mysql:/localhost:3306/meu_bd";hostName="localhost";userName="portaljava";password="
// java
// rulez!";jdbcDriver="org.gjt.mm.mysql.Driver";dataBaseName="meu_bd";dataBasePrefix="jdbc:mysql:/";dabaBasePort="3306";

// url=dataBasePrefix+hostName+":"+dabaBasePort+"/"+dataBaseName+"/";

// /**
// * Exemplo de um URL completo para MySQL: a concatenação acima deve ficar algo
// * como: jdbc:'mysql:/localhost:3306/meu_bd'
// */

// }

// /**
// *Retorna uma java.sql.Connection.
// *@return con
// */

// public Conexao getConnection() {
// try {
// if (con == null) {
// Class.forName(jdbcDriver);
// con = DriverManager.getConnection(url, userName, password);
// } else if (con.isClosed()) {
// con = null;
// return getConnection();
// }
// } catch (ClassNotFoundException e) {

// //TODO: use um sistema de log apropriado.

// e.printStackTrace();
// } catch (SQLException e) {

// //TODO: use um sistema de log apropriado.

// e.printStackTrace();
// }
// return con;
// }