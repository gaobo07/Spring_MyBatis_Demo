package demo.controller;

import demo.model.Admin;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Log;
import demo.service.LogService;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("log")
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @RequestMapping("add")
    private String add(Log log) {
//        todo 日期的判断，每天只能发布一次日志
        log.setUserId(((Admin)session.getAttribute("admin")).getId());
        logService.add(log);
        return "redirect:list";
    }

    @RequestMapping("list/{page}")
    private String list(@PathVariable int page) {
        Admin admin = (Admin) session.getAttribute("admin");
        String role = admin.getRole();
        if (role.equals("员工")) {
            session.setAttribute("pagination", logService.employeeList(page, admin.getId()));
        }
        if (role.equals("组长")) {
//            todo
        }
        return "redirect:/log/list.jsp";
    }

    @RequestMapping("list")
        private String defaultList() {
        return list(1);
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("log", logService.search(id));
        return "redirect:/log/edit.jsp";
    }

    @RequestMapping("fuzzy/{page}")
    private String fuzzy(@PathVariable int page, Log log) {
        if (page == 1) {
            session.setAttribute("fuzzyLog", log);
        } else {
            log = (Log) session.getAttribute("fuzzyLog");
        }
        try {
           session.setAttribute("pagination", logService.fuzzy(page, BeanUtils.describe(log)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:/log/list.jsp";
    }

    @RequestMapping("fuzzy")
    private String defaultFuzzy(Log log) {
        return fuzzy(1, log);
    }

    @RequestMapping("modify")
    private String modify(Log log) {
        logService.modify(log);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        logService.remove(id);
        return "redirect:/log/list";
    }
}