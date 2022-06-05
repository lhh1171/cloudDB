package mem;

//对应的是一个表的一个版本的一个列族的数据
public class MemStore {
    String db_name;
    String table_name;
    int Version;
    String cf_name;
    /*用库名，表名，版本，列族来hash成的一个key*/
    int memKey;
    short type;
    SkipList skipList;

    public MemStore(String db_name, String table_name, int version, String cf_name, short type) {
        this.db_name = db_name;
        this.table_name = table_name;
        Version = version;
        this.cf_name = cf_name;
        this.type = type;
        this.memKey=(db_name+table_name+version+cf_name).hashCode();
        this.skipList = new SkipList();
    }

    public void insertValue(String rowKey, long valueLength, String cname, String value){
        /*TODO
        *  */
        SkipList.SkipNode node = skipList.find(rowKey);
        KeyValue valueListHead= node.data;
        if (valueListHead==null){
            skipList.insert(new KeyValue(rowKey,new ValueNode(cname,value,valueLength)));
        }else{
            valueListHead.insert(cname, value, valueLength);
        }
    }

    public MemStore() {
    }
}
