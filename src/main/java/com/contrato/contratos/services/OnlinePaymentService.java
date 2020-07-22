package com.contrato.contratos.services;

public interface OnlinePaymentService {

	//taxa de pagamento
	double paymentFee(double amount);
	
	//juros
	double interest(double amount, int months);
}
