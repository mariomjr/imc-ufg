package org.com.model;

import org.com.entity.Imc;
import org.com.enums.EnumSexo;

public class ImcModel {
	
	public static Imc calcularImc(Double peso, Double altura, EnumSexo sexo){
	    Imc imc = new Imc();
		
	    if((peso!= null && peso <=0) || (altura!= null && altura <=0) || (sexo == null)){
	        return imc;
	    }
	    
	    Double valorImc = peso / (altura * altura);
	    imc.setValor(valorImc);
	    
	    if(sexo.equals(EnumSexo.MASCULINO)){
	        if(valorImc<20.7){
	        	imc.setSituacao("Abaixo do peso!");
	        }else if(valorImc>=20.7 && valorImc <26.4){
	        	imc.setSituacao("No peso Normal!");
	        }
	        else if(valorImc>=26.4 && valorImc <27.8){
	        	imc.setSituacao("Marginalmente acima do peso!");
	        }else if(valorImc>=27.8 && valorImc <31.1){
	        	imc.setSituacao("Acima do peso!");
	        }else if(valorImc>=31.1){
	        	imc.setSituacao("Obeso!");
	        }
	    }else if(sexo.equals(EnumSexo.FEMININO)){
	        if(valorImc<19.1){
	        	imc.setSituacao("Abaixo do peso!");
	        }else if(valorImc>=19.1 && valorImc <25.8){
	        	imc.setSituacao("No peso Normal!");
	        } else if(valorImc>=25.8 && valorImc <27.3){
	        	imc.setSituacao("Marginalmente acima do peso!");
	        }else if(valorImc>=27.3 && valorImc <32.3){
	        	imc.setSituacao("Acima do peso!");
	        }else if(valorImc>=32.3){
	        	imc.setSituacao("Obeso!");
	        }
	    }
	    return imc;
	}
}
