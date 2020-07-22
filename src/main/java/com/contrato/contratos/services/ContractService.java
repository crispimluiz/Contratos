package com.contrato.contratos.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.contrato.contratos.entities.Contract;
import com.contrato.contratos.entities.Installment;

public class ContractService {

	@Autowired
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract (Contract contract, int months) {
		double valorMesSemJuros = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i ++) {
			//valor com juros
			double valorPorMesComJuros = valorMesSemJuros + onlinePaymentService.interest(valorMesSemJuros, i);
			//Valor da taxa
			double valorJurosTaxa = valorPorMesComJuros + onlinePaymentService.paymentFee(valorPorMesComJuros);
			//Para fazer a função data foi precisa a função addMoths abaixo
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(null, dueDate, valorJurosTaxa));
		}
	}
	
	//função auxiliar para lidar com data
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
}
