package IR;

import java.util.ArrayList;

public class ValueIR {
    public ArrayList <ValueUnit> values;
    public String type;
    public int dim;
    public ValueIR(){
        values = new ArrayList<>();
    }
    public void addValue(ValueUnit unit){
        values.add(unit);
    }
}
