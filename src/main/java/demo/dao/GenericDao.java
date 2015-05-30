package demo.dao;

import demo.util.Pagination;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author mingfei.net@Gmail.com
 *         22:14, 4/16/15.
 */
public interface GenericDao<M extends Serializable, ID extends Serializable> {

    void add(M model);

    M query(M model);

    M search(ID id);

    Pagination<M> list(int page);

    Pagination<M> fuzzy(int page, Map params);

    void modify(M model);

    void remove(ID id);
}
