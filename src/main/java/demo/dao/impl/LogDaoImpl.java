package demo.dao.impl;

import demo.util.Pagination;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import demo.dao.LogDao;
import demo.model.Log;

import java.util.List;

@Repository
public class LogDaoImpl extends GenericDaoImpl<Log, Integer> implements LogDao {
    @Override
    public Pagination<Log> employeeList(int page, int userId) {
        return page(page, userId, "employeeList");
    }
}