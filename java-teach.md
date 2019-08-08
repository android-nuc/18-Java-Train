

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

### 表示数字字面量

和 C 语言相同

#### 1. 很长的数字

为了方便阅读，你可以在数字直接加下划线方便阅读
```java
public static final int BIG_NUMBER = 1_000_000_000;
```

#### 2. 表示 long 类型

默认情况下你直接输入的数字总是表示 `int` 类型，要表示 `long`，在数字字面量后面加 **L**

```java
public static final long BIG_NUMBER = 1_000_000_000_000_000_000L;
```

#### 3. 表示各种进制数

**八进制**(**注意！**)

这里主要要强调和十进制的区别，Java 中，0123 **≠** 123

在数字字面量前加 `0` 表示八进制数，而不是十进制数，如果你忘了这点，很可能会搞/出事情

**二进制**(在书写 flag 和位运算时特别有用)
```java
public static final int NUMBER = 0b01110110;
```

**十六进制**
```java
public static final int NUMBER = 0xaff211;
```



## 循环

若要遍历某个数组或 List，请使用 for-each 语句而不是 for 语句

## 条件、作用域

## 数组

## 字符串

# 类 Class

## 定义一个类

**请务必**永远只在一个文件定义一个类。（无论是不是 public）

## 构造方法、初始化器

## 实例方法

## 静态方法和静态字段

如果一个类的某个方法并不需要对象的应用，请考虑将其设为静态

## 静态初始化器

## 类的组合

## 类的继承

### 继承注意事项

#### 构造方法绝不能直接或间接调用可重写的方法

父类构造方法在子类构造方法之前运行。若这样做，会使得在子类构造方法运行之前，子类中的重写方法被调用。 

如果重写方法依赖于子类构造方法执行的任何初始化，则此方法将不会按预期运行。例如：

```java
import java.time.Instant;

public class Nineteen extends Super {
    // Blank final, set by constructor
    private final Instant instant;

    Nineteen() {
        instant = Instant.now();
    }

    // Overriding method invoked by superclass constructor
    @Override
    public void overrideMe() {
        System.err.println(instant);
    }

    public static void main(String[] args) {
        Nineteen sub = new Nineteen();
        sub.overrideMe();
    }
}

class Super {
    // Broken - constructor invokes an overridable method
    Super() {
        this.overrideMe();
    }

    public void overrideMe() {
        System.out.println("Parent");
    }
}
```

你期望的输出：

```
2019-08-03T09:02:08.232943Z
2019-08-03T09:02:08.232943Z
```

实际结果：

```
null
2019-08-03T09:02:08.232943Z
```

> 解决这个问题的最好办法是，在没有想要安全地子类化的设计和文档说明的类中禁止子类化。 有两种方法禁止子类化。 两者中较容易的是声明类为 final。 另一种方法是使所有的构造方法都是私有的或包级私有的，并且添加公共静态工厂来代替构造方法。 这个方案在内部提供了使用子类的灵活性，在条目 17 中讨论过。两种方法都是可以接受的。

## 命名守则

## 类和类型、类型转换

# 方法 Method

## 值与引用

## 包装类型、装箱和拆箱

## 方法重载 Overload

## 方法重写 Override

## 参数和返回值的设计思想

### 推广你的参数！

接受接口类型而不是实现类型

# 保护级别

# 包 package

# 异常 Exception

指出，必检异常，除了 `EOFException` 此类以及利用异常编程的业务逻辑，其余都是垃圾设计

## 抛出和捕获异常

## 常用异常

| 异常 | 	使用场合 |
| -----  | ------  |
| IllegalArgumentException	| 非 null 的参数值不正确 |
| IllegalStateException	| 不适合方法调用的对象状态 |
| NullPointerException	| 在禁止使用 null 的情况下参数值为 null |
| IndexOutOfBoundsExecption	| 下标参数值越界 |
| ConcurrentModificationException	| 在禁止并发修改的情况下，检测到对象的并发修改 |
| UnsupportedOperationException	| 对象不支持用户请求的方法 |

不要直接抛出 Exception、RuntimeException、Throwable 或者 Error。因为它们是一个方法可能抛出的其他异常的超类。

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

### Enum*

#### EnumSet

当你需要描述 `flags` 或者想要使用枚举数组时、或者想要定义几个int常量描述什么东西时，优先考虑使用 `EnumSet` 代替。

```java
Set<MazhaColor> colors = EnumSet.of(MazhaColor.GREEN, MazhaColor.BLUE)
```

#### EnumMap

当你需要一个用枚举作为键的 Map 时，用它。这个时候 `EnumMap` 性能最佳。

```java
Map<MazhaType, Set<Mazha>>  mazhasByType =
    new EnumMap<>(MazhaType.class);
```

# 接口、抽象类和 Lambda 初步

## 定义一个接口

强调接口的无状态性

强调接口一开始就要定义好，发布后不要随便修改，即使是默认方法

## 两种方法实现一个接口

## 匿名类

请优先使用 Lambda 或方法引用 而不是匿名类。

## Lambda

## 默认方法与 Trait 思想

## 不要在后期随意添加默认方法

名称冲突

在默认方法的情况下，接口的现有实现类可以在没有错误或警告的情况下编译，但在运行时会失败。

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

## 并发相关的基本概念

### 原子性

即一个操作或者多个操作，要么**全部执行**并且执行的过程不会被**任何**因素*打断*或*干扰*，要么就**都不执行**。

