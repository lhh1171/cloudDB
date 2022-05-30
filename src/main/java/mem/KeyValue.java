package mem;

public class KeyValue {
    String rowKey;
    ValueNode valueListHead;

    public KeyValue(String rowKey, ValueNode valueListHead) {
        this.rowKey = rowKey;
        this.valueListHead = valueListHead;
    }
}
