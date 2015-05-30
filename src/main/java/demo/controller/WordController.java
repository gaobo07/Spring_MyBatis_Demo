package demo.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Word;
import demo.service.WordService;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("word")
public class WordController extends BaseController {

    @Autowired
    private WordService wordService;

    @RequestMapping("add")
    private String add(Word word) {
        wordService.add(word);
        return "redirect:list";
    }

    @RequestMapping("list/{page}")
    private String list(@PathVariable int page) {
        super.session.setAttribute("pagination", wordService.list(page));
        return "redirect:/word/list.jsp";
    }

    @RequestMapping("list")
        private String defaultList() {
        return list(1);
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("word", wordService.search(id));
        return "redirect:/word/edit.jsp";
    }

    @RequestMapping("fuzzy/{page}")
    private String fuzzy(@PathVariable int page, Word word) {
        if (page == 1) {
            session.setAttribute("fuzzyWord", word);
        } else {
            word = (Word) session.getAttribute("fuzzyWord");
        }
        try {
           session.setAttribute("pagination", wordService.fuzzy(page, BeanUtils.describe(word)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:/word/list.jsp";
    }

    @RequestMapping("fuzzy")
    private String defaultFuzzy(Word word) {
        return fuzzy(1, word);
    }

    @RequestMapping("modify")
    private String modify(Word word) {
        wordService.modify(word);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        wordService.remove(id);
        return "redirect:/word/list";
    }
}