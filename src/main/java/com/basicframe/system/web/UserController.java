package com.basicframe.system.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.basicframe.common.remote.ajax.AjaxResult;
import com.basicframe.common.remote.datatables.PageRequest;
import com.basicframe.common.remote.datatables.PageResponse;
import com.basicframe.system.entity.User;
import com.basicframe.system.service.IUserService;
import com.basicframe.system.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lilihao
 * @since 2017-08-14
 */
@Controller
@RequestMapping("/admin/system/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 描述：跳转到用户列表页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute("count", userService.selectCount(new EntityWrapper<>()));
        return "admin/user/list";
    }

    /**
     * 描述：跳转到新增页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() throws Exception {
        return "admin/user/edit";
    }


    /**
     * 描述：跳转到修改页
     *
     * @param id    唯一标识
     * @param model model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modify(@PathVariable(value = "id") String id, Model model) throws Exception {
        model.addAttribute("user", userService.selectById(id));
        return "admin/user/edit";
    }

    /**
     * 描述：分页获取用户列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse readList(Page<User> page, PageRequest request) throws Exception {
        page.setCurrent(request.getDraw());
        page.setSize(request.getLength());
        page.setRecords(userService.selectByMap(new HashMap<>()));
        return new PageResponse(page.getCurrent(), userService.selectCount(new EntityWrapper<>()), page.getRecords());
    }

    /**
     * 描述：跳转到用户信息页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user_info", method = RequestMethod.GET)
    public String userInfo() throws Exception {
        return "admin/user/userInfo";
    }

    /**
     * 描述：删除用户
     *
     * @param id 唯一标识
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(@PathVariable(value = "id") String id) throws Exception {
        userService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    /**
     * 描述：编辑用户
     *
     * @param user 用户对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult edit(User user) throws Exception {
        return AjaxResult.success("编辑成功！");
    }


}
