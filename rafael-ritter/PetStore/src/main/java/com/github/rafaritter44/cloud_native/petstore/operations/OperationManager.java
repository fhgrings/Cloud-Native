package com.github.rafaritter44.cloud_native.petstore.operations;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class OperationManager {

    private List<Operation> operations;

    public OperationManager() {
        operations = new ArrayList<>();
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void executeOperations() {
        operations.forEach(Operation::execute);
    }

}
