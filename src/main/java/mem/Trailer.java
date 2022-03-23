package mem;

public class Trailer {
//    该版本的表在File中的偏移
    long file_offset;
//    数据块索引的个数
    int block_count;
//    版本信息。当前该版本值为1
    Version version;
}
