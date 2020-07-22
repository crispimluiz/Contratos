package com.contrato.contratos.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.contrato.contratos.entities.Contract;
import com.contrato.contratos.entities.Installment;
import com.contrato.contratos.services.ContractService;
import com.contrato.contratos.services.PaypalService;


public class program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o número do contrato");
		System.out.println("Número: ");
		Integer number = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.println();
		System.out.println("Valor Contrato: ");
		Double totalValue = sc.nextDouble();
		//Aq estanciamos o contrato principal
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.println("Coloque a quantidade de parcelas do contrato: ");
		int N = sc.nextInt();
		//Agora o serviço
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, N);
		
		//Mostrar o resultado
		System.out.println("Parcelas: ");
		for(Installment qt : contract.getInstallments()) {
			System.out.println(qt);
		}
		

	}

}
