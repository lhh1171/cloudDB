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

    private List<ColumfamilysBean> columfamilys;
    private List<TermsBean> terms;
    private List<RangesBean> ranges;
    private List<AggregateBean> aggregate;
    private List<JtablesBean> j_tables;
    private List<String> cf_names;
    private List<ValuesBean> values;

    public String getOrder() {
        return order;
    }

    public String getText() {
        return text;
    }

    public String getVersion() {
        return version;
    }

    public String getRowkey() {
        return rowkey;
    }

    public int getRowkeysize() {
        return rowkeysize;
    }

    public List<ColumfamilysBean> getColumfamilys() {
        return columfamilys;
    }

    public List<TermsBean> getTerms() {
        return terms;
    }

    public List<RangesBean> getRanges() {
        return ranges;
    }

    public List<AggregateBean> getAggregate() {
        return aggregate;
    }

    public List<JtablesBean> getJ_tables() {
        return j_tables;
    }

    public List<String> getCf_names() {
        return cf_names;
    }

    public List<ValuesBean> getValues() {
        return values;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public void setRowkeysize(int rowkeysize) {
        this.rowkeysize = rowkeysize;
    }

    public void setColumfamilys(List<ColumfamilysBean> columfamilys) {
        this.columfamilys = columfamilys;
    }

    public void setTerms(List<TermsBean> terms) {
        this.terms = terms;
    }

    public void setRanges(List<RangesBean> ranges) {
        this.ranges = ranges;
    }

    public void setAggregate(List<AggregateBean> aggregate) {
        this.aggregate = aggregate;
    }

    public void setJ_tables(List<JtablesBean> j_tables) {
        this.j_tables = j_tables;
    }

    public void setCf_names(List<String> cf_names) {
        this.cf_names = cf_names;
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
         * Version : 版本
         * method : 操作方式put/delete/insert
         */

        private String old_cf_name;
        private String cf_name;
        private String type;
        private int min;
        private int max;
        private String unique;
        private String method;

        public void setOld_cf_name(String old_cf_name) {
            this.old_cf_name = old_cf_name;
        }

        public void setCf_name(String cf_name) {
            this.cf_name = cf_name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public void setUnique(String unique) {
            this.unique = unique;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getOld_cf_name() {
            return old_cf_name;
        }

        public String getCf_name() {
            return cf_name;
        }

        public String getType() {
            return type;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public String getUnique() {
            return unique;
        }

        public String getMethod() {
            return method;
        }
    }

    public static class RangesBean {
        /**

         * version-from : 从那个版本开始
         * version-to : 从那个版本结束
         */

        @SerializedName("version-from")
        private int versionfrom;
        @SerializedName("version-to")
        private int versionto;
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
        private String max;
        private String size;
        private String min;
        private String like;
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

        public String getFunction() {
            return function;
        }

        public String getAs() {
            return as;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public void setFunction(String function) {
            this.function = function;
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

        public String getTabname() {
            return tabname;
        }

        public String getMethod() {
            return method;
        }

        public void setTabname(String tabname) {
            this.tabname = tabname;
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
        private String rowKey;
        private String cf_name;
        private String c_name;
        private String value;
        private int cf_namesize;
        private int c_namesize;
        private int valuesize;

        public void setRowKey(String rowKey) {
            this.rowKey = rowKey;
        }

        public void setCf_name(String cf_name) {
            this.cf_name = cf_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setCf_namesize(int cf_namesize) {
            this.cf_namesize = cf_namesize;
        }

        public void setC_namesize(int c_namesize) {
            this.c_namesize = c_namesize;
        }

        public void setValuesize(int valuesize) {
            this.valuesize = valuesize;
        }

        public String getRowKey() {
            return rowKey;
        }

        public String getCf_name() {
            return cf_name;
        }

        public String getC_name() {
            return c_name;
        }

        public String getValue() {
            return value;
        }

        public int getCf_namesize() {
            return cf_namesize;
        }

        public int getC_namesize() {
            return c_namesize;
        }

        public int getValuesize() {
            return valuesize;
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
