package org;

public class ValidationLogic {

	boolean flag;

public boolean marksValidation(String marks){
	
	if (Integer.parseInt(marks)>100){
		flag=true;
	}
	return flag;
}
public float savgCalc(String marks)
{
	return Integer.parseInt(marks)/3.0f;
}
}
