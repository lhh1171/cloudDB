package mem;

public class Trailer {
//    该版本的表在File中的偏移
    long file_offset;
//    数据块索引的个数
    int block_count;

    public Trailer() {
        this.file_offset = 0;
        this.block_count = 0;
    }
}
