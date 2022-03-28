package mem;

import input.entiy.Restfulentiy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//有序链表
public class Version {
    Version next;
    FileInfo fileInfo;
    long index;
    List<MemStore> memStores;

    //待数据落盘是，便同步该数据
    Trailer trailer;


    public Version(String Tab_name, List<Restfulentiy.ColumfamilysBean> columfamilys) {
        fileInfo=new FileInfo(Tab_name,columfamilys);
    }

    public Version() {
    }

    /*alter*/
    public void alter(List<Restfulentiy.ColumfamilysBean> columfamilys){
        for (Restfulentiy.ColumfamilysBean cf:columfamilys){
            if ("put".equals(cf.getMethod())){
                fileInfo.tFilter.add(new FileInfo.TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.isUnique()));
            }else if ("delete".equals(cf.getMethod())){
                Iterator<FileInfo.TFilter> tFilterIterator=fileInfo.tFilter.iterator();
                while (tFilterIterator.hasNext()){
                    FileInfo.TFilter tt=tFilterIterator.next();
                    if (tt.cf_name.equals(cf.getCf_name())){
                        tFilterIterator.remove();
                    }
                }
            }else if ("update".equals(cf.getMethod())){
                Iterator<FileInfo.TFilter> tFilterIterator=fileInfo.tFilter.iterator();
                while (tFilterIterator.hasNext()){
                    FileInfo.TFilter tt=tFilterIterator.next();
                    if (tt.cf_name.equals(cf.getCf_name())){
                        //这里可以直接改属性
                        tFilterIterator.remove();
                    }
                }
                fileInfo.tFilter.add(new FileInfo.TFilter(cf.getCf_name(),cf.getType(),cf.getMin(),cf.getMax(),cf.isUnique()));
            } else {
                System.out.println("error");
            }
        }
    }
}
