package ro.ase.csie.cts.test;

import ro.ase.csie.cts.AccountException;
import ro.ase.csie.cts.FloatingValueException;
import ro.ase.csie.cts.NegativeCreditException;
import ro.ase.csie.cts.WrongNumeCharactersEx;
import ro.ase.csie.cts.ZeroCreditException;
import ro.ase.csie.cts.WrongNumeCharactersEx;
import ro.ase.csie.cts.WrongPrenumeCharactersEx;
import ro.ase.csie.cts.WrongNumberException;
import ro.ase.csie.cts.PhoneCreditAcc;
import junit.framework.TestCase;

public class TestPhoneCreditAcc extends TestCase {

	PhoneCreditAcc account;
	
	public void setUp(){
		System.out.println("setUp Unit test");
		account = new PhoneCreditAcc("0749248044","Mugea","Iuliana",40);
	}
	
	//unit test pentru verificat metoda Incarcare()
		//testare valori normale (intregi, pozitive)
		public void testNormalValuesIncarcare() throws NegativeCreditException, ZeroCreditException, FloatingValueException
		{	
			double expected = 40;
			account.Incarcare(35.0);
			assertEquals("Test Incarcare() cu valori normale",
					40.0,
					account.getCredit(),
					0.0);
		}
		

		//testare valori negative (< 0)
		public void testNegativeValuesIncarcare(){
			try{
			account.Incarcare(-50.0);
			assertFalse("Metoda nu arunca exceptie pe valori negative", true);
			}
			catch(AccountException ex){
				assertTrue(true);	}
		}
		
			

		//testare valori nule (= 0)
		public void testZeroValueIncarcare(){
			try{
			account.Incarcare(0.0);
			assertFalse("Metoda Incarcare() nu arunca exceptie pe 0", true);
			}
			catch(AccountException ex){
				assertTrue(true);	}
		}
		
		
		//testare valori pozitive cu maxim 2 zecimale
		public void testFloatingValueIncarcare(){
			try{
			account.Incarcare(0.0006);
			assertFalse("Metoda Incarcare() nu arunca exceptie pe 0", true);
			}
			catch(AccountException ex){
				assertTrue(true);
			}
		}
	
	
	
    //unit test pentru verificat metoda Validare()
		//testare nume caractere diferite (@, #, etc)
		//	public void testNormalNumeValidare() throws WrongNumeCharactersEx
		//	{	
		//		double expected = 40;
		//		account.Validare("0749248044","@Mugea","Iuliana");
		//		assertEquals("Test Incarcare() cu valori normale",
		//				40.0,
		//				account.Validare("0749248044","Mugea","Iuliana"),
		//				0.0);
		//	}
	
	
		public void testNormalValidareNumar() throws WrongNumberException{
		try{
			account.ValidareNumar("074924804498");
			assertFalse("Metoda ValidareNumar() nu arunca exceptie", true);
			}
			catch(AccountException ex){
				assertTrue(true);	}
		}
		
}
