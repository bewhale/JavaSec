package org.bewhale.javasec.controller.componentsvul.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm { // 9. 前面被authc拦截后，需要认证，SecurityBean会调用这里进行认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 9.1. 为了方便演示，我这里写死了用户admin-name密码admin-pwd才能登录
        if (token.getUsername() == null || !token.getUsername().equals("admin")) {
            return null;
        }

        return new SimpleAuthenticationInfo("", "admin", "");
    }

    // 10. 前面被roles拦截后，需要授权才能登录，SecurityManager需要调用这里进行权限查询
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        // 10.1. 为了方便演示，这里直接写死返回了admin角色，所有能登录的角色都是admin了
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        return info;
    }
}