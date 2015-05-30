package demo.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.model.Admin;
import demo.service.AdminService;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("add")
    private String add(Admin admin) {
        adminService.add(admin);
        return "redirect:list";
    }

    @RequestMapping("list/{page}")
    private String list(@PathVariable int page) {
        super.session.setAttribute("pagination", adminService.list(page));
        return "redirect:/admin/list.jsp";
    }

    //match: admin/list/
    @RequestMapping("list")
    private String defaultList() {
        return list(1);
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        super.session.setAttribute("admin", adminService.search(id));
        return "redirect:/admin/edit.jsp";
    }

    @RequestMapping("fuzzy/{page}")
    private String fuzzy(@PathVariable int page, Admin admin) {
        if (page == 1) {
            session.setAttribute("fuzzyAdmin", admin);
        } else {
            admin = (Admin) session.getAttribute("fuzzyAdmin");
        }
        try {
           session.setAttribute("pagination", adminService.fuzzy(page, BeanUtils.describe(admin)));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/list.jsp";
    }

    @RequestMapping("fuzzy")
    private String defaultFuzzy(Admin admin) {
        return fuzzy(1, admin);
    }

    @RequestMapping("modify")
    private String modify(Admin admin) {
        adminService.modify(admin);
        return "redirect:list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        adminService.remove(id);
        return "redirect:/admin/list";
    }


    @RequestMapping("login")
    private String login(Admin admin) {
        admin = adminService.login(admin);
        if (admin == null) {
            request.setAttribute("msg", "invalid username or password.");
            return "admin/login";
        } else {
            session.setAttribute("admin", admin);
            return "redirect:/index.jsp";
        }
    }
}