package input.input;



import input.input.ENTITY.Aggregate;
import input.input.ENTITY.Order;
import input.input.ENTITY.TermCell;

import java.util.List;
/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class SingleSearch extends RequestEntity {
    private List<String> cf_names;

    private List<TermCell> terms;

    private List<Order> orders;

    private List<Aggregate> aggregate;

}
