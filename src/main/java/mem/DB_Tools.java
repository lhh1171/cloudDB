package mem;


import input.entiy.Restfulentiy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lhh1171
 * @Date 2022/4/2 下午3:13
 * @Version 1.8
 */
public class DB_Tools {

    Map<String,Integer> version_flag;
    Map<String,FileInfo> fileInfoList;
    public DB_Tools() {
        this.version_flag = new HashMap<>();
    }

    public void create_Version(String DB_name, String tab_name,List<Restfulentiy.ColumfamilysBean> columfamilys){
        Integer version = version_flag.get(DB_name + tab_name);
        if (version==null){
            version=0;
        }
        FileInfo fileInfo=new FileInfo(DB_name,tab_name,version+1,columfamilys);
        version_flag.replace(DB_name + tab_name,version+1);
        fileInfoList.put(DB_name+tab_name+(version+1),fileInfo);
    }
}
