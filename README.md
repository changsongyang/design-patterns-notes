> 设计模式分为三种类型，23种

[TOC]

## 创建型模式

### 使用单例模式防止类重复创建
- 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法(静态方法)
- 比如Hibernate的SessionFactory，它充当数据存储源的代理，并负责创建Session 对象。 SessionFactory并不是轻量级的，一般情况下，一个项目通常只需要一个SessionFactory就够，这是就会使用到单例模式

#### 单例模式有八种方式

1) 饿汉式(静态常量)
2) 饿汉式（静态代码块）
3) 懒汉式(线程不安全)
4) 懒汉式(线程安全，同步方法)
5) 懒汉式(线程安全，同步代码块)
6) 双重检查
7) 静态内部类
8) 枚举

#### 饿汉式(静态常量)

```
public class Single1 {
    private  Single1(){}
    private  static  Single1 single=new Single1();
    public static   Single1 getSingleton(){
        return  single;
    }
}
```

#### DCL 双重锁检查懒汉式 单列模式

```
public class SingleDcl {
    private  SingleDcl(){}
    private  volatile  static    SingleDcl single;
    public  SingleDcl getSingle(){
        if (single==null){
            synchronized(SingleDcl.class){
                if (single==null){
                    single=new SingleDcl();
                }
            }
        }
        return  single;
    }
}
```

#### 静态内部类-单例模式
- 这种方式采用了类装载的机制来保证初始化实例时只有一个线程
- 静态内部类方式在Single2类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingleInstance类，从而完成Singleton的实例化
- 类的静态属性只会在第一次加载类的时候初始化，所以在这里， JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的
- 避免了线程不安全，利用静态内部类特点实现延迟加载，效率高

```
public class Single2 {
    private  Single2 (){}

    private  static  class SingleInstance{
        private  static  final  Single2 INTEANCE=new Single2();
    }
    public  static  Single2 getInstance(){
        return  SingleInstance.INTEANCE;
    }
}
```
#### 枚举类-实现单例模式
- 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
- Effective Java作者Josh Bloch 提倡的方式

```
public enum  SingletinEnum {
    INSTANCE; //属性
    public void sayOK() {
        System.out.println("ok~");
    }
}
```

#### 单例模式注意事项和细节说明
- 单例模式保证了 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
- 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new
- 单例模式使用的场景：需要频繁的进行创建和销毁的对象、创建对象时耗时过多或耗费资源过多(即：重量级对象)， 但又经常用到的对象、工具类对象、频繁访问数 据库或文件的对象(比如数据源、 session工厂等)


### 工厂模式(简单工厂模式)
- 定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行
- 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象

> 优点：
- 1、一个调用者想创建一个对象，只要知道其名称就可以了。
- 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 
- 3、屏蔽产品的具体实现，调用者只关心产品的接口。
  
> 缺点
- 每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，
- 同时也增加了系统具体类的依赖。这并不是什么好事。    
      
> 使用场景    
- 1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。
- 2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
- 3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。


