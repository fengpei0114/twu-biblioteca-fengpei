# BibliotecaApp

## 项目介绍

BibliotecaApp需要一个图书馆管理系统，所以使用命令行模式做了一个简易版的图书馆管理系统，目前实现的功能包括了查看图书，借书，还书，借电影，查看已借出图书，查看个人信息等。

## 运行环境

IDE： intelliJ IDEA 11.0.7

​	   jdk 1.8.0_151

​	   maven 3.6.0

单元测试：JUnit 4.12

​		   Mockito 3.3.3

## 项目结构

#### src包下存放源代码

com.twu.biblioteca.bean：

- Book：图书类
- BibliotecaHasList：图书馆的书单，电影单，用户信息
- Movie：电影类
- User：用户类
- 

com.twu.biblioteca.service

- BookService：提供图书相关的服务类
- MovieService：提供电影相关的服务类
- UserService：提供用户相关的服务类

com.twu.biblioteca.util

- InputBookUtil：提供输入各种信息的工具类
- InputUtil：提供输入信息相关的工具类

bibliotecaApp：提供Main函数和执行类

#### test包下存放测试代码

com.twu.biblioteca.service

- BookServiceTest：测试BookService中的类
- MovieServiceTest：测试MovieService中的类
- UserServiceTest：测试UserService中的类

com.twu.biblioteca.util

- InputBookUtilTest：测试InputBookUtil中的类
- InputUtilTest：测试InputUtil中的类

bibliotecaApp：测试bibliotecaApp中的类

# 