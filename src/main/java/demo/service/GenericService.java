package demo.service;

import demo.util.Pagination;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author mingfei.net@Gmail.com
 *         22:51, 4/16/15.
 */
public interface GenericService<M extends Serializable, ID extends Serializable> {

    void add(M model);

    M query(M model);

    M search(ID id);

    Pagination<M> fuzzy(int page, Map params);

    Pagination<M> list(int page);

    void modify(M model);

    void remove(ID id);
}
