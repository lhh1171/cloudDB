package input.input;



import input.input.ENTITY.JTableCell;
import input.input.ENTITY.Order;
import input.input.ENTITY.TermCell;

import java.util.List;
/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class MultiSearch extends RequestEntity {
    private List<JTableCell> j_tables;

    private List<String> cf_names;

    private List<TermCell> terms;

    private List<Order> orders;

}
