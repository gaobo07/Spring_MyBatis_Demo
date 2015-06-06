package demo.service.impl;

import demo.dao.LogDao;
import demo.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.dao.GenericDao;
import demo.model.Log;
import demo.service.LogService;

import java.util.List;

@Service
public class LogServiceImpl extends GenericServiceImpl<Log, Integer> implements LogService {

    @Override
    @Autowired
    @Qualifier("logDaoImpl")
    public void setGenericDao(GenericDao<Log, Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public Pagination<Log> employeeList(int page, int userId) {
        return ((LogDao) genericDao).employeeList(page, userId);
    }
}