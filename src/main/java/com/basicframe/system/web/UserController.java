package com.basicframe.system.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.basicframe.common.remote.ajax.AjaxResult;
import com.basicframe.common.remote.datatables.PageRequest;
import com.basicframe.common.remote.datatables.PageResponse;
import com.basicframe.system.entity.User;
import com.basicframe.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        page.setCurrent(request.getDraw() - 1);
        page.setSize(request.getLength());
        Wrapper wrapper = new EntityWrapper();
        wrapper.orderBy("createTime", false);
        page.setRecords(userService.selectList(wrapper));
        int count = userService.selectCount(new EntityWrapper<>());
        PageResponse response = new PageResponse(page.getCurrent(), count, page.getRecords());
        return response;
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
     * 描述：根据id删除用户
     *
     * @param id 唯一标识
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(@PathVariable(value = "id") String id) throws Exception {
        userService.deleteById(id);
        return AjaxResult.success("删除成功!");
    }

    /**
     * 批量删除用户
     *
     * @param ids id列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batch_del", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult batchDelete(@RequestParam(value = "ids[]") List<String> ids) throws Exception {
        userService.deleteBatchIds(ids);
        return AjaxResult.success("删除成功！");
    }

    /**
     * 描述：编辑用户
     *
     * @param user 用户对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult edit(User user) throws Exception {
        userService.editUser(user);
        return AjaxResult.success("编辑成功！");
    }

    /**
     * 描述：更改用户状态
     *
     * @param id     id
     * @param status 用户状态
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modify_status/{id}/{status}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult modifyUserStatus(@PathVariable(value = "id") String id, @PathVariable(value = "status") String status) throws Exception {
        //1.判断该用户是否存在
        User user = userService.selectById(id);
        if (user == null) {
            return AjaxResult.error("该用户不存在！");
        }

        //2.更新用户状态
        user.setStatus(status);
        userService.updateById(user);
        return AjaxResult.success("用户状态更新成功！");
    }


}
