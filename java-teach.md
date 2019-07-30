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

## 运算符

| 运算符 | 说明 | 范例 | 返回值类型 |
| ------ | ---- | ---- | ---- |
| instancef | 变量 a 是否是 A 类的实例，或者变量 a 是否实现了接口 I | a instanceof A | boolean |
| % | 取余 | 3 % 2 | int, long | 
| ^ | (位运算) 异或 | 1 ^ 2 | int, long |
| ~ | (位运算) 取反 | ~1 | int, long |
| ! | (逻辑) 取反 | !true | boolean |
| == | (逻辑) **值**相等 (注意与 `equals()` 的区别) | 1 != 2 | boolean |
| != | (逻辑) **值**不等 (注意与 `!equals()` 的区别) | 1 != 2 | boolean |

## 循环

若要遍历某个数组或 List，请使用 for-each 语句而不是 for 语句

## 条件、作用域

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

## 从泛型角度理解数组 

```csharp
int[] == Array<int> //注：Java 中基本类型不能用作类型参数
Integer[] == Array<Integer> //若要装基本类型，必须像这样装箱
String[] == Array<String>
```

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

# 常用接口

## 可序列化 Serializable

描述这个类可以被序列化成字符串

## 资源可关闭 Closeable

AutoClosable 

## 可克隆 Cloneable

描述这个类可以被克隆。使我们可以调用类的 `clone()` 方法来克隆某个对象。

请谨慎实现此接口，确保你已经非常清楚本节所述的内容。

这个接口十分特殊，它并没有定义任何方法。我们要用的 `clone()` 方法是由 Object 类实现的。但 Object 类要求我们必须实现这个接口才能调用此方法，否则会导致 `CloneNotSupportedException`. 这是接口的一种**极端非典型**的用法，不值得学习。（接口应该描述某个类能够做什么，然而这个接口改变了超类的行为）

尽管 Object 类实现了 clone() 方法，但它是 protected 的，若要让其可被访问，我们必须再子类覆盖它并将其设为 public。

**但必须要知道:**

* Object 的 `clone()` 方法只提供对对象中的字段的浅拷贝。如果某个字段是引用类型，则只会产生一个新引用，原有的对象**不会**被克隆。
* 如果想要克隆某个引用类型字段，必须手工克隆这个字段
* `clone()` 方法不调用类的构造器
* 如果你的这个类不允许继承，则应该处理掉 `CloneNotSupportedException`。若允许继承，则不应该处理此异常，或者压根别实现 Cloneable 接口

## 可比较 Comparable

描述这个类的对象与另一个对象存在大小关系，并且可以相互比较大小。如果你的类携带的信息可以用作比较（例如名字的字母排序），则应该考虑实现一下这个接口了。

实现这个接口需要覆盖 `int compareTo(T t)` 方法，并返回一个数字代表运算结果

a.compareTo(b)

| 返回的数字 | 意义 |
| ---------- | ---- |
| -1 或其他负整数 |  a < b |
| 0 |  a = b |
| 1 或其他正整数 |  a > b |

**注意**：通常建议如果 compareTo() 返回 0，则 equals() 也应该返回 true. 除非确实存在某些原因不能这样做。

当 compareTo() 返回 0，而 equals() 返回 false 时，有序集合的行为会与其他集合的行为变得不同。当把这两个元素往有序集合和其他集合里面放时，有序集合认为两个元素是相同的而只装其中一个，而其他集合会认为这两个元素不相同而全部装进去。

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

## 科学地覆盖 equals() hashCode() toString()

### toString()

通常我们建议有空就覆盖一下 `toString()`，这不仅方便打印，更方便调试。

覆盖 `toString()` 没有什么规定，按你喜欢的格式输出对象的重要信息即可（例如对于马扎，可以输出马扎的名字、大小、重量）

但是要注意一旦格式确定后就不要再改变了。未来可能有人会使用此格式来解析数据。

### hashCode()

我们通常对**所有**能代表对象**特征**的类成员使用异或运算符 **^** 来计算 hashcode

例如：代表马扎的 颜色color, 重量weight, 大小size

则应这样覆盖马扎类的 `hashCode()` 方法

```java
@Override
public int hashCode() {
    return color ^ weight ^ size;
}
```

