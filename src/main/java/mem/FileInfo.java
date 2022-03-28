package mem;

import input.entiy.Restfulentiy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//对应的是一个表的一个版本的基本元数据
public class FileInfo {
    //当ddl的时候，这些东西就会创建
    String Tab_name;
    Long init_time;
    List<TFilter> tFilter = new ArrayList<FileInfo.TFilter>();

    public FileInfo(String Tab_name, List<Restfulentiy.ColumfamilysBean> columfamilys) {
        this.Tab_name = Tab_name;
        this.init_time = new Date().getTime();
        for (Restfulentiy.ColumfamilysBean cf : columfamilys) {
            tFilter.add(new FileInfo.TFilter(cf.getCf_name(), cf.getType(), cf.getMin(), cf.getMax(), cf.isUnique()));
        }
    }

    public static class TFilter {
        //    列族名称
        String cf_name;
        //    列族类型
        short type;
        //    最小长度,默认为0
        long min = Long.MIN_VALUE;
        //    最大长度，默认为最大值
        long max = Long.MAX_VALUE;
        //   是否唯一,默认false
        boolean isUnique = false;

        public TFilter(String cf_name, short type, long min, long max, boolean isUnique) {
            this.cf_name = cf_name;
            this.type = type;
            this.min = min;
            this.max = max;
            this.isUnique = isUnique;
        }
    }
}
