

import java.time.LocalDateTime;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	private static int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Data(int dia, int mes, int ano) {
		assert dia > 0 && dia < diasDoMes(mes, ano) : "Dia inválido";
		assert mes > 0 && mes <= 12 : "Mês inválido";
		assert ano >  0 : "Ano inválido";
		
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Data(String data) {
		int dia = Integer.valueOf(data.split("/")[0]);
		int mes = Integer.valueOf(data.split("/")[1]);
		int ano = Integer.valueOf(data.split("/")[2]);
		
		assert dia > 0 && dia < diasDoMes(mes, ano) : "Dia inválido";
		assert mes > 0 && mes <= 12 : "Mês inválido";
		assert ano >  0 : "Ano inválido";
		
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia() { return this.dia; }
	public int getMes() { return this.mes; }
	public int getAno() { return this.ano; }
	
	public static boolean bissexto(int ano) {
		return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
	}
	
	public static boolean mesValido(int mes) {
		return 1 <= mes && mes <= 12;
	}
	
	public static int diasDoMes(int mes, int ano) {
		assert mesValido(mes) : "Mês inválido";
		
		int result = diasMesComum[mes-1];
	    if (mes == 2 && bissexto(ano)) result++;
	    
	    return result;
	}
	
	public static Data hoje() {
		LocalDateTime localDate = LocalDateTime.now();
		return new Data(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
	}
	
	@Override
	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
	
}