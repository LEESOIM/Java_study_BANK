package com.iu.start.bankbook;

public class BankBookDTO {

	private int booknum;
	private String bookname;
	private double bookrate;
	private boolean booksale;
	
	
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public boolean isBooksale() {
		return booksale;
	}
	public void setBooksale(boolean booksale) {
		this.booksale = booksale;
	}
}
