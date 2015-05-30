package demo.dao.impl;

import org.springframework.stereotype.Repository;

import demo.dao.WordDao;
import demo.model.Word;

@Repository
public class WordDaoImpl extends GenericDaoImpl<Word, Integer> implements WordDao {
}