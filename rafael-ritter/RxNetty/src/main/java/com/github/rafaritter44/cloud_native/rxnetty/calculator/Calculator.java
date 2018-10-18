package com.github.rafaritter44.cloud_native.rxnetty.calculator;

import java.util.ArrayList;
import java.util.List;

import com.github.rafaritter44.cloud_native.rxnetty.exception.DivisionByZeroException;
import com.github.rafaritter44.cloud_native.rxnetty.exception.NoSuchOperationException;
import com.google.inject.Singleton;

@Singleton
public class Calculator {

    private List<Operation> operations;

    public Calculator(){
    	operations = new ArrayList<>();
    }

    public double calculate(String operationName, double operand1, double operand2)
            throws NoSuchOperationException, DivisionByZeroException {
    	Operation operation = getOperation(operationName, operand1, operand2);
        operations.add(operation);
        return operation.calculate();
    }
    
    private Operation getOperation(String operationName, double operand1, double operand2)
    		throws NoSuchOperationException {
    	try {
    		return (Operation) Class.forName(this.getClass().getPackage().getName() + "." + operationName)
    				.getConstructor(double.class, double.class)
    				.newInstance(operand1, operand2);
    	} catch(ReflectiveOperationException exception) {
    		exception.printStackTrace();
    		throw new NoSuchOperationException("The informed operation (" + operationName + ") is not supported");
    	}
    }

    public List<Operation> getHistory() {
        return new ArrayList<>(operations);
    }

}