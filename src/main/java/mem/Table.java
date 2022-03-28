package mem;

import input.entiy.Restfulentiy;

import java.util.ArrayList;
import java.util.List;

public class Table {
    String tab_name;
    Version head;
    Version tail;

    public Table(String TabName){
        this.tab_name=TabName;
        this.head=new Version();
        this.head.index=0;
        this.tail=head;
    }
    /*
     * create a table with parameters
     * */
    public void createVersion(List<Restfulentiy.ColumfamilysBean> columfamilys){
        Version version=new Version();
        version.index=tail.index+1;
        version.memStores=new ArrayList<MemStore>();
        for (Restfulentiy.ColumfamilysBean cf:columfamilys) {
            version.memStores.add(new MemStore(cf.getCf_name(), cf.getType()));
        }
        tail=version;
    }
}
