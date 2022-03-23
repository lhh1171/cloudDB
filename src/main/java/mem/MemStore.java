package mem;

import input.entiy.Restfulentiy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//对应的是一个表的一个版本的数据
public class MemStore {

    FileInfo fileInfo;
    Trailer trailer;
    BPlusTree<KeyValue,String> bPlusTree=new BPlusTree<KeyValue,String>();


    public MemStore(String Tab_name,List<Restfulentiy.ColumfamilysBean> columfamilys) {
        fileInfo=new FileInfo(Tab_name,columfamilys);
    }


    /*alter*/
    public void alter(List<Restfulentiy.ColumfamilysBean> columfamilys){
        for (Restfulentiy.ColumfamilysBean cf:columfamilys){
            if ("put".equals(cf.getMethod())){
//                fileInfo.tFilter.add(new FileInfo.TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.getUnique()));
            }else if ("delete".equals(cf.getMethod())){
                Iterator<FileInfo.TFilter> tFilterIterator=fileInfo.tFilter.iterator();
                while (tFilterIterator.hasNext()){
                    FileInfo.TFilter tt=tFilterIterator.next();
                    if (tt.cf_name==cf.getCf_name()){
                        tFilterIterator.remove();
                    }
                }
            }else if ("update".equals(cf.getMethod())){
                Iterator<FileInfo.TFilter> tFilterIterator=fileInfo.tFilter.iterator();
                while (tFilterIterator.hasNext()){
                    FileInfo.TFilter tt=tFilterIterator.next();
                    if (tt.cf_name==cf.getCf_name()){
                        //这里可以直接改属性
                        tFilterIterator.remove();
                    }
                }
//                fileInfo.tFilter.add(new FileInfo.TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.getUnique()));
            } else {
                System.out.println("error");
            }
        }
    }

    public void insert(List<Restfulentiy.ValuesBean> valuesBeans,long cellLength){
        for (Restfulentiy.ValuesBean value:valuesBeans){
            bPlusTree.insert(new KeyValue(value.getCf_name(),value.getRowKey(),cellLength, value.getC_name(),value.getValue()),value.getRowKey());
        }
    }


    //对应的是一个表的一个版本的基本元数据
    public static class FileInfo {
        //当ddl的时候，这些东西就会创建
        String Tab_name;
        Long init_time;
        List<TFilter> tFilter=new ArrayList<TFilter>();

        public FileInfo(String Tab_name,List<Restfulentiy.ColumfamilysBean> columfamilys) {
            this.Tab_name=Tab_name;
            this.init_time=new Date().getTime();
            for (Restfulentiy.ColumfamilysBean cf:columfamilys){
//                tFilter.add(new TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.getUnique()));
            }
        }
        public static class TFilter {
        //    列族名称
            String cf_name;
        //    列族类型
            short type;
        //    最小长度,默认为0
            long min=Long.MIN_VALUE;
        //    最大长度，默认为最大值
            long max=Long.MAX_VALUE;
        //   是否唯一
            boolean isUnique=false;

            public TFilter(String cf_name, short type, long min, long max, boolean isUnique) {
                this.cf_name = cf_name;
                this.type = type;
                this.min = min;
                this.max = max;
                this.isUnique = isUnique;
            }
        }
    }
}
