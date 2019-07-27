# 面向对象基础概念 

## 对象

一个对象是一个实际存在的“物品”，比如一个马扎。由同一个类生产出的不同的马扎是不同的对象。

对象有属性。例如马扎的颜色、重量、大小。

对象有方法。例如打开马扎、折叠马扎。

## 类

类是构造对象的蓝图，用上面的例子继续说，就是描述如何制造马扎。

将这个类实例化，就是消耗资源、制造一个马扎（分配内存、产生一个对象）。显然，只要资源（内存）足够，我们可以制造无限个马扎。一旦马扎制造出来，他们就是独立的个体了，除了都是马扎以外，没有什么联系。

对象的属性、方法都是由类描述好的。

当你需要用一个马扎时，你需要的是马扎这个产品(对象)，而不是马扎的蓝图(类)。

## 继承



## 多态

# Java 基础 (1)

## main

## 基本类型

## 运算符、循环、条件、作用域

## 数组

## 字符串

# 类 Class

## 构造方法、初始化器

## 实例方法

## 静态方法和静态字段

## 静态初始化器

## 类的继承

## 命名守则

## 类和类型、类型转换

# 方法 Method

## 值与引用

## 包装类型、装箱和拆箱

## 方法重载 Overload

## 方法重写 Override

## 参数和返回值的设计思想

# 保护级别

# 包 package

# 异常 Exception

必检异常是垃圾设计

## 抛出和捕获异常

## 常用异常

## NullPointerException 问题和防止

# Java 基础 (2)

## List

## Map

## Set

## List/Map/Set 的实现

~ 数据结构

### Array*

### Linked*

### Hash*

### Sorted*

### Tree*

# 接口、抽象类和 Lambda 初步

## 定义一个接口

强调接口的无状态性

## 两种方法实现一个接口

## 匿名类

## Lambda

## 默认方法与 Trait 思想

## 函数式编程简介

# 泛型 Generics
*ClassName<T, U extends V, ? super R, ? extends S, ?>*

假设有一个类 Fruit 表示水果，另外两个类 Apple、Banana 表示 苹果、香蕉。显然后两者是前者的子类。代码定义如下

```java
 class Fruit {}
 class Apple extends Fruit {}
 class Banana extends Fruit {}

 class GreenApple extends Apple {}
 class RedApple extends Apple {}
```

## 泛型概述

Java 泛型擦除问题（JVM相对于CLI）、钻石操作符

## 协变和逆变

```
逆变与协变用来描述类型转换（type transformation）后的继承关系，其定义：如果A、B表示类型，f(⋅)表示类型转换，≤表示继承关系（比如，A≤B表示A是由B派生出来的子类）
f(⋅)是逆变（contravariant）的，当A≤B时有f(B)≤f(A)成立；
f(⋅)是协变（covariant）的，当A≤B时有f(A)≤f(B)成立；
f(⋅)是不变（invariant）的，当A≤B时上述两个式子均不成立，即f(A)与f(B)相互之间没有继承关系。
```

数组是协变的（Java的垃圾设计之一）。泛型是不变的。

## 泛型通配符 ?

`? extends Fruit` 表示一种类型，这种类型 Fruit 的子类型或它本身     
`? super GreenApple`  表示一种类型，这种类型 GreenApple 的父类型或它本身     

**永远记住**：泛型通配符表达的意思是我们有一种**确定的**类型，但是现在我们不知道这个类型具体到底是什么。再次强调，这个类型是确！定！的！

### List\<Fruit\>

`List<Fruit>` 表示一个 `List`，里面装有 `Fruit` 和他的所有子类。可以装下 Fruit, Apple, Banana, GreenApple, RedApple ....

`List<Apple>` 表示一个 `List`，里面装有 `Apple` 和他的所有子类。可以装下  Apple, GreenApple, RedApple，但不能装下 Banana, Fruit。因为他们不是 Apple 的子类

### 辨别

* List\<Object\> 可以装任何东西（任何类都是Object的子类）
* List\<?\> 这里装有一种**暂不确定**的东西和他的子东西。但是由于我们不知道这个东西是什么，万一装错东西就会爆炸，因此不能再装任何东西了。

### List\<? extends Fruit\>
`List<? extends Fruit>` 表示一个 `List`，里面装有某种类，这个类可能是 `Fruit`，也可能是 `Apple`, `Banana`...听起来好像和上一个没啥区别。**关键是我们不知道他到底是想限定哪个。**

假如 `? extends Fruit` 表示 `Apple`，那么这里可以装下 `Apple` 和他的所有子类。装 `Banana` 和 `Fruit` 都会爆炸。

假如 `? extends Fruit` 表示 `GreenApple`，那么这里可以装下 `GreenApple` 和他的所有子类。装 `Apple` 也会爆炸。

因为这种**不确定性**，导致我们压根就不清楚这个容器的限定范围是什么，也就不能装任何东西了。不过读东西是可以的，里面的东西一定的 Fruit 的子类。get() 方法返回 Fruit 类型的对象。

划重点：`List<? extends Fruit>` 只可读不可写

### List\<? super Fruit\>



# 注解 Annotation

## 注解概述

## 常用注解 

# IO, NIO/NIO.2 初步

## 流(Stream)的概念

## 常用流

### 控制台标准输入输出流

### 文件相关流

### 网络相关流

### 字符流

## RandomAccessFile

## NIO 的概念

## 常用通道

### FileChannel

### SocketChannel

## NIO.2 的概念

# 并发 Concurrent

## 线程 Thread

## 线程池 ThreadPool

## 锁

## synchronized

## 阻塞队列 BlockingQueue

## volatile 关键字

# 反射初步

## Class<?>, getClass()

## 用反射操控对象

## ClassLoader 初步

# 其他常用类库

## 集合操作 Collections

## 数组操作 Arrays

## StringBuilder/StringBuffer

## 时间和日期

## 大数

## 编码

## 常用数据编码方式

### JSON

### Base64

# 常用设计方法和思想

## 封装

## get/set

## 单例模式
kotlin牛逼

双重检查锁定模式

## 惰性加载

## 事件、回调和观察者

## 面向切面编程 AOP

## 控制反转 IoC

### 依赖查找

### 依赖注入

# 技巧

## 链式操作

## Gradle 管理你的项目依赖

## JNI / native 关键字

实在不会用 Java 的话就用 JNI 来协作8

## Kotlin 神教!