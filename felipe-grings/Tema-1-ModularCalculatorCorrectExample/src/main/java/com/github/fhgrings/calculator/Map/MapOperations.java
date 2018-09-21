package com.github.fhgrings.calculator.Map;

import com.github.fhgrings.calculator.Config.GESPONE;
import com.github.fhgrings.calculator.Operations.Operations;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {
    public Map<String, Operations> mapOperation = new HashMap<>();

    public Map<String, Operations> getMapOperation () {
        return mapOperation;
    }
}
