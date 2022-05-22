package mem;

import input.entiy.Restfulentiy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


//对应的是一个表的一个版本的基本元数据
public class FileInfo {
    //当ddl的时候，这些东西就会创建
    String DB_name;
    String Tab_name;
    int version_index;
    Long init_time;
    List<TFilter> tFilter;

    public FileInfo(String Tab_name, List<Restfulentiy.ColumfamilysBean> columfamilys) {
        this.Tab_name = Tab_name;
        this.init_time = new Date().getTime();
    }

    /*建立表时候，初始化元数据*/
    public FileInfo(String DB_name, String tab_name, int version_index,List<Restfulentiy.ColumfamilysBean> columfamilys) {
        tFilter = new ArrayList<>();
        this.DB_name = DB_name;
        Tab_name = tab_name;
        this.version_index = version_index;
        this.init_time = new Date().getTime();
        for (Restfulentiy.ColumfamilysBean cf : columfamilys) {
            tFilter.add(new FileInfo.TFilter(cf.getCf_name(), cf.getType(), cf.getMin(), cf.getMax(), cf.isUnique()));
        }
    }

    /*alter*/
    public void alter(List<Restfulentiy.ColumfamilysBean> columfamilys){
        for (Restfulentiy.ColumfamilysBean cf:columfamilys){
            if ("put".equals(cf.getMethod())){
                tFilter.add(new FileInfo.TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.isUnique()));
            }else if ("delete".equals(cf.getMethod())){
                Iterator<TFilter> tFilterIterator=tFilter.iterator();
                while (tFilterIterator.hasNext()){
                    FileInfo.TFilter tt=tFilterIterator.next();
                    if (tt.cf_name.equals(cf.getCf_name())){
                        tFilterIterator.remove();
                    }
                }
            }else if ("update".equals(cf.getMethod())){
                Iterator<FileInfo.TFilter> tFilterIterator=tFilter.iterator();
                while (tFilterIterator.hasNext()){
                    FileInfo.TFilter tt=tFilterIterator.next();
                    if (tt.cf_name.equals(cf.getCf_name())){
                        //这里可以直接改属性
                        tFilterIterator.remove();
                    }
                }
                tFilter.add(new FileInfo.TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.isUnique()));
            } else {
                System.out.println("error");
            }
        }
    }

    public static class TFilter {
        //    列族名称
        String cf_name;
        //    列族类型
        short type;
        //    最小长度,默认为0= Long.MIN_VALUE
        long min ;
        //    最大长度，默认为最大值= Long.MAX_VALUE
        long max ;
        //   是否唯一,默认false
        boolean isUnique ;

        public TFilter(String cf_name, short type, long min, long max, boolean isUnique) {
            this.cf_name = cf_name;
            this.type = type;
            this.min = min;
            this.max = max;
            this.isUnique = isUnique;
        }
    }
}
