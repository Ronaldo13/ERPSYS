package com.hqyj.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.hqyj.mapper.bt.ErpsysBasicInformationMapper;
import com.hqyj.mapper.zx.ErpsysAccountAuthorityMapper;
import com.hqyj.model.bt.ErpsysBasicInformation;
import com.hqyj.model.zx.ErpsysAuthority;



public class MyRealm extends AuthorizingRealm{
	@Resource
	private ErpsysBasicInformationMapper infoMapper;
	@Resource
	private ErpsysAccountAuthorityMapper eaaMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roles = new HashSet<String>();// 角色权限
		// Set<String> permissions=new HashSet<String>();//细粒度权限
		/*
		 * 业务层
		 */
		String username = (String) principals.getPrimaryPrincipal();// 得到用户名
		List<ErpsysAuthority> r = eaaMapper.queryByID(username);// 通过用户id查询到用户拥有的角色
		for (ErpsysAuthority role : r) {
			if ("admin".equals(role.getAuthority())) {
				roles.add("admin");
			} else if ("godown".equals(role.getAuthority())) {
				roles.add("godown");
			} else if ("market".equals(role.getAuthority())) {
				roles.add("market");
			} else if ("produce".equals(role.getAuthority())) {
				roles.add("produce");
			} else if ("finance".equals(role.getAuthority())) {
				roles.add("finance");
			} else if ("personnel".equals(role.getAuthority())) {
				roles.add("personnel");
			} else if ("employee".equals(role.getAuthority())) {
				roles.add("employee");
			} 
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);// 返回权限对象
		// info.addStringPermissions(permissions);//增加细粒度对象
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken t=(UsernamePasswordToken) token;
		String username=t.getUsername();
		String password = new SimpleHash("MD5", new String(t.getPassword()), username, 1024).toString();//1.加密类型2.加密源3.盐值4.加密次数
		System.out.println(password);
		ErpsysBasicInformation ebi=infoMapper.selectByIdAndPWD(username,password);
		if(ebi!=null&&"1".equals(ebi.getAccountStatus())) {
			AuthenticationInfo info=new SimpleAuthenticationInfo(t.getUsername(),t.getPassword(),getName());
			return info;
		}else {
			throw new AuthenticationException();
		}
	}

}
