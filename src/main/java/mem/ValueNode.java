package mem;

import java.util.Date;

public class ValueNode {
    String cname;
    String value;
    long timeStamp;
    long valueLength;

    public ValueNode(String cname, String value, long valueLength) {
        Date date=new Date();
        this.timeStamp=date.getTime();
        this.cname = cname;
        this.value = value;
        this.valueLength = valueLength;
    }
}
