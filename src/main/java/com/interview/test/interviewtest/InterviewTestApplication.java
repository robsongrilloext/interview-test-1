package com.interview.test.interviewtest;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.utility.ListIterate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewTestApplication {

	public static void main(String[] args) {
		InterviewTestApplication interviewTestApplication = new InterviewTestApplication();
		interviewTestApplication.doIt();
		SpringApplication.run(InterviewTestApplication.class, args);
	}
	
	public void doIt() {
        ArrayList<Corrida> corridas = new ArrayList<>(); 
        ArrayList<Corrida> corridasSorted = new ArrayList<>();
		
        ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("corrida_kart.log").getFile());
	    try {
	        Scanner scanner = new Scanner(file);
	        //LE ARQUIVO DE LOG
	        while (scanner.hasNextLine()) {
	        		String line = scanner.nextLine();
	        		if(!line.substring(15, 18).trim().isEmpty()) {
	        			corridas.add(new Corrida(
	        								new Integer(line.substring(15, 18).toString()), 
	        								line.substring(0, 8).trim(), 
	        								line.substring(21, 40).trim(), 
	        								new Integer(line.substring(40, 41).trim().toString()), 
	        								line.substring(48, 52).trim(), 
	        								line.substring(69, 74).trim())
	        						);
	        		}
	        }
	        scanner.close();
	        //RECUPERA HORARIO INICIAL DA CORRIDA
	        Integer inicioCorrida = new Integer(corridas.get(0).getHora().replaceAll(":", "")) - new Integer(corridas.get(0).getTempoVolta().replaceAll(":", ""));
	        //ORDENA LISTA DE CORRIDA POR POSICAO DE CHEGADA
	        Collections.sort(corridas, Collections.reverseOrder());
	        
	        //REMOVE DUPLICIDADE DE PILOTOS 
	        List<Corrida> corridasListFiltered = ListIterate.distinct(corridas, HashingStrategies.fromFunction(Corrida::getCodPiloto));
	        int index = 1;
	        // EXIBE RESULTADO DA CORRIDA
	        for (Corrida corrida : corridasListFiltered) {
	        	Integer finalCorrida = new Integer(corrida.getHora().replaceAll(":", ""));
	        	Integer totalProva = (finalCorrida - inicioCorrida);
	        	String totalProvaFormatado = totalProva.toString().substring(0,1)+ ":" + totalProva.toString().substring(1,3);
				corridasSorted.add(corrida);
				System.out.println(" Posição Chegada: "+index+", Código Piloto: "+corrida.codPiloto+", Nome Piloto: "+ corrida.piloto+ ", Qtde Voltas Completadas: "+ corrida.volta+ ",  Tempo Total de Prova: "+ totalProvaFormatado);
				index++;
	        }
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
  
	}

}
