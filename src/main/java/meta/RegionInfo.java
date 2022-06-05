package meta;

//存储region的具体信息(元数据)
public class RegionInfo {
    //该列对应的 Value 主要存储Region打开时的sequenceId
    String sequenceIdDuringOpen;
    //该列对应的 Value 主要存储Region落在的RegionServer（通过该属性是可以找到RegionServer）
    RegionServer regionServer;
    //该列对应的 Value 主要存储所在RegionServer的启动Timestamp
    long serverStartTime;
    //该列对应的 value 表示 Region 状态( DISABLED 状态/ ENABLED 状态)
    byte state;
    static class Range{}
    static class RegionServer{}
}