**注意**

* 如果两个对象 `equals()` 的结果为 true（即逻辑上是相等的），则它们的 hashCode 必须相等
* 如果计算 hashCode 的开销很大，则可以设置一个变量缓存计算结果

### equals()

`equals()` 方法代表两个对象具有逻辑上的“相等”关系，例如 `"aBc" equals "aBc"`。若你的类的对象需要和另一个对象进行逻辑上的比较（例如比较两个马扎是否一样），则应该覆盖 `equals()` 和 `hashCode()` 方法

**注意**

* 一定要带上 @Override 注解，以检查覆盖是否正确
* 覆盖 `equals()` 时，请确保你的实现遵循离散数学中的*等价*原则（自反、传递、对称）
* 若你覆盖了 `equals()`   一定要同时覆盖 `hashCode()`，否则这个类将无法用于基于散列的容器（例如 HashMap）。
* 记得检查传入的参数是否为 `null`

## 单例模式

单例模式是用于那些只需要被实例化一次的类。后续获得的对象都是相同的实例。

**用途**：多次实例化这个类是没有意义的，甚至或引发错误。

**通常的实现方法**

### 设计 public static final INSTANCE 字段

```java
public class Signleton {
    public static final Signleton INSTANCE = new Signleton();

    // 注意：一定要提供 private 的构造器，防止他人new这个类
    private Signleton() {
        //code
    }

    public static Signleton getInstance() {
        return INSTANCE;
    }

    //code
}
```

### 使用枚举 (好!)

```java
public enum Signleton {
    INSTANCE;

    //code
}
```

## 通常不要使用 finalize() 方法

### 如果你是为了把他当成析构器用，那么绝对不要用！

这玩意可不是 C++ 中的析构器。`finalize()` 性能**很差**而**不可靠**。

如果你想使用 `finalize()` 方法，建议你去实现 `Closeable` 接口、定义一个 `close()` 方法。

如果你觉得手工调用 `close()` 很麻烦，你还可以实现 `AutoCloseable` 接口。通过结合 try 语句，可以实现自动关闭。

### finalize() 方法的正确用途

搞流氓的事情。典型的是防止这个对象被回收。

## 惰性加载

## 事件、回调和观察者

## 面向切面编程 AOP

## 控制反转 IoC

### 依赖查找

### 依赖注入

# 技巧

## 链式操作

## 使用静态工厂方法

**优点**

* 不必了解每个实现，直接查阅工厂类即可知道
* 可以自行管理对象（不会每次都创建被创建对象）

## 使用 Builder 构建类

**原因**：Java 的函数参数没有名字，只能按照参数顺序和个数调用函数或初始化类。对于参数很多的类或函数，这会让人烦躁。Android 大量使用了这种设计。

**优点**：

* 模拟了 Python、Kotlin 等语言的有名参数，易于阅读和使用
* 可以实现可变参数的效果
* (比较JavaBean) 只有最终的 `build()` 方法才会真正生成对象。此时可以进行安全检查，检查各项参数是否合法。

**建议**：永远不要使用 JavaBean 风格的方法去构建一个类，通常这不安全也不优雅。（无法确定对象的参数是否正确填写完毕、难以调试）

## 使用枚举代替数字

枚举的类型安全的

## 绝对不要出现各种魔法数字 (magic number)

不然您的项目就很小圆呢

## 防止内存泄漏

只要存在某个变量持有某个对象的强引用，这个对象就永远不会被回收，因此有些情况会出现内存泄漏问题。

**以下情况**应该小心内存泄漏：
  
* 你编写了一个类，手动管理内存（管理对象）
* 缓存。缓存请用弱引用
* 回调

但你**不**应该总是像写 C 语言那样总是在使用完毕对象后手工销毁，这样会让你的代码变得十分猥琐。

## Gradle 管理你的项目依赖

## JNI / native 关键字

实在不会用 Java 的话就用 JNI 来协作8

## Kotlin 神教!

* 空安全
* 自带单例模式
* 自带惰性加载
* 无需手动编写 setter/getter
* setter/getter 更加符合直觉
* 重写运算符
* 扩展方法
* 更优雅的构造器
* 你不需要使用 Builder
* 你可以少用工厂方法了