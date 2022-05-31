package mem;

public class KeyValue {
    String rowKey;
    ValueNode valueListHead;

    public KeyValue(String rowKey, ValueNode valueListHead) {
        this.rowKey = rowKey;
        this.valueListHead = valueListHead;
    }

    public void insert(String cname, String value, long valueLength) {
        ValueNode temp=valueListHead;
        while (true){
            temp=temp.next;
            if (temp==null){
                temp=new ValueNode(cname, value, valueLength);
            }
        }
    }
}
