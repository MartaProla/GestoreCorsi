package it.polito.tdp.corsi.model;

public class testModel {

	public static void main(String[] args) {
		Model model=new Model();
		System.out.println(model.getCorsiByPeriodo(1));
		
		System.out.println(model.getIscrittiByPeriodoInteger(2));
	}

}