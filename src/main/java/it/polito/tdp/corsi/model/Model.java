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
}
