# springboot入门  
## 新建gradle项目   
![步骤一](images/01.jpg)  
## 下一步(next)  
![步骤二](images/02.jpg)  
## 填写项目名称(Project name)，点击next继续   
![步骤三](images/03.jpg)  
## 下一步(next)  
![步骤四](images/04.jpg)  
## 等待完成  
![步骤五](images/05.jpg)  
## 点击完成(finish)  
![步骤六](images/06.jpg)  
## 项目结构,删除掉src中的所有类  
![步骤七](images/07.jpg)  
## 打开build.gradle文件 
![步骤八](images/08.jpg)  
## 内容如图 [配置文件](build.gradle)  
![步骤九](images/09.jpg)  
## 更新项目，需要联网自动分析和拉取项目依赖文件     
![步骤十](images/10.jpg)  
## 更新项目后的效果   
![步骤十一](images/11.jpg)  
## 创建springboot配置文件   
![步骤十二](images/12.jpg)  
## 文件位置和名称   
![步骤十三](images/13.jpg)  
## 配置文件内容[配置文件](src/main/java/application.yml)  
![步骤十四](images/14.jpg)  
## 编写测试控制器   
![步骤十五](images/15.jpg)  
## 包(package)和类名称  
![步骤十六](images/16.jpg)  
## 控制器内容 [测试控制器](src/main/java/top/huhuiyu/springboot/controller/IndexController.java)  
![步骤十七](images/17.jpg)  
## 编写启动类,注意包名称，修改成控制器的上一级    
![步骤十八](images/18.jpg)  
## 启动类内容 [启动类](src/main/java/top/huhuiyu/springboot/Application.java)  
![步骤十九](images/19.jpg)  
## 用Spring Boot App方式启动  
![步骤二十](images/20.jpg)  
## 等控制台显示Started  Application in...  
![步骤二十一](images/21.jpg)  
## 打开浏览器输入127.0.0.1:13000  
![步骤二十二](images/22.jpg)  
## 输入127.0.0.1:13000/echo  
![步骤二十三](images/23.jpg)  
## 输入127.0.0.1:13000/echo?info=xxxx  
![步骤二十四](images/24.jpg)  