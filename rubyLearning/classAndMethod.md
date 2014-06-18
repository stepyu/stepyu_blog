classAndMethod
========
### 面向对象特征：
* 封装
* 继承
* 多态

### 封装 
1. 类名首字母大写
1. 实例变量用@开头
1. 方法名和参数名应该用一个小写字母开头或者用一个下划线开头

例子

    class Person
    def initialize( name, age=18 )
    @name = name
    @age = age
    @motherland = "China"
    end #初始化方法结束
	def talk
	puts "my name is "+@name+", age is "+@age.to_s
	if @motherland == "China"
	puts "I am a Chinese."
	else
	puts "I am a foreigner."
	end
	end # talk 方法结束
	attr_writer :motherland
	end # Person 类结束
	p1=Person.new("kaichuan",20)
	p1.talk
	p2=Person.new("Ben")
	p2.motherland="ABC"
	p2.talk
* initialize 是初始化方法，相当于 Java 的构造器

* attr_writer :motherland相当于

		def motherland=(value)
			return @motherland =value
		end
* attr_ reader :motherland 相当于

		def motherland
			return @motherland
		end
* attr_accessor :motherland 相当于 attr_reader:motherland； attr_writer :motherland
## 继承

例子

		class Student < Person
			def talk
				puts "I am a student. my name is "+@name+", age is "+@age.to_s
			end # talk 方法结束
		end # Student 类结束
		p3=Student.new("kaichuan",25); 	p3.talk
		p4=Student.new("Ben"); p4.talk
		
* 用“ < ”表示 Student 类是 Person 类的子类。Person 类的一切，Student 类都能
继承。

* Student 类重写了 talk 方法，所以我们看到了不同的运行结果。子类继
承父类的时候，除了重写方法；也可以添加一些新的方法；或是增强父类的方法(用
关键字 super 指明)

*  new 方法。Person 类没有定义 new 方法，为什么生成 Person 类的
具体实例要用 new？ Ruby 语言已经定义了一个类 Object，如果你在定义新类的时
候，没有指明新类的父类，那么，Ruby 解释器认为，新类的父类是 Object 类。类
Object 含有 new 方法、initialize 方法…只要你不重写这些方法，你就自然在使用类
Object 的方法。

* 这里没
有 C++的析构函数，也没有 Java 的 finalize( ) 方法，Ruby 语言内建了一个比 Java
更灵巧的垃圾收集器，当某个实例不再与其它代码交互了，垃圾收集器就回收它占
用的系统资源，这个实例自然也就不存在了。垃圾收集器是一段代码，它作它的工
作，自动地、不知疲倦地随着系统一同运作。

## 多态

不同的子类继承一个父类，不仅子类和父类的行为有变异，而且子类彼此的行
为也有差异，这就是多态。

例子：

		class Worker < Person
			def talk
				puts "I am a worker. my name is "+@name+", age is "+@age.to_s
			end # talk 方法结束
		end # Worker 类结束
		p5=Worker.new("kaichuan",30);p5.talk
		p6=Worker.new("Ben");p6.talk
		
* Worker 类与 Student 类同样继承自 Person 类，亲缘关系是兄弟，当他们 talk
时，能准确表明自己身份，因为他们都重写了各自的 talk 方法。

* Ruby 语言，只有重写（override），没有其它语言具有的严格意义上的重载
（overload）。

## ruby class相关的特殊用法

例子：

		class Person
			def say
			 puts "hello world"
			end
		end
		tom=Person.new
		tom.say
* 特定方法的对象

在Ruby里，我们可以为一个对象单独定义方法

		class Person
			def say
			 puts "hello world"
			end
		end
		tom=Person.new
		def tom.bye
			puts "Goodbye"
		end
		tom.say
		tom.bye

* 重定义方法

从下面代码可以看出，后面的定义会覆盖前面的定义

		class Person
			def say
			 puts "hello world"
			end
			def say
			 puts "how are you"
			end
		end
		tom=Person.new
		tom.say
		
* 重新打开类

Ruby里我们可以再打开一个类，向这类添加方法，有点像C#里的分部类，但不用加特别标记。我们一般不要拆开类的定义，因为那样不好理解，拆开类的一个原因是将它们分散到多个文件里。

		class Person
			def say
			 puts "hello world"
			end
		end
		class Person
			def bye
			 puts "bye"
			end
		end
		tom=Person.new
		tom.say
		tom.bye
		
## 类方法

类是特殊的对象，是唯一可以创建新对象的一类对象
定义是，在方法前加上类名

		class Person
		  attr_accessor :age
		  def Person.oldest(*persons)
		    persons.sort_by{|x|x.age}.last.age
		  end
		end
		tom=Person.new
		tom.age=20
		jack=Person.new
		jack.age=25
		angel=Person.new
		angel.age=22
		puts Person.oldest(tom,jack,angel)
		
类方法有两种调用方式：
	
	* Person.oldest()
	* Person::oldest()

Ruby控制语句[http://www.cnblogs.com/cnblogsfans/archive/2009/02/05/1384944.html]()
		
		
