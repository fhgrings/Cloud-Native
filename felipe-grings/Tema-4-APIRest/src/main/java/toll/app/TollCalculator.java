package toll.app;

import java.util.HashMap;
import java.util.Map;

public class TollCalculator {
    private Map<String,Double> mapValues;

    public TollCalculator() {
        mapValues = new HashMap<>();
        mapValues.put("fusca",2.11D);
        mapValues.put("bus",1.59D);
        mapValues.put("bike",0.49D);
        mapValues.put("moto",1D);
        mapValues.put("truck",3.95D);
        mapValues.put("axis",1D);
    }

    public double finalCalculation(String vehicleType, int extraAxis, double payment) {
        double change = payment - mapValues.get(vehicleType) + mapValues.get("axis")*extraAxis;
        return change;
    }

    public String priceList() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String type : mapValues.keySet()){
            stringBuffer.append(" | " + type + " | $" + mapValues.get(type) + " | \n");
        }
        stringBuffer.append("  Extra axis   $1");
        return stringBuffer.toString();
    }

}
