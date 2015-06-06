package demo.dao;

import demo.model.Log;
import demo.util.Pagination;

public interface LogDao extends GenericDao<Log, Integer> {
    Pagination<Log> employeeList(int page, int userId);
}