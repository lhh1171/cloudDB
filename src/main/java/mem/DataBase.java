package mem;

import input.entiy.Restfulentiy;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    String DataName;
    //后续可以搞个跳表
    List<Table> tables;
    public DataBase(String DbName){
        this.DataName=DbName;
        tables=new ArrayList<Table>();
    }
    public void createTable(String TabName,List<Restfulentiy.ColumfamilysBean> columfamilys){
        boolean flag=false;
        Table tab = null;
        for (Table ta:tables){
           if (ta.tab_name.equals(TabName)){
               flag=true;
               tab=ta;
               break;
           }
        }
        if (!flag){
            Table table=new Table(TabName);
            table.createVersion(columfamilys);
            tables.add(table);
        } else {
            tab.createVersion(columfamilys);
            tables.add(tab);
        }
    }
}
