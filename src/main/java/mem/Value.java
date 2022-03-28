package mem;

import java.util.Date;

public class Value {

    String rowKey;
    String cname;
    long timeStamp;
    String value;
    long valueLength;

    public Value(String rowKey, long valueLength,String cname,String value) {
        Date date=new Date();
        this.timeStamp=date.getTime();
        this.rowKey = rowKey;
        this.valueLength = valueLength;
        this.cname=cname;
        this.value=value;
    }
}