![简单工厂.png](http://ww1.sinaimg.cn/large/0068QeGHgy1g9rphv9432j30hf056mz7.jpg)


```
// 课程标准
public interface ICourse {
    /** 录制视频 */
    public void record();
}

// 创建一个 Java课程的实现
public class JavaCourse implements ICourse {
    public void record() {
        System.out.println("录制 Java 课程");
    }
}

// 创建一个Python课程的实现
public class PythonCourse implements ICourse {
    public void record() {
        System.out.println("录制 Python 课程");
    }
}

// 工厂类
public class CourseFactory {
    public ICourse create(String name){
        if("java".equals(name)){
            return new JavaCourse();
        }else if("python".equals(name)){
            return new PythonCourse();
        }else {
            return null;
        }
    }
}

//  测试
public static void main(String[] args) {
    CourseFactory factory = new CourseFactory();
    factory.create("java");
}

// 采用反射技术优化
public ICourse create(Class<? extends ICourse> clazz){
    try {
        if (null != clazz) {
            return clazz.newInstance();
        }
    }catch (Exception e){
        e.printStackTrace();
    } 
    return null;
}

public static void main(String[] args) {
    CourseFactory factory = new CourseFactory();
    ICourse course = factory.create(JavaCourse.class);
    course.record();
}

```
      
      
### 工厂模式(工厂方法模式)
- 定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。
- 更符合开-闭原则: 新增一种产品时，只需要增加相应的具体产品类和相应的工厂子类即可(简单工厂模式需要修改工厂类的判断逻辑)
- 符合单一职责原则: 每个具体工厂类只负责创建对应的产品 (简单工厂中的工厂类存在复杂的switch逻辑判断)
- 工厂模式可以说是简单工厂模式的进一步抽象和拓展，在保留了简单工厂的封装优点的同时，让扩展变得简单，让继承变得可行，增加了多态性的体现。

![工厂方法模式.png](http://ww1.sinaimg.cn/large/0068QeGHgy1g9rpjjchhgj30hr06owh8.jpg)


```
// 父工厂接口
public interface ICourseFactory {
    ICourse create();
}

// 分别创建两个子工厂

public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
public class PythonCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new PythonCourse();
    }
}

// 测试
public static void main(String[] args) {
    ICourseFactory factory = new PythonCourseFactory();
    ICourse course = factory.create();
    course.record();
    
    factory = new JavaCourseFactory();
    course = factory.create();
    course.record();
}

```




### 工厂模式(抽象工厂模式)
- 抽象工厂模式是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
- 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
- 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。

```
// 视频接口
public interface IVideo {
    void record();
}
// 笔记接口
public interface INote {
    void edit();
}
// 抽象工厂类
public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}

// 创建Java笔记族，Java视频类
public class JavaVideo implements IVideo {
    public void record() {
        System.out.println("录制 Java 视频");
    }
}
public class JavaNote implements INote {
    public void edit() {
        System.out.println("编写 Java 笔记");
    }
}

// 创建Java产品的具体工厂 
public class JavaCourseFactory implements CourseFactory {
    public INote createNote() {
        return new JavaNote();
    } 
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
// 创建其他语言的产品的具体工厂
省略.....

// 测试
public static void main(String[] args) {
    JavaCourseFactory factory = new JavaCourseFactory();
    factory.createNote().edit();
    factory.createVideo().record();
}
```

### 使用原型模式创建新对象
- 原型模式(Prototype模式)是指：用原型实例指定创建对象的种类，并且通过拷贝这些原型， 创建新的对象
- 原型模式是一种创建型设计模式，允许一个对象再创建另外一个可定制的对象，无需知道如何创建的细节
- 工作原理是:通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建，即 对象.clone()
- 形象的理解：孙大圣拔出猴毛， 变出其它孙大圣

> 浅拷贝和深拷贝

- 对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性值复制一份给新的对象。
- 对于数据类型是引用数据类型的成员变量,比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，也就是只是将该成员变量的引用值（内存地址）复制一份给新的对象。
- 因为实际上两个对象的该成员变量都指向同一个实例。在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值
- 深拷贝实现方式1：重写clone方法来实现深拷贝
- 深拷贝实现方式2：通过对象序列化实现深拷贝(推荐)

> 原型模式的注意事项和细节

- 创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率
- 不用重新初始化对象，而是动态地获得对象运行时的状态
- 如果原始对象发生变化(增加或者减少属性)，其它克隆对象的也会发生相应的变化，无需修改代码
- 缺点：需要为每一个类配备一个克隆方法，这对全新的类来说不是很难，但对已有的类进行改造时，需要修改其源代码，违背了ocp原则

```
// 浅拷贝
public class Sheep  implements  Cloneable{
    private String name;
    public Sheep  friend; // 是对象 克隆时会自动处理， 默认浅拷贝
    
    @Override
    protected Object clone()  {
            Sheep sheep=null;
            try {
                sheep=(Sheep)super.clone();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return sheep;
    }
}

// 深拷贝

public class DeepProtoType implements Serializable, Cloneable {
    public String name; 
    public DeepCloneableTarget deepCloneableTarget;
    public DeepProtoType() {
        super();
    }
    
    //深拷贝 - 方式 1 使用clone 方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成对基本数据类型(属性)和String的克隆
        deep = super.clone();
        //对引用类型的属性，进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType)deep;
        deepProtoType.deepCloneableTarget  = (DeepCloneableTarget)deepCloneableTarget.clone();
        return deepProtoType;
    }
}
```


### 建造者模式
- 建造者模式（Builder Pattern） 又叫生成器模式，是一种对象构建模式
- 它可以将复杂对象的建造过程抽象出来（抽象类别），使这个抽象过程的不同实现方法可以构造出不同表现（属性）的对象
- 建造者模式 是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建它们，用户不需要知道内部的具体构建细节
- java.lang.StringBuilder中的建造者模式即充当了指挥者角色，同时充当了具体的建造者，建造方法的 实现是由 AbstractStringBuilder 完成, 而StringBuilder 继承了 AbstractStringBuilder
- 建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间 的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制
- 如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化， 导致系统变得很庞大，因此在这种情况下，要考虑是否选择建造者模式.



## 结构型模式

### 适配器模式
- 适配器模式(Adapter Pattern)将某个类的接口转换成客户端期望的另一个接口表 示，主的目的是兼容性，让原本因接口不匹配不能一起工作的两个类可以协同 工作。其别名为包装器(Wrapper)
- 主要分为三类:类适配器模式、对象适配器模式、接口适配器模式
- 现实生活中的适配器例子:泰国插座用的是两孔的(欧标)，可以买个多功能转换插头 (适配器) ，这样就可以 使用了。


#### 类适配器模式介绍
- 基本介绍:Adapter类，通过继承 src类，实现 dst 类接口，完成src->dst的适配。
- 以生活中充电器的例子来讲解适配器，充电器本身相当于Adapter，220V交流电 相当于src (即被适配者)，我们的目dst(即 目标)是5V直流电
- java是单继承机制，所以类适配器需要继承src类这一点算是一个缺点, 因为这要 求dst必须是接口，有一定局限性;src类的方法在Adapter中都会暴露出来，也增加了使用的成本。由于其继承了src类，所以它可以根据需求重写src类的方法，使得Adapter的灵活性增强了。


#### 对象适配器模式
- 基本思路和类的适配器模式相同，只是将Adapter类作修改，不是继承src类，而 是持有src类的实例，以解决兼容性的问题。 即:持有 src类，实现 dst 类接口， 完成src->dst的适配
- 根据“合成复用原则”，在系统中尽量使用关联关系来替代继承关系。
- 对象适配器模式是适配器模式常用的一种

#### 接口适配器模式
- 当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供 一个默认实现(空方法)，那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求

#### 适配器模式在 SpringMVC 框架应用的源码剖析
- SpringMvc中的HandlerAdapter,就使用了适配器模式
- Spring定义了一个适配接口，使得每一种Controller有一种对应的适配器实现类
- 适配器代替controller执行相应的方法,扩展Controller 时，只需要增加一个适配器类就完成了SpringMVC的扩展了,

```
public class DispatcherServlet extends FrameworkServlet { // 通过HandlerMapping来映射Controller
mappedHandler = getHandler(processedRequest); //获取适配器

HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
// 通过适配器调用controller的方法并返回ModelAndView
mv = ha.handle(processedRequest, response, mappedHandler.getHandler()); }
```


### 桥接模式 
- 桥接模式(Bridge模式)是指:将实现与抽象放在两个不同的类层次中，使两个层 次可以独立改变。
- Bridge模式基于类的最小设计原则，通过使用封装、聚合及继承等行为让不同的类承担不同的职责。它的主要特点是把抽象(Abstraction)与行为实现 (Implementation)分离开来，从而可以保持各部分的独立性以及应对他们的功能 扩展
- 生活案列:对不同手机类型的不同品牌实现操作编程(比如:开机、关机、上网，打电话等) 
- Jdbc的Driver接口，如果从桥接模式来看，Driver就是一个接口，下面可以有MySQL的Driver，Oracle的Driver，这些就可以当做实现接口类

#### 桥接模式的注意事项和细节
- 实现了抽象和实现部分的分离，从而极大的提供了系统的灵活性，让抽象部分和实 现部分独立开来，这有助于系统进行分层设计，从而产生更好的结构化系统。
- 对于系统的高层部分，只需要知道抽象部分和实现部分的接口就可以了，其它的部 分由具体业务来完成
- 桥接模式替代多层继承方案，可以减少子类的个数，降低系统的管理和维护成本
- 桥接模式的引入增加了系统的理解和设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计和编程
- 桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围有一定的局限性，即需要有这样的应用场景。

#### 桥接模式其它应用场景
- 对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥 接模式尤为适用.
- 常见的应用场景:JDBC驱动程序，银行转账系统：转账分类: 网上转账，柜台转账，AMT转账 转账用户类型:普通用户，银卡用户，金卡用户..。
- 消息类型:即时消息，延时消息 消息分类:手机短信，邮件消息，QQ消息...

### 装饰模式
- 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装
- 这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
- 装饰（Decorator）模式的主要优点有：采用装饰模式扩展对象的功能比采用继承方式更加灵活。可以设计出多个不同的具体装饰类，创造出多个不同行为的组合。
- 主要缺点是：装饰模式增加了许多子类，如果过度使用会使程序变得很复杂

#### 应用实例： 
- 1、孙悟空有 72 变，当他变成"庙宇"后，他的根本还是一只猴子，但是他又有了庙宇的功能。 
- 2、不论一幅画有没有画框都可以挂在墙上，但是通常都是有画框的，并且实际上是画框被挂在墙上。在挂在墙上之前，画可以被蒙上玻璃，装到框子里；这时画、玻璃和画框形成了一个物体。

#### 装饰模式主要包含以下角色。
- 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
- 具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
- 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
- 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。

#### 装饰者模式在 JDK 应用的源码分析
- Java 的 IO 结构，FilterInputStream 就是一个装饰者

```
//1. InputStream 是抽象类, 类似我们前面讲的 Drink
//2. FileInputStream 是 InputStream 子类，类似我们前面的 DeCaf, LongBlack
//3. FilterInputStream 是 InputStream 子类:类似我们前面 的 Decorator 修饰者
//4. DataInputStream 是 FilterInputStream 子类，具体的修饰者，类似前面的 Milk, Soy 等 
//5. FilterInputStream 类 有 protected volatile InputStream in; 即含被装饰者
//6. 分析得出在 jdk 的 io 体系中，就是使用装饰者模式
DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt")); System.out.println(dis.read());
dis.close();
```

### 组合模式
- 组合模式又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。
- 组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；


### 外观模式
- 外观模式（Facade Pattern）隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。这种类型的设计模式属于结构型模式，
- 这种模式涉及到一个单一的类，该类提供了客户端请求的简化方法和对现有系统类方法的委托调用。
- 应用实例： 1、去医院看病，可能要去挂号、门诊、划价、取药，让患者或患者家属觉得很复杂，如果有提供接待人员，只让接待人员来处理，就很方便。 2、JAVA 的三层开发模式。
- 优点： 1、减少系统相互依赖。 2、提高灵活性。 3、提高了安全性。
- 缺点：不符合开闭原则，如果要改东西很麻烦，继承重写都不合适。
- MyBatis 中的Configuration 去创建MetaObject 对象使用到外观模式

### 享元模式
- 享元模式主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。
- 主要解决：在有大量对象时，有可能会造成内存溢出，我们把其中共同的部分抽象出来，如果有相同的业务请求，直接返回在内存中已有的对象，避免重新创建。
- 何时使用： 1、系统中有大量对象。 2、这些对象消耗大量内存。 3、这些对象的状态大部分可以外部化。
- 应用实例： 1、JAVA 中的 String，如果有则返回，如果没有则创建一个字符串保存在字符串缓存池里面。 2、数据库的数据池。
- 优点：大大减少对象的创建，降低系统的内存，使效率提高。
- 缺点：提高了系统的复杂度，需要分离出外部状态和内部状态，而且外部状态具有固有化的性质，不应该随着内部状态的变化而变化，否则会造成系统的混乱。

#### 生活案例需求
- 小型的外包项目，给客户A做一个产品展示网站， 客户A的朋友感觉效果不错，也希望做这样的产品展示网站，但是要求都有些不同：
- 有客户要求以新闻的形式发布，有客户人要求以博客的形式发布，有客户希望以微信公众号的形式发布


### 使用代理模式解耦扩展方法功能
- 代理模式:为一个对象提供一个替身，以控制对这个对象的访问。即通过代理对象访问目标对象.这样做的好处 是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能。
- 被代理的对象可以是远程对象、创建开销大的对象或需要安全控制的对象
- 代理模式有不同的形式, 主要有三种 静态代理、动态代理 (JDK 代理、接口代理)和 Cglib 代理 (可以在内存动态的创建对象，而不需要实现接口， 他是属于动态代理的范畴)。

#### 静态代理
- 静态代理在使用时,需要定义接口或者父类,被代理对象(即目标对象)与代理对象一起实现相同的接口或者是继 承相同父类
- 优点:在不修改目标对象的功能前提下, 能通过代理对象对目标功能扩展
- 缺点:因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类。一旦接口增加方法,目标对象与代理对象都要维护

#### 动态代理
- 代理对象,不需要实现接口,但是目标对象要实现接口,否则不能用动态代理
- 代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象
- 动态代理也叫做:JDK代理、接口代理

#### Cglib 代理
- Cglib 代理也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能扩展, 有些书也将 Cglib 代 理归属到动态代理。
- Cglib 是一个强大的高性能的代码生成包,它可以在运行期扩展 java 类与实现 java 接口.它广泛的被许多 AOP 的 框架使用,例如 Spring AOP,实现方法拦截


## 行为型模式
### 模版方法模式
- 模板方法模式又叫模板模式,在一个抽象类公开定义了执行 它的方法的模板。它的子类可以按需要重写方法实现,但调用将以抽象类中定义的方式进行
- 简单说,模板方法模式定义一个操作中的算法的骨架,而将一些步骤延迟到子类中,使得子类可以不改变一 个算法的结构,就可以重定义该算法的某些特定步骤
- Spring IOC 容器初始化时运用到的模板方法模式

#### 生活案例
- 制作豆浆的流程选材--->添加配料--->浸泡--->放到豆浆机打碎
- 通过添加不同的配料,可以制作出不同口味的豆浆
- 选材、浸泡和放到豆浆机打碎这几个步骤对于制作每种口味的豆浆都是一样的

#### 模板方法模式的注意事项和细节
- 基本思想是:算法只存在于一个地方,也就是在父类中,容易修改。需要修改算法时,只要修改父类的模板方 法或者已经实现的某些步骤,子类就会继承这些修改
- 现了最大化代码复用。父类的模板方法和已实现的某些步骤会被子类继承而直接使用。
- 既统一了算法,也提供了很大的灵活性。父类的模板方法确保了算法的结构保持不变,同时由子类提供部分步骤的实现
- 该模式的不足之处:每一个不同的实现都需要一个子类实现,导致类的个数增加,使得系统更加庞大
- 一般模板方法都加上final关键字,防止子类重写模板方法.
- 模板方法模式使用场景:当要完成在某个过程,该过程要执行一系列步骤,这一系列的步骤基本相同,但其个别步骤在实现时 可能不同,通常考虑用模板方法模式来处理

### 命令模式
- 令模式(CommandPattern):在软件设计中,我们经常需要向某些对象发送请求,但是并不知道请求的接收 者是谁,也不知道被请求的操作是哪个
- 命名模式使得请求发送者与请求接收者消除彼此之间的耦合,让对象之间的调用关系更加灵活,实现解耦。
- 在命名模式中,会将一个请求封装为一个对象,以便使用不同参数来表示不同的请求(即命名),同时命令模式也支持可撤销的操作
- 通俗易懂的理解:将军发布命令,士兵去执行。其中有几个角色:将军(命令发布者)、士兵(命令的具体执行者)、命令(连接将军和士兵)。
- 优点： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统中去。
- 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。
- 使用场景：认为是命令的地方都可以使用命令模式，比如： 1、GUI 中每一个按钮都是一条命令。 2、模拟 CMD。
- 注意事项：系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作，也可以考虑使用命令模式，见命令模式的扩展。


### 使用策略模式优化if-else判断
- 是指定义了算法家族、分别封装起来，让它们之间可以互相替换，此模式让算法的变化不会影响到使用算法的用户
- 常见的if else多重判断就可以使用策略模式优化

```
 // 使用策略模式-发送消息策略接口
public interface Strategy {
    boolean sendMsg(String name); //发送消息
}

 // 支付确认消息策略
public class ConfirmMsgStrategy implements Strategy {
    @Override
    public boolean sendMsg(String name) {
        System.out.println("支付确认消息通知消息: "+name);
        return true;
    }
}

// 订单服务通知消息策略
public class OrderMsgStrategy implements Strategy {
    @Override
    public boolean sendMsg(String name) {
        System.out.println("发送订单服务通知消息: "+name);
        return true;
    }
}

 // 策略模式的上下文  执行策略的方法
public class StrategyContext {
    private Strategy strategy;
    public StrategyContext(Strategy strategy){
        this.strategy=strategy;
    }
    public  boolean execute(String name){
        return  strategy.sendMsg(name);
    }
}

// 枚举类 息类型
public enum MsgTypeEnum {
    PAYORDER(1, "支付订单消息"),
    CONFIRM(2, "确认订单消息");
}

// 策略处理器
public class MsgStrategyProcessor {
    private  static Map<MsgTypeEnum, Strategy> STRATEGY_MAP=new HashMap<>();
    //  初始化不同的消息类型key  此处可以结合Spring扫描注解自动注入
    static {
        STRATEGY_MAP.put(MsgTypeEnum.PAYORDER,newOrderMsgStrategy());
        STRATEGY_MAP.put(MsgTypeEnum.CONFIRM,new ConfirmMsgStrategy());
    }
    private  MsgStrategyFactory(){}
    public  static Strategy getStrategy(int msgKey){
       return  STRATEGY_MAP.get(MsgTypeEnum.getByCode(msgKey));
    }
}

//根据传入消息的不同类 执行不同策略 
 public static void main(String[] args) {
        StrategyContext context=new StrategyContext(MsgStrategyFactory.getStrategy(1));
        context.execute("aaaa");
   }
```

### 访问者模式
### 迭代器模式
### 观察者模式
### 中介者模式
### 备忘录模式
### 解释器模式（Interpreter模式）
### 状态模式

### 职责链模式(责任链模式)
- 为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止
- 在责任链模式中，客户只需要将请求发送到责任链上即可，无须关心请求的处理细节和请求的传递过程，所以责任链将请求的发送者和请求的处理者解耦了。

#### 职责链模式的注意事项和细节
- 性能会受到影响,特别是在链比较长的时候,因此需控制链中最大节点数量,一般通过在Handler中设置一个最大节点数量,在 setNext()方法中判断是否已经超过阀值,超过则不允许该链建立,避免出现超长链无意识地 破坏系统性能


# 参考链接
- https://www.runoob.com/design-pattern