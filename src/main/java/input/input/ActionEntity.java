package input.input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionEntity {
    String Method;
    String Url;
    HashMap<String,String> RegularAttribute;
    Map <String,List<HashMap<String,String>>> CompoundAttribute;
}


