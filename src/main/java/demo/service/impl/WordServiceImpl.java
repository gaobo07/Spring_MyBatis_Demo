package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.dao.GenericDao;
import demo.model.Word;
import demo.service.WordService;

@Service
public class WordServiceImpl extends GenericServiceImpl<Word, Integer> implements WordService {

    @Override
    @Autowired
    @Qualifier("wordDaoImpl")
    public void setGenericDao(GenericDao<Word, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}