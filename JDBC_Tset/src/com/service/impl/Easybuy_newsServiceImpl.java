package com.service.impl;

import java.io.Serializable;
import java.util.List;
import com.bean.Easybuy_news;
import com.dao.Easybuy_newsDao;
import com.service.Easybuy_newsService;
import com.dao.impl.Easybuy_newsDaoImpl;
import java.util.Date;
public class Easybuy_newsServiceImpl implements Easybuy_newsService {

	Easybuy_newsDao dao=new Easybuy_newsDaoImpl();
	@Override 
	 public int add(Easybuy_news t) {
		 int renum=dao.add(t);
		  if(renum>0){
			  System.out.println("添加成功！");
		 }else{ 
			  System.out.println("添加失败！");
		 }
		 return renum;
	
}
	@Override 
	 public int delete(Serializable id) {
		 int renum=dao.delete(id);
		  if(renum>0){
			  System.out.println("删除成功！");
		 }else{ 
			  System.out.println("删除失败！");
		 }
		 return renum;
	
}
	@Override 
	 public  List<Easybuy_news> findAll() {
		 return dao.findAll();
	
}
	@Override 
	 public Easybuy_news findbyid(Serializable id) {
		 return dao.findbyid(id);
	
}
	@Override 
	 public int update(Easybuy_news t) {
		 int renum=dao.update(t);
		  if(renum>0){
			  System.out.println("修改成功！");
		 }else{ 
			  System.out.println("修改失败！");
		 }
		 return renum;
	}


}