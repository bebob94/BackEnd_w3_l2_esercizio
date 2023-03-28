package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import studenti.studenti;



public class DbConnection {

	private String url = "jdbc:postgresql://localhost:5432/";
	private String dbName = "backEnd_w3_l2_esercizio";
	private String userName = "postgres";
	private String password = "bebobebo6";
	Statement st;
	
	public DbConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		st = conn.createStatement();
		creaTabStudent();
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE TABELLA >>>>>>>>>>>>>>>>>>>>>>>>>>
		public void creaTabStudent() throws SQLException {
			String sql = "CREATE TABLE IF NOT EXISTS Users (" + "id_user SERIAL PRIMARY KEY," + "name VARCHAR NOT NULL,"
					+ "lastName VARCHAR NOT NULL," + "gender VARCHAR NOT NULL," + "birthdate DATE NOT NULL,avg INT2 , min_vote INT2 NOT NULL, max_vote INT2 NOT NULL)";
			this.st.executeUpdate(sql);
		}
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
		public void creaStudent(studenti s) throws SQLException {
			String sql = "INSERT INTO Users (name, lastName, gender, birthdate, avg, min_vote, max_vote) " + "VALUES ('" + s.getName() + "', '"
                    + s.getLastname() + "', '" + s.getGender() + "', '" + s.getBirthdate() + "', " + s.getAvg() + ", '" + s.getMin_vote() + "', '" + s.getMax_vote() + "')";
			this.st.executeUpdate(sql);
		}
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< MODIFICA STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
		public void updateStudent(studenti s) throws SQLException {
	        String sql = "UPDATE Users " + "SET name='" + s.getName() + "', lastname='" + s.getLastname() + "', gender='"
	                + s.getGender() + "' " + "WHERE id_user = " + s.getId();
	        this.st.executeUpdate(sql);
	        System.out.println("Utente aggiornato!!");
	    }
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<< LETTURA STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
		public studenti trovaStudente(Integer id) throws SQLException {
			studenti utente = null;
			String sql = "SELECT * FROM users WHERE id_user =" + id;
			ResultSet rs = this.st.executeQuery(sql);
			if (rs.next()) {
				Long id_user = rs.getLong("id_user");
				String name = rs.getString("name");
				String lastName = rs.getString("lastName");
				String gender = rs.getString("gender");
				String birthdate = rs.getString("birthdate");
				Integer avg =  rs.getInt("avg");
				Integer min_vote=  rs.getInt("min_vote");
				Integer max_vote=  rs.getInt("max_vote");
				utente = new studenti(id_user, name, lastName, gender, birthdate, avg, min_vote,max_vote);
			}
			System.out.println("utente letto correttamente");
			return utente;
		}
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<< ELIMINAZIONE STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
		public void eliminaUtente(studenti s) throws SQLException {
			String sql = "DELETE FROM Users WHERE id_user =" + s.getId();
			 this.st.executeUpdate(sql);
			 System.out.println("Utente eliminato!!!");
		}
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<< TROVA STUDENTE CON MEDIA MAGGIORE>>>>>>>>>>>>>>>>>>>>>>>>>>
		public studenti getBest() throws SQLException {
		    studenti utente = null;
		    String sql = "SELECT * FROM Users ORDER BY avg DESC LIMIT 1";
		    ResultSet rs = this.st.executeQuery(sql);
		    if (rs.next()) {
		        Long id_user = rs.getLong("id_user");
		        String name = rs.getString("name");
		        String lastName = rs.getString("lastName");
		        String gender = rs.getString("gender");
		        String birthdate = rs.getString("birthdate");
		        Integer avg =  rs.getInt("avg");
		        Integer min_vote=  rs.getInt("min_vote");
		        Integer max_vote=  rs.getInt("max_vote");
		        utente = new studenti(id_user, name, lastName, gender, birthdate, avg, min_vote,max_vote);
		    }
		    System.out.println("studente con la media più alta trovato");
		    return utente;
		}
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<< TROVA STUDENTI CON VOTI DENTRO UN CERTO RANGE>>>>>>>>>>>>>>>>>>>>>>>>>>
		public void getVoteRange(int min, int max) throws SQLException {
	        List<studenti> studenti = new ArrayList<>();
	        String sql = "SELECT * FROM Users WHERE min_vote > " + (min - 1) + " AND max_vote < " + (max + 1)
	                + " ORDER BY avg DESC";
	        ResultSet rs = st.executeQuery(sql);
	        while (rs.next()) {
	            Long id_user = rs.getLong("id_user");
	            String name = rs.getString("name");
	            String lastname = rs.getString("lastname");
	            String gender = rs.getString("gender");
	            String birthdate = rs.getString("birthdate");
	            Integer min_vote = rs.getInt("min_vote");
	            Integer max_vote = rs.getInt("max_vote");
	            Integer avg = rs.getInt("avg");
	            studenti stud = new studenti(id_user, name, lastname, gender, birthdate, max_vote, min_vote, avg);
	            studenti.add(stud);
	        }
	        System.out.println("Elenco studenti con voti compresi tra " + min + " e " + max);
	        studenti.forEach(stud -> System.out.println(stud.toString()));
	    }
}
