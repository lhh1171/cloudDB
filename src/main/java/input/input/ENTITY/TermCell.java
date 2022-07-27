package input.input.ENTITY;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class TermCell {
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
    private long size;
    private double max;
    private double equivalence;
    private double min;
    private String like;
}
