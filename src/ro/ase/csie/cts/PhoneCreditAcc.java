package ro.ase.csie.cts;

public class PhoneCreditAcc {
	String nrTel;
	String nume;
	String prenume;
	double credit;
	
	
	public PhoneCreditAcc(String nr, String n, String p, int cred)
	{	
		nrTel=nr;
		nume=n;
		prenume=p;
		credit=cred;
	}
	
	
	public void Incarcare(double amount) throws NegativeCreditException, ZeroCreditException, FloatingValueException
	{	
		if(amount < 0.0)
			throw new NegativeCreditException();
		
		if(amount == 0.0)
			throw new ZeroCreditException();
		
		
		int valoareInt = (int)(amount*100.0);
		if(amount-((double)valoareInt/100.0)>0)
			throw new FloatingValueException();
		
		
		credit=credit+amount;
	}
	
	
	public String ValidareNumar(String nrTel) throws WrongNumberException
	{
		if(nrTel.length() > 10 || nrTel.length() < 10)
			throw new WrongNumberException();
				
		
		return nrTel;
	} 
	
	public String ValidareNume(String nume) throws WrongNumeCharactersEx
	{
		if(nrTel.length() > 10 || nrTel.length() < 10)
			throw new WrongNumeCharactersEx();
				
		
		return nume;
	} 
	
	public String ValidarePrenume(String prenume) throws WrongPrenumeCharactersEx
	{
		if(nrTel.length() > 10 || nrTel.length() < 10)
			throw new WrongPrenumeCharactersEx();
				
		
		return prenume;
	} 
	
	
	
	public double getCredit()
	{
		return credit;
	}
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) {
	

	} */

}
