package com.service;

import com.bean.Easybuy_user;
import java.util.*;
import java.util.Date;
public interface Easybuy_userService {

	/*添加方法*/
	 int add(Easybuy_user easybuy_user);
	/*修改方法*/
	 int update(Easybuy_user easybuy_user);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_user findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_user> findAll();


}