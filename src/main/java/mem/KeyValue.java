package mem;

import java.util.Date;

public class KeyValue {

    String rowKey;
    String cname;
    long timeStamp;
    String value;
    long valueLength;

    public KeyValue(String rowKey, long valueLength, String cname, String value) {
        Date date=new Date();
        this.timeStamp=date.getTime();
        this.rowKey = rowKey;
        this.valueLength = valueLength;
        this.cname=cname;
        this.value=value;
    }
}
