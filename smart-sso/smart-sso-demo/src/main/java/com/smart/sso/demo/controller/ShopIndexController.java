
/**
 * @author dgh
 *
 */
package com.smart.sso.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smart.mvc.controller.BaseController;
import com.smart.sso.client.OtherSession;
import com.smart.sso.client.SessionPermission;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "单点登录")
@Controller
@RequestMapping("/shop")
public class ShopIndexController extends BaseController{
	
	@ApiOperation("首页")
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView("index");
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		// 登录用户名
		mv.addObject("userName", sessionUser.getAccount());
		SessionPermission sessionPermission = SessionUtils.getSessionPermission(request);
		if (sessionPermission != null){
			// 登录用户当前应用的菜单
			mv.addObject("userMenus", sessionPermission.getMenuList());
			// 登录用户当前应用的权限
			mv.addObject("userPermissions", sessionPermission.getPermissionSet());
		}
		OtherSession otherSession = SessionUtils.getOtherSession(request);
		System.out.println(otherSession != null ? otherSession.getSessionValue() : null);
		return mv;
	}
}