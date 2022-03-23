package input.entiy;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restfulentiy {

    /**
     * columfamilys : [{"cf_name":"列族名称 ","type":"类型","min":"最小长度","max":"最大长度","unique":"是否唯一","isNull":"是否可以为空","Version":"版本","method":"操作方式put/delete/insert"}]
     * terms : [{"cf_name":"列族名称","c_name":"列名","version-from":"原来版本号","version-to":"新版本号","max":"最大值","size":"大小","min":"最小值","like":"模糊(%表示多个字符，_表示一个字符)","tablename":"表名"}]
     * aggregate : [{"c_name":"列名","function":"avg/min/max/sum(聚合)","as":"别名"}]
     * jtables : [{"tabname":"表名","method":"inner/left/right/full"}]
     * cfnames : ["rowkey","id","name","age"]
     * order : 升序降序
     * text : 操作解释
     * version : 版本号
     * rowkey : 唯一标识
     * values : [{"cf_name":"列族名称","c_name":"列名","value":"值"}]
     */

    private String order;
    private String text;
    private String version;
    private String rowkey;
    private int rowkeysize;

    public int getRowkeysize() {
        return rowkeysize;
    }

    public void setRowkeysize(int rowkeysize) {
        this.rowkeysize = rowkeysize;
    }

    private List<ColumfamilysBean> columfamilys;
    private List<TermsBean> terms;
    private List<AggregateBean> aggregate;
    private List<JtablesBean> jtables;
    private List<String> cfnames;
    private List<ValuesBean> values;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public List<ColumfamilysBean> getColumfamilys() {
        return columfamilys;
    }

    public void setColumfamilys(List<ColumfamilysBean> columfamilys) {
        this.columfamilys = columfamilys;
    }

    public List<TermsBean> getTerms() {
        return terms;
    }

    public void setTerms(List<TermsBean> terms) {
        this.terms = terms;
    }

    public List<AggregateBean> getAggregate() {
        return aggregate;
    }

    public void setAggregate(List<AggregateBean> aggregate) {
        this.aggregate = aggregate;
    }

    public List<JtablesBean> getJtables() {
        return jtables;
    }

    public void setJtables(List<JtablesBean> jtables) {
        this.jtables = jtables;
    }

    public List<String> getCfnames() {
        return cfnames;
    }

    public void setCfnames(List<String> cfnames) {
        this.cfnames = cfnames;
    }

    public List<ValuesBean> getValues() {
        return values;
    }

    public void setValues(List<ValuesBean> values) {
        this.values = values;
    }

    public static class ColumfamilysBean {
        /**
         * cf_name : 列族名称
         * type : 类型
         * min : 最小长度
         * max : 最大长度
         * unique : 是否唯一
         * isNull : 是否可以为空
         * Version : 版本
         * method : 操作方式put/delete/insert
         */

        private String cf_name;
        private String type;
        private String min;
        private String max;
        private String unique;
        private String isNull;
        private String method;
        public ColumfamilysBean(String cf_name, String type, String min, String max, String unique, String isNull, String version, String method) {
            this.cf_name = cf_name;
            this.type = type;
            this.min = min;
            this.max = max;
            this.unique = unique;
            this.isNull = isNull;
            this.method = method;
        }

        public String getCf_name() {
            return cf_name;
        }

        public void setCf_name(String cf_name) {
            this.cf_name = cf_name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getUnique() {
            return unique;
        }

        public void setUnique(String unique) {
            this.unique = unique;
        }

        public String getIsNull() {
            return isNull;
        }

        public void setIsNull(String isNull) {
            this.isNull = isNull;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }

    public static class TermsBean {
        /**
         * cf_name : 列族名称
         * c_name : 列名
         * version-from : 原来版本号
         * version-to : 新版本号
         * max : 最大值
         * size : 大小
         * min : 最小值
         * like : 模糊(%表示多个字符，_表示一个字符)
         * tablename : 表名
         */

        private String cf_name;
        private String c_name;
        @SerializedName("version-from")
        private int versionfrom;
        @SerializedName("version-to")
        private int versionto;
        private String max;
        private String size;
        private String min;
        private String like;
        private String tablename;

        public TermsBean(String cf_name, String c_name, int versionfrom, int versionto, String max, String size, String min, String like, String tablename) {
            this.cf_name = cf_name;
            this.c_name = c_name;
            this.versionfrom = versionfrom;
            this.versionto = versionto;
            this.max = max;
            this.size = size;
            this.min = min;
            this.like = like;
            this.tablename = tablename;
        }

        public String getCf_name() {
            return cf_name;
        }

        public void setCf_name(String cf_name) {
            this.cf_name = cf_name;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public int getVersionfrom() {
            return versionfrom;
        }

        public void setVersionfrom(int versionfrom) {
            this.versionfrom = versionfrom;
        }

        public int getVersionto() {
            return versionto;
        }

        public void setVersionto(int versionto) {
            this.versionto = versionto;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getTablename() {
            return tablename;
        }

        public void setTablename(String tablename) {
            this.tablename = tablename;
        }
    }

    public static class AggregateBean {
        /**
         * c_name : 列名
         * function : avg/min/max/sum(聚合)
         * as : 别名
         */

        private String c_name;
        private String function;
        private String as;

        public AggregateBean(String c_name, String function, String as) {
            this.c_name = c_name;
            this.function = function;
            this.as = as;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public String getFunction() {
            return function;
        }

        public void setFunction(String function) {
            this.function = function;
        }

        public String getAs() {
            return as;
        }

        public void setAs(String as) {
            this.as = as;
        }
    }

    public static class JtablesBean {
        /**
         * tabname : 表名
         * method : inner/left/right/full
         */

        private String tabname;
        private String method;

        public JtablesBean(String tabname, String method) {
            this.tabname = tabname;
            this.method = method;
        }

        public String getTabname() {
            return tabname;
        }

        public void setTabname(String tabname) {
            this.tabname = tabname;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }

    public static class ValuesBean {
        /**
         * cf_name : 列族名称
         * c_name : 列名
         * value : 值
         */
        private  String rowKey;
        private String cf_name;
        private String c_name;
        private String value;
        private int cf_namesize;
        private int c_namesize;
        private int valuesize;
        public String getRowKey() {
            return rowKey;
        }
        public void setRowKey(String rowKey) {
            this.rowKey = rowKey;
        }
        public int getCf_namesize() {
            return cf_namesize;
        }

        public void setCf_namesize(int cf_namesize) {
            this.cf_namesize = cf_namesize;
        }

        public int getC_namesize() {
            return c_namesize;
        }

        public void setC_namesize(int c_namesize) {
            this.c_namesize = c_namesize;
        }

        public int getValuesize() {
            return valuesize;
        }

        public void setValuesize(int valuesize) {
            this.valuesize = valuesize;
        }

        public ValuesBean(String cf_name, String c_name, String value, int cf_namesize, int c_namesize, int valuesize) {
            this.cf_name = cf_name;
            this.c_name = c_name;
            this.value = value;
            this.cf_namesize = cf_namesize;
            this.c_namesize = c_namesize;
            this.valuesize = valuesize;
        }

        public String getCf_name() {
            return cf_name;
        }

        public void setCf_name(String cf_name) {
            this.cf_name = cf_name;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ValuesBean{" +
                    "cf_name='" + cf_name + '\'' +
                    ", c_name='" + c_name + '\'' +
                    ", value='" + value + '\'' +
                    ", cf_namesize=" + cf_namesize +
                    ", c_namesize=" + c_namesize +
                    ", valuesize=" + valuesize +
                    '}';
        }
    }

}
