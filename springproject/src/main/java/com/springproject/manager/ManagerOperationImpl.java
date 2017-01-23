package com.springproject.manager;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ManagerOperationImpl implements IManagerOperation{
	
	@Override
	public String calcular(String po, String so, String op) {
		if(StringUtils.isNotBlank(po) && StringUtils.isNotBlank(so) && !"-1".equals(op)){
			boolean isDataInteger=true;
			int poN=-1;
			int soN=-1;
			int opN=-1;
			try{
				poN=Integer.parseInt(po);
				soN=Integer.valueOf(so).intValue();//otra forma de pasar string a int (tipo primitivo)
				opN=new Integer(op).intValue();
			}catch(NumberFormatException nfe){
				isDataInteger=false;
			}
			if(isDataInteger){
				System.out.println("Operacion: "+op+" primer op: "+po+" segundo op: "+so);
				String res=null;
				switch (opN) {
					case 1:
						res=String.valueOf(poN+soN);
						break;
					case 2:
						res=String.valueOf(poN-soN);
						break;
					case 3:
						res=String.valueOf(poN*soN);
						break;
					case 4:
						double d=poN/soN;
						res=String.valueOf(d);
						break;
					default:
						break;
				}
				return res;
			}
			return null;
		}
		return null;
	}

	

}
