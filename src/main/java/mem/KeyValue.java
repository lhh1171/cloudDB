package mem;

import java.util.Date;

public class KeyValue{
    String cf_name;
    String rowKey;
    long timeStamp;
    String cname;
    String value;
    long valueLength;

    public KeyValue(String cf_name, String rowKey, long valueLength,String cname,String value) {
        Date date=new Date();
        this.timeStamp=date.getTime();
        this.cf_name = cf_name;
        this.rowKey = rowKey;
        this.valueLength = valueLength;
        this.cname=cname;
        this.value=value;
    }


}
