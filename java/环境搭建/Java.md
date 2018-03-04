# Java
- [java官方网站](http://www.oracle.com/technetwork/java/index.html)和[jdk下载地址](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  
- jdk安装  
  ![步骤一](images/jdk01.jpg)  
  点击下一步  
  ![步骤二](images/jdk02.jpg)  
  可以点击更改修改安装目录然后点击下一步  
  ![步骤三](images/jdk03.jpg)  
  jre是java运行时可以不用更改修改安装目录直接点击下一步或者按回车键继续 
  ![步骤四](images/jdk04.jpg)  
  点击关闭完成   
- [spring开发工具官方网站](https://spring.io/tools)和[下载地址](http://download.springsource.com/release/STS/3.9.2.RELEASE/dist/e4.7/spring-tool-suite-3.9.2.RELEASE-e4.7.2-win32-x86_64.zip)  
- spring开发工具安装(需要jdk)
  ![步骤一](images/sts01.jpg)  
  解压文件  
  ![步骤二](images/sts02.jpg)  
  编辑sts目录中的sts.ini文件添加两行配置jdk安装路径  
  ![步骤三](images/sts03.jpg)  
  启动sts.exe,Workspaces为工作目录，配置文件和项目的默认保存位置，点击Launch进入  
  ![步骤四](images/sts04.jpg)  
  点击Dashboard旁边的x关闭  
  ![步骤五](images/sts05.jpg)  
  点击菜单Window-->preferences简单的配置开发环境  
  ![步骤六](images/sts06.jpg)  
  如图配置（刷新模式和默认文件编码）后点击Apply按钮接受改变后继续配置
  ![步骤七](images/sts07.jpg)  
  如图配置（默认jsp文件编码）后点击Apply and Close按钮接受改变和关闭配置界面  
- spring开发工具网站开发配置
  [tomcat(javaweb服务器)官方网站](http://tomcat.apache.org/)和[tomcat8下载地址](http://mirrors.shu.edu.cn/apache/tomcat/tomcat-8/v8.5.28/bin/apache-tomcat-8.5.28-windows-x64.zip)  
  ![步骤一](images/tomcat01.jpg)  
  解压文件  
  ![步骤二](images/tomcat02.jpg)  
  打开spring开发环境，右键单击Servers视图空白区域  
  ![步骤三](images/tomcat03.jpg)  
  选择apache-Tomcat8.5 Server点击Next  
  ![步骤四](images/tomcat04.jpg)  
  点击Browse...按钮选择tomcat所在目录,然后点击Finish按钮  
  ![步骤五](images/tomcat05.jpg)  
  视图中多了tomcat完成配置  
