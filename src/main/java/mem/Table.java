package mem;

import input.entiy.Restfulentiy;

import java.util.List;

public class Table {
    Version head;
    Version tail;
    public Table(){
        head=new Version();
        head.index=0;
        tail=head;
    }
    /*
     * create a table with parameters
     * */
    public void createTab(String TabName,List<Restfulentiy.ColumfamilysBean> columfamilys){
        Version version=new Version();
        version.index=tail.index+1;
        tail=version;
        version.memStore=new MemStore(TabName,columfamilys);
    }
}
