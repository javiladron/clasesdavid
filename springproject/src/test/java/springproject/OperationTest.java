package springproject;

import com.springproject.manager.IManagerOperation;
import com.springproject.manager.ManagerOperationImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class OperationTest{
	
	
	private IManagerOperation manager=new ManagerOperationImpl();
	
	@Test
	public void executeTest(){
		String primerop="5";
		String segundoop="0";
		String operacion="4";
		String res=manager.calcular(primerop, segundoop, operacion);
		if("4".equals(operacion) && "0".equals(segundoop)){
			assertNull("Tengo que devolver null porque la division tiene segundoo 0",res);
		}
		else{
			assertNotNull("Error al pasar parametros", res);
		}
		
		
	}

}
