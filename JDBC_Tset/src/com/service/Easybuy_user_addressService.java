package com.service;

import com.bean.Easybuy_user_address;
import java.util.*;
import java.util.Date;
public interface Easybuy_user_addressService {

	/*添加方法*/
	 int add(Easybuy_user_address easybuy_user_address);
	/*修改方法*/
	 int update(Easybuy_user_address easybuy_user_address);
	/*通过ID删除方法*/
	 int delete(java.io.Serializable id);
	/*通过ID得到信息方法*/
	 Easybuy_user_address findbyid(java.io.Serializable id);
	/*添加方法*/
	 List<Easybuy_user_address> findAll();


}