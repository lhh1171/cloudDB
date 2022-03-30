package mem;

import input.entiy.Restfulentiy;


import java.util.List;

//对应的是一个表的一个版本的一个列的数据
public class MemStore {

    String cf_name;
    short type;
    BPlusTree<Value,String> bPlusTree=new BPlusTree<Value,String>();

    public MemStore(String cf_name, short type) {
        this.cf_name = cf_name;
        this.type = type;
    }

    public void insert(List<Restfulentiy.ValuesBean> valuesBeans, long cellLength){
        for (Restfulentiy.ValuesBean value:valuesBeans){
            bPlusTree.insert(new Value(value.getRowKey(),cellLength, value.getC_name(),value.getValue()),value.getRowKey());
        }
    }



}
