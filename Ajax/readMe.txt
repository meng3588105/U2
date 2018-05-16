Ajax(Asynchronous JavaScript And Xml)
  01.各种技术的整合体，并不是一个新技术
  02.异步交互的技术
  
Ajax的核心对象  XMLHttpRequest对象
 一：常用的属性
  1.1：readyState:  表示XMLHttpRequest对象状态码    
       举例说明： 吃饭
             0: 我们现在决定去饭店A吃饭,没有打电话给饭店A
             1: 打电话给饭店A,但是饭店A没有接电话
             2: 饭店A接电话,我们说（需要订桌==》请求）
             3: 服务员说（稍等===》响应），然后去查询或者询问经理
             4: 已经确定是否有空桌，给我们准确的答复
             
                                 我们需要吃饭，必须完成4！
             
             
             0: 我们已经创建了XMLHttpRequest对象，但是还没有初始化，在open()之前
             1: XMLHttpRequest对象已经准备就绪，还没有和服务器建立连接，在send()之前
             2: 调用了send()，与服务器建立连接，但是没有得到服务器的相应
             3: 接收到了Http响应头，但是主体部分没有获取
             4: 响应完成，我们就可以拿到服务器给我们的所有数据 
             
                                  我们需要获取服务器响应的所有数据，必须完成4！ 
   
    在 readyState发生变化的时候都会触发另一个属性（回调函数）       
    
    1.2：onreadystatechange   在 readyState发生变化的时候都会触发这个个属性（回调函数）             
    1.3：responseXML 获取服务器返回的xml内容             
    1.4：responseTEXT 获取服务器返回的文本内容    
    1.5：status :http状态码
         1xx: 信息响应类型，表示服务器已经接收请求，可以进一步处理        
         2xx: 处理成功类型，表示服务器响应成功        
         3xx: 重定向类型，   表示为了完成某个功能，需要进一步操作       
         4xx: 客户端错误类型，表示我们的请求不合法
         5xx: 服务器错误类型，表示服务器内部代码错误        
    1.6：statusText :Http状态码对应的文本      ，只能是readystate=3|4的时候使用！                         
                                                                   
                                  
二：常用的方法                               
      2.1：abort():把XMLHttpRequest对象还原成初始化状态
      2.2：open(String method,String url,boolean asynch,String userName,String password):                           
          method:请求的方式，默认是get，可以使用post  head  put delete                         
          url:请求的服务器地址
          asynch：是否异步交互，true 
          userName，password:在有的服务器需要身份认证时使用
      2.3：setRequestHeader(key,value):设置请求头部信息，务必在open之后设置                       
      2.4：send():发送给服务器
           01.get方式
              send()                            
              send(null)                            
           02.post方式
              send(后台的数据) 
                                 必须设置 setRequestHeader("Content-Type","application/x-www-form-urlencoded");                     
      2.5:getResponseHeader(key)  :获取响应的指定信息                       
      2.6:getAllResponseHeaders()  :获取响应的所有信息                       
                                  
                                  
                                  
                                  
             