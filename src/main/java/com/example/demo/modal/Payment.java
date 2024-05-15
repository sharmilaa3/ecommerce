package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	@Column(name = "name_card")
    private String name_card;
    @Column(name = "card_number")
    private Long card_number;
    @Column(name = "exp_month")
    private int exp_month;
    @Column(name = "exp_year")
    private int exp_year;
    @Column(name="cvv")
    private int cvv;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int payment_id, String name_card, Long card_number, int exp_month, int exp_year, int cvv) {
		super();
		this.payment_id = payment_id;
		this.name_card = name_card;
		this.card_number = card_number;
		this.exp_month = exp_month;
		this.exp_year = exp_year;
		this.cvv = cvv;
	}
	public String getName_card() {
		return name_card;
	}
	public void setName_card(String name_card) {
		this.name_card = name_card;
	}
	public Long getCard_number() {
		return card_number;
	}
	public void setCard_number(Long card_number) {
		this.card_number = card_number;
	}
	public int getExp_month() {
		return exp_month;
	}
	public void setExp_month(int exp_month) {
		this.exp_month = exp_month;
	}
	public int getExp_year() {
		return exp_year;
	}
	public void setExp_year(int exp_year) {
		this.exp_year = exp_year;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getPayment_id() {
		return payment_id;
	}
    
}
