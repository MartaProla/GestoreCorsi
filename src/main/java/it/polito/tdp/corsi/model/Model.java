package it.polito.tdp.corsi.model;


import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.corsoDAO;

public class Model {
	private corsoDAO dao;
	public Model() {
		dao=new corsoDAO();
	}
	
	public List<Corso>getCorsiByPeriodo(Integer pd){
		return dao.getCorsiByPeriodo(pd);
		
	}
	public Map<Corso,Integer> getIscrittiByPeriodoInteger(Integer pd){
		return dao.getIscrittiByPeriodo(pd);
	}
	
	public Map<String, Integer> getDivisioneCDS(Corso c){
		//SOLUZIONE 1
		/*List<Studente> studenti = dao.getStudentiByCorso(c);
		
		Map<String, Integer> statistiche = new HashMap<String, Integer>();
		
		for(Studente s : studenti) {
			
			if(s.getCds() != null && !s.getCds().equals("")) {
				if(statistiche.containsKey(s.getCds())) {
					statistiche.put(s.getCds(),statistiche.get(s.getCds()) +1);
				} else {
					statistiche.put(s.getCds(), 1);
				}		
			}
		}
		
		return statistiche;*/
		return dao.getDivisioneCDS(c);
	}

	public List<Studente> getStudentiByCorso(Corso corso) {
		return dao.getStudentiByCorso(corso);
	}

	public boolean esisteCorso(String codins) {
			return dao.esisteCorso(codins);
	}
}