> 原子性就像数据库里面的事务一样，他们是一个集体，同生共死。（没学过数据库事务可以忽略这句话...）

### 可见性

可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。

### 有序性

即程序执行的顺序按照代码的先后顺序执行，而不是乱序的。

```java
int i = 0;              
boolean flag = false;
i = 1;                //语句1  
flag = true;          //语句2
```

比如上面的代码中，语句1和语句2谁先执行对最终的程序结果并没有影响，那么就有可能在执行过程中，语句2*先*执行而语句1*后*执行。

## 同步简介

### 为何需要同步？

如果没有同步，同一个对象的一个线程的变化就可能**不能**被其他线程看到。

同步不仅可以阻止一个线程看到对象处于不一致的状态之中，它还可以保证进入同步方法或者同步代码块的每个线程，都能看到由同一个锁保护的之前所有的修改效果。

### 范例

lowb开发者可能觉得一般只需要写同步就够了，但很多情况下读也是需要同步的。下面是一种情况：

```java
public class StopThread {
    private static Boolean stopRequested;

    public static void main(String[] args) 
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            //注意下面
            while (!stopRequested)
            i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
```

事实上，你永远也停不下 `backgroundThread` ，因为我让你注意的那句话被优化成了这样：

```java
if (!stopRequested)
    while (true)
        i++;
```

解决此问题的办法是对 `stopRequested` 使用同步的 getter/setter 方法，或者为其添加 `volatile` 关键字

### 怎么解决同步问题？

通常使用以下方法（选一种）：

1. 如果数据不需要修改，直接让其成为只读的（废话）
2. 将可变数据限制在单个线程中
3. 当多个线程共享可变数据的时候，对读写同步

注意：除非读和写操作都被同步，否则无法保证同步能起作用。

下面所讲的，就是第三条【同步】的常用方法。

## 锁

## synchronized

## 阻塞队列 BlockingQueue

## volatile 关键字

## wait() 和 notify()

现在是 9102 年了，这节的内容已经不怎么重要了。*了解即可*

# 杂项

## 用位操作实现 Flag

尽管现在通常不推荐用位操作来实现 Flag (取而代之，使用 `EnumSet` )，但许多老项目，特别是 Android，仍然大量用到了位运算表示 Flag 

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

## 可比较 Comparable\<T\>

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

## 内置常用函数式接口



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

> 将设计良好的组件与设计不佳的组件区分开来的最重要的因素是，隐藏内部数据和其他实现细节的程度。一个设计良好的组件隐藏了它的所有实现细节，干净地将它的 API 与它的实现分离开来。然后，组件只通过它们的 API 进行通信，并且对彼此的内部工作一无所知。这一概念，被称为信息隐藏或封装，是软件设计的基本原则

### 最小化访问权限

访问权限：public > protected > 默认(package-private) > private

一句话，访问权限越低越好。

**目的**：提高协作效率，让别人一眼明白哪些是你提供的 API

### 最小化可变性

## get/set

通常不建议在 Java 直接访问属性。因为在 Java 中，我们无法控制这个属性被读写时的行为。如果后期需要进行某些变更，这会很棘手。

你应该设计 getter/setter 来访问属性，并将属性的可访问性修改为 private.

> 这样做的目的是提高项目的可维护性。像 PHP 这些可以随时修改被属性读写时的行为的语言，可以不设计 getter/setter

当然，如果这个类是你的私有 API，你从不保证这些 API 不会发生变更，那怎么做随你。

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

### 设计 private static final INSTANCE 字段

```java
public class Signleton {
    private static final Signleton INSTANCE = new Signleton();

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

> Java 9 中新增了 Cleaner 机制代替 Finalizer 机制，但这个机制仍然是不可靠的。不建议使用。

### finalize() 方法的正确用途

搞流氓的事情。典型的是防止这个对象被回收。

## 惰性加载

**注意**：除非某个字段初始化的开销比较大，否则不要使用延迟初始化

### 并发情况下的惰性加载

双重检查

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

本节仅作了解即可。或者可以*直接跳过*。

\<!\> **警告:** JNI 十分危险，除非你确实有过人的 C/C++ 能力，否则不要因为不熟悉 Java 而去使用 JNI.

使用 JNI，无外乎下面几种情况：

 * 加速算法运行
 * 与操作系统本地 API 交互
 * 防止核心算法遭逆向工程而暴露

基本使用流程如下:

### Java class

```java
public class NativeInterface {
    static {
        System.loadLibrary("JNIProject"); //只能为文件名，不含路径和扩展名
    }

    public static native String test(); //给方法带上 native 关键字即表示这是本地方法
    public native String nonStaticArray();
}
```

### 生成头文件

Java 10+: `javac -h . NativeInterface.java`
Java 旧版本: `javah -jni . NativeInterface.java`

### JVM 命令

指定库路径: `-Djava.library.path=./JNI/JNIProject/x64/Debug`

### C++

```c++
#include "NativeInterface.h"
#include <cstdio>

int main()
{
	return 0;
}

JNIEXPORT jstring JNICALL Java_NativeInterface_test(JNIEnv* env, jclass cls) 
{
	printf("%s", "jni ok\n");
	printf("%d", 666);
	return env->NewStringUTF("yooooo STATIC");
}

JNIEXPORT jstring JNICALL Java_NativeInterface_nonStaticArray(JNIEnv* env, jobject obj)
{
	return env->NewStringUTF("Non static");
}
```

## Kotlin 神教!

本节仅作了解即可。或者可以*直接跳过*。

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