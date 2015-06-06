package demo.service;

import demo.model.Log;
import demo.util.Pagination;

public interface LogService extends GenericService<Log, Integer> {
    Pagination<Log> employeeList(int page, int userId);
}