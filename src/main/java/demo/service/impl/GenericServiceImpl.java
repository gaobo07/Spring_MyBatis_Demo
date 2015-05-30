package demo.service.impl;

import demo.dao.GenericDao;
import demo.service.GenericService;
import demo.util.Pagination;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author mingfei.net@Gmail.com
 *         22:53, 4/16/15.
 */
public abstract class GenericServiceImpl<M extends Serializable, ID extends Serializable> implements GenericService<M, ID> {

    protected GenericDao<M, ID> genericDao;

    protected abstract void setGenericDao(GenericDao<M, ID> genericDao);

    @Override
    public void add(M model) {
        genericDao.add(model);
    }

    @Override
    public M query(M model) {
        return genericDao.query(model);
    }

    public M search(ID id) {
        return genericDao.search(id);
    }

    @Override
    public Pagination<M> fuzzy(int page, Map params) {
        return genericDao.fuzzy(page, params);
    }

    public Pagination<M> list(int page) {
        return genericDao.list(page);
    }

    public void modify(M model) {
        genericDao.modify(model);
    }

    public void remove(ID id) {
        genericDao.remove(id);
    }
}
