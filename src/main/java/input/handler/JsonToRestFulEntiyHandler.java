//package input.handler;
//
//
//import input.entiy.Restfulentiy;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//import io.netty.handler.codec.http.FullHttpRequest;
//import io.netty.util.CharsetUtil;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class JsonToRestFulEntiyHandler extends ChannelInboundHandlerAdapter {
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//
//        Restfulentiy restfulentiy = toRestfulentiy(msg);
//        ctx.fireChannelActive();
//    }
//    public Restfulentiy toRestfulentiy(Object msg) throws JSONException {
//        FullHttpRequest fullHttpRequest =(FullHttpRequest) msg;
//        String content = fullHttpRequest.content().toString(CharsetUtil.UTF_8);
//        System.out.println(content);
//        return jsonToJavaOfRestfulentiy(content);
//    }
//    //解析json转换为实体
//    public  Restfulentiy jsonToJavaOfRestfulentiy(String content) throws JSONException {
//        Restfulentiy restfulentiy = new Restfulentiy();
//        JSONObject jsonObject =new JSONObject(content);
//        //第一层解析
//        JSONArray columfamilys = jsonObject.optJSONArray("columfamilys");
//        JSONArray terms = jsonObject.optJSONArray("terms");
//        JSONArray aggregate = jsonObject.optJSONArray("aggregate");
//        JSONArray jtables = jsonObject.optJSONArray("jtables");
//        JSONArray cfnames = jsonObject.optJSONArray("cfnames");
//        JSONArray values = jsonObject.optJSONArray("values");
//        String order = jsonObject.optString("order");
//        String text = jsonObject.optString("text");
//        String version = jsonObject.optString("version");
//        String rowkey = jsonObject.optString("rowkey");
//        restfulentiy.setRowkeysize(rowkey.getBytes().length);
//        System.out.println("rowkeysize:"+rowkey.getBytes().length);
//
//        //第一层封装
//        List<Restfulentiy.ColumfamilysBean> columfamilysBean =new ArrayList<Restfulentiy.ColumfamilysBean>();
//        restfulentiy.setColumfamilys(columfamilysBean);
//
//        List<Restfulentiy.TermsBean> termsBean =new ArrayList<Restfulentiy.TermsBean>();
//        restfulentiy.setTerms(termsBean);
//
//        List<Restfulentiy.AggregateBean> aggregateBean =new ArrayList<Restfulentiy.AggregateBean>();
//        restfulentiy.setAggregate(aggregateBean);
//
////        List<Restfulentiy.JtablesBean> jtablesBean =new ArrayList<Restfulentiy.JtablesBean>();
////        restfulentiy.setJtables(jtablesBean);
////
////        List<String> cfnamesBean=new ArrayList<String>();
////        restfulentiy.setCfnames(cfnamesBean);
//
//        List<Restfulentiy.ValuesBean> valuesBean = new ArrayList<Restfulentiy.ValuesBean>();
//        restfulentiy.setValues(valuesBean);
//
//        restfulentiy.setOrder(order);
//        restfulentiy.setText(text);
//        restfulentiy.setVersion(version);
//        restfulentiy.setRowkey(rowkey);
//
//        //第二层解析
//        if(columfamilys!=null)  {
//        for (int i = 0; i < columfamilys.length(); i++) {
//            JSONObject object = columfamilys.optJSONObject(i);
//            if(object==null)return null;
//            String cf_name = object.optString("cf_name");
//            String type = object.optString("type");
//            String min = object.optString("min");
//            String max = object.optString("max");
//            String unique = object.optString("unique");
//            String isNull = object.optString("isNull");
//            String version1 = object.optString("version");
//            String method = object.optString("method");
//            //第三层封装
//            Restfulentiy.ColumfamilysBean Bean =new Restfulentiy.ColumfamilysBean(cf_name,type,min,max,unique,isNull,version1,method);
//            columfamilysBean.add(Bean);
//        }
//        } else {
//            Restfulentiy.ColumfamilysBean Bean =new Restfulentiy.ColumfamilysBean(null,null,null,null,null,null,null,null);
//        }
//        if(terms!=null) {
//            for (int i = 0; i < terms.length(); i++) {
//                JSONObject object = terms.optJSONObject(i);
//                if (object == null) return null;
//                String cf_name = object.optString("cf_name");
//                System.out.println(cf_name);
//                String c_name = object.optString("c_name");
//                int versionfrom = object.optInt("version-from");
//                int versionto = object.optInt("version-to");
//                String max = object.optString("max");
//                String size = object.optString("size");
//                String min = object.optString("min");
//                String like = object.optString("like");
//                String tablename = object.optString("tablename");
//
//                //第二层封装
//                Restfulentiy.TermsBean Bean = new Restfulentiy.TermsBean(cf_name, c_name, versionfrom, versionto, max, size, min, like, tablename);
//                termsBean.add(Bean);
//            }
//        }else {
//            Restfulentiy.TermsBean Bean = new Restfulentiy.TermsBean(null,null,0,0,null,null,null,null,null);
//        }
//        if(aggregate!=null){
//        for (int i = 0; i < aggregate.length(); i++) {
//            JSONObject object = aggregate.optJSONObject(i);
//            if(object==null)return null;
//            String c_name = object.optString("c_name");
//            String function = object.optString("function");
//            String as = object.optString("as");
//
//            //第二层封装
//            Restfulentiy.AggregateBean Bean=new Restfulentiy.AggregateBean(c_name,function,as);
//            aggregateBean.add(Bean);
//        }
//        }else {
//            Restfulentiy.AggregateBean Bean=new Restfulentiy.AggregateBean(null,null,null);
//        }
//        if(jtables!=null){
//        for (int i = 0; i < jtables.length(); i++) {
//            JSONObject object = jtables.optJSONObject(i);
//            if(object==null)return null;
//            String tabname = object.optString("tabname");
//            String method = object.optString("method");
//
//            //第二层封装
//            Restfulentiy.JtablesBean Bean=new Restfulentiy.JtablesBean(tabname,method);
//            jtablesBean.add(Bean);
//        }
//        }else {
//            Restfulentiy.JtablesBean Bean=new Restfulentiy.JtablesBean(null,null);
//        }
//        if(cfnames!=null){
//        for (int i = 0; i < cfnames.length(); i++) {
//            String cfname = cfnames.optString(i);
//            if(cfname==null)return null;
//            //二层封装
//            cfnamesBean.add(cfname);
//        }
//        }else {
//            cfnamesBean.add(null);
//        }
//        if (values != null) {
//            for (int i = 0; i < values.length(); i++) {
//                JSONObject object = values.optJSONObject(i);
//                if (object == null) return null;
//                String cf_name = object.optString("cf_name");
//                int cf_namesize= cf_name.getBytes().length;
//                String c_name = object.optString("c_name");
//                int c_namesize= c_name.getBytes().length;
//                String value = object.optString("value");
//                int valuesize= value.getBytes().length;
//
//                //二层封装
//                Restfulentiy.ValuesBean Bean = new Restfulentiy.ValuesBean(cf_name, c_name, value,cf_namesize,c_namesize,valuesize);
//                System.out.println(Bean.toString());
//                valuesBean.add(Bean);
//            }
//        }else {
//            Restfulentiy.ValuesBean Bean = new Restfulentiy.ValuesBean(null,null, null,0,0,0);
//        }
//        return restfulentiy;
//    }
//}
