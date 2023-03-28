package Runner;

import java.sql.SQLException;
import connector.DbConnection;
import studenti.studenti;

public class Gestionedb {

	public static void main(String[] args) {
	
		try {
			// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE TABELLA >>>>>>>>>>>>>>>>>>>>>>>>>>
			DbConnection db = new DbConnection();
			
			// <<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
//			studenti studente = new studenti("Bebo", "Macis", "M", "1994-03-02", 4, 8);
//			studenti studente1 = new studenti("Luca", "Forma", "M", "1990-03-02", 6, 8);
//			studenti studente2 = new studenti("Daniele", "Testi", "M", "2002-03-02", 3, 9);
//			studenti studente3 = new studenti("Kevin", "Fuccio", "M", "2000-03-02", 5, 7);
//			db.creaStudent(studente);
//			db.creaStudent(studente1);
//			db.creaStudent(studente2);
//			db.creaStudent(studente3);
//			System.out.println("studente creato correttamente");
			
			
			
			//<<<<<<<<<<<<<<<<<<<<<<<<<< LETTURA STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>	
			studenti utenteLetto = db.trovaStudente(4);
			System.out.println(utenteLetto );
			
			// <<<<<<<<<<<<<<<<<<<<<<<<<< MODIFICA STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
			utenteLetto.setGender("F");
			db.updateStudent(utenteLetto);
			
			//<<<<<<<<<<<<<<<<<<<<<<<<<< ELIMINAZIONE STUDENTE >>>>>>>>>>>>>>>>>>>>>>>>>>
//			db.eliminaUtente(utenteLetto);
			
			//<<<<<<<<<<<<<<<<<<<<<<<<<< TROVA STUDENTE CON MEDIA MAGGIORE>>>>>>>>>>>>>>>>>>>>>>>>>>
			studenti miglioreStudente = db.getBest();
			System.out.println("lo studente con la media migliore è: "+ miglioreStudente );
			
			//<<<<<<<<<<<<<<<<<<<<<<<<<< TROVA STUDENTI CON VOTI DENTRO UN CERTO RANGE>>>>>>>>>>>>>>>>>>>>>>>>>>
			db.getVoteRange(3, 8);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
