package meta;

//主要表述的是该region代表的是那个表的那几行数据
public class RegionRowKey {
    //表名称；
    String tableName;
    //表示当前 table 的 region 中存储的第一个 rowKey
    int startKey;
    //Region 创建的时间戳
    long timeStamp;
    //TableName,StartKey,Timestamp字符串的MD5 Hex值
    String encodedName;
}
