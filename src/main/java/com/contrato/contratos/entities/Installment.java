package com.contrato.contratos.entities;

import java.util.Date;

//tradução Installmente - Prestação
public class Installment {

	private Long id;

	// data de vencimento
	private Date dueDate;

	// montante
	private Double amount;

	public Installment() {

	}

	public Installment(Long id, Date dueDate, Double amount) {
		super();
		this.id = id;
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Installment other = (Installment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Número do Id [");
		builder.append(id);
		builder.append(", Data Vencimento=");
		builder.append(dueDate);
		builder.append(", Valor da Parcela=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}

}
