package demo.dao.impl;

import demo.util.Constant;
import demo.util.Pagination;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import demo.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author mingfei.net@Gmail.com
 *         22:25, 4/16/15.
 */
public class GenericDaoImpl<M extends Serializable, ID extends Serializable> implements GenericDao<M, ID> {

    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

    private String namespace;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        Class<M> modelClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        namespace = modelClass.getSimpleName().toLowerCase().concat(".");
    }

    @Override
    public void add(M model) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.insert(namespace.concat("add"), model);
        sqlSession.close();
    }

    @Override
    public M query(M model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        model = sqlSession.selectOne(namespace.concat("query"), model);
        sqlSession.close();
        return model;
    }

    @Override
    public M search(ID id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        M model = sqlSession.selectOne(namespace.concat("search"), id);
        sqlSession.close();
        return model;
    }

    @Override
    public Pagination<M> fuzzy(int page, Map params) {
        return page(page, params, "fuzzy");
    }

    @Override
    public Pagination<M> list(int page) {
        return page(page, null, "list");
    }

    @Override
    public void modify(M model) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.update(namespace.concat("modify"), model);
        sqlSession.close();
    }

    @Override
    public void remove(ID id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.delete(namespace.concat("remove"), id);
        sqlSession.close();
    }

    protected Pagination<M> page(int page, Object parameter, String selectId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<M> list = sqlSession.selectList(namespace.concat(selectId), parameter, getRowBounds(page));
        sqlSession.close();
        return getPagination(page, list, selectId, parameter);
    }

    private RowBounds getRowBounds(int page) {
        int offset = Constant.PAGE_SIZE * (page - 1);
        return new RowBounds(offset, Constant.PAGE_SIZE);
    }

    private Pagination<M> getPagination(int page, List<M> list, String selectId, Object parameter) {
        int totalRows = getTotalRows(selectId, parameter);
        int totalPages = (int)Math.ceil(totalRows/(double)Constant.PAGE_SIZE);
        page = (page > totalPages) ? totalPages : page;
        int currentPage = (page == 0 ? 1 : page);
        return new Pagination<>(list, selectId, totalRows, totalPages, currentPage, Constant.PAGE_SIZE);
    }

    private int getTotalRows(String selectId, Object parameter) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<M> list = sqlSession.selectList(namespace.concat(selectId), parameter);
        sqlSession.close();
        return list.size();
    }
}
