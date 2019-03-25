package com.hqyj.service.im.zx;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.hqyj.mapper.bt.ErpsysBasicInformationMapper;
import com.hqyj.mapper.zx.ErpsysAccountAuthorityMapper;
import com.hqyj.mapper.zx.ErpsysLoginLogMapper;
import com.hqyj.model.bt.ErpsysBasicInformation;
import com.hqyj.model.zx.ErpsysAccountAuthority;
import com.hqyj.model.zx.ErpsysLoginLog;
import com.hqyj.service.zx.DoSer;


@Service
public class DoSerIM implements DoSer {

	public static Gson g = new Gson();// Gson工具
	public static int pageSize = 5;// 每一页展示数
	@Resource
	private ErpsysBasicInformationMapper infomapper;
	@Resource
	private ErpsysAccountAuthorityMapper eaamapper;
	@Resource
	private ErpsysLoginLogMapper ellmapper;

	@Override
	public void doinfo(HttpServletRequest request) {
		// 设置账户名
		request.setAttribute("accountId", request.getSession().getAttribute("username"));
		// 设置姓名
		ErpsysBasicInformation eb = infomapper
				.selectByPrimaryKey(request.getSession().getAttribute("username").toString());
		request.setAttribute("name", eb.getAccountName());
		// 设置时间
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		request.setAttribute("time", sdf.format(d));
		// 设置IP地址
		request.setAttribute("ip", request.getRemoteAddr());
	}

	@Override
	public boolean dopsw(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		String pwd = request.getSession().getAttribute("password").toString();// session中存储的密码
		String pwd2 = request.getParameter("pwd");// 用户输入的旧密码
		String npwd = request.getParameter("npwd");// 用户输入的新密码
		if (pwd.equals(pwd2)) {
			npwd = new SimpleHash("MD5", npwd, username, 1024).toString();// 1.加密类型2.加密源3.盐值4.加密次数
			int i = infomapper.updatePWDByUsername(npwd, username);
			if (i > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String selectCount(HttpServletRequest request) {
		String serch = request.getParameter("search");
		if (serch == null) {
			serch = "";
		}
		serch = "%" + serch + "%";
		int count = infomapper.selectCount(serch);// 总数据条数
		int pageNum = count / pageSize;// 总页数
		if (count % pageSize > 0) {// 有余加一页
			++pageNum;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("count", count);
		map.put("pageNum", pageNum);
		return g.toJson(map);
	}

	@Override
	public String doList(HttpServletRequest request) {
		String serch = request.getParameter("search");
		if (serch == null) {
			serch = "";
		}
		serch = "%" + serch + "%";
		int num = Integer.parseInt(request.getParameter("num"));// 当前页数
		num = num - 1;
		if (num > 0) {
			num = num * pageSize;
		}
		List<String> userlist = infomapper.selectByNumAndPagesiz(num, pageSize, serch);
		return g.toJson(userlist);
	}

	@Override
	public void insertPower(HttpServletRequest request) {
		String account_id = request.getParameter("username");
		String[] powers = request.getParameterValues("power");
		eaamapper.deleteByaccount_id(account_id);
		for (String string : powers) {
			ErpsysAccountAuthority eaa = new ErpsysAccountAuthority();
			eaa.setAccountId(account_id);
			eaa.setAuthorityId(Integer.parseInt(string));
			eaamapper.insert(eaa);
		}

	}

	@Override
	public void dologlist(HttpServletRequest request) {
		List<ErpsysLoginLog> ellList = ellmapper.selectAll();
		request.setAttribute("ellList", ellList);

	}

	@Override
	public void dodelete(HttpServletRequest request) {
		String logid = request.getParameter("logid");
		if (logid != null) {
			ellmapper.deleteByPrimaryKey(Integer.parseInt(logid));
		}
		String[] logids = request.getParameterValues("logids");
		if (logids != null) {
			for (String string : logids) {
				ellmapper.deleteByPrimaryKey(Integer.parseInt(string));
			}
		}

	}

	@Override
	public String doupfile(HttpServletRequest request) {
		// 1:转化request为：MultipartHttpServletRequest
		MultipartHttpServletRequest mhsRequest = (MultipartHttpServletRequest) request;
		// 2:获取上传文件
		CommonsMultipartFile cmFlie = (CommonsMultipartFile) mhsRequest.getFile("file");
		// 3:获取上传文件的：字节数组
		byte[] byteNum = cmFlie.getBytes();
		// 4:获取文件的后缀名
		String oldFliename = cmFlie.getOriginalFilename();
		String suffix=null;
		try {
			 suffix = oldFliename.substring(oldFliename.lastIndexOf("."));
		} catch (Exception e) {
			return "false";
		}
		//4.1:后缀判定是否为jpg格式
		StringBuffer sb=new StringBuffer(suffix);
		String suffix2=sb.delete(0, 1).toString();
		if(!"jpg".equals(suffix2)) {
			return "false";
		}
		// 5:获取当前项目路径
		// String path = request.getSession().getServletContext().getRealPath("/");

		// 6:构建路径
		// 获取当前时间，并格式化文件名称
		/*
		 * Date date = new Date(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyyMMddHHmmssSSS"); String filename = sdf.format(date);
		 */
		String filename = (String) request.getSession().getAttribute("username");

		// 存储图片的物理路径
		String upload = "C:\\Users\\Jaynes\\eclipse-workspace2\\ERPSYS2\\src\\main\\webapp\\style\\photo\\";
		String url = upload + filename + suffix;

		// 把地址写入数据库

		infomapper.updateFileByUsername(filename, url);
		OutputStream os;
		try {
			os = new FileOutputStream(url);
			os.write(byteNum);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public void doinfopage(HttpServletRequest request) {
		ErpsysBasicInformation ebi = infomapper.selectByPrimaryKey((String) request.getSession().getAttribute("username"));
		request.setAttribute("ebi", ebi);
	}

}
