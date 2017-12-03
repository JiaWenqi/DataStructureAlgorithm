//对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
//给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
/*
测试样例：
["abc","de"],2
"abcde"
*/
public class splice{
	public class MyComparator implements Comparator{
		@Override
		public int compare(String a, String b){
			return (a+b).compareTo(b+a);
		}
	}
	public String findSmallest(String[] strs, int n){
		if(strs == null || n == 0){
			return "";
		}
		//根据新的比较方式排序
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for(int i =0; i < strs.length; i++){
			res += strs[i];
		}
		return res;
	}

/*Java中@Override的作用
@Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处: 
1、可以当注释用,方便阅读；
2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法。
 
举例：在重写父类的onCreate时，在方法前面加上@Override 系统可以帮你检查方法的正确性。
@Override
public void onCreate(Bundle savedInstanceState)
{…….}
这种写法是正确的，如果你写成：
@Override
public void oncreate(Bundle savedInstanceState)
{…….}
编译器会报如下错误：The method oncreate(Bundle) of type HelloWorld must override or implement a supertype method，以确保你正确重写onCreate方法（因为oncreate应该为onCreate）。而如果你不加@Override，则编译器将不会检测出错误，而是会认为你为子类定义了一个新方法：oncreate
*/

/*
extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承，JAVA中不支持多重继承，但是可以用接口来实现，这样就要用到implements，继承只能继承一个类，但implements可以实现多个接口，用逗号分开就行了

比如
class A extends B implements C,D,E
一个类通过关键字implements声明自己使用一个或者多个接口。在类的声明中，通过关键字extends来创建一个类的子类。

接口实现的注意点：

a.实现一个接口就是要实现该接口的所有的方法(抽象类除外)。
b.接口中的方法都是抽象的。
c.多个无关的类可以实现同一个接口，一个类可以实现多个无关的接口。
extends与implements的不同

 extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承，JAVA中不支持多重 继承，但是可以用接口来实现，这样就要用到implements，继承只能继承一个类，但implements可以实现多个接口，用逗号分开就行了
比如
class A extends B implements C,D,E

//
   一个类通过关键字implements声明自己使用一个或者多个接口。在类的声明中，通过关键字extends来创建一个类的子类。
class 子类名 extends 父类名 implenments 接口名
{...

}

===========================================================

A a = new B(); 结果a是一个A类的实例，只能访问A中的方法，那么又和A a = new A();有什么区别呢？
==========================================================
class B extends A
继承过后通常会定义一些父类没有的成员或者方法。
A a = new B();
这样是可以的，上传。
a是一个父类对象的实例，因而不能访问子类定义的新成员或方法。
==========================================================
假如这样定义：
class A{
int i;
void f(){}
}
class B extends A{
int j;
void f(){}//重写
void g(){}
}
然后：
B b = new B();
b就是子类对象的实例，不仅能够访问自己的属性和方法，也能够访问父类的属性和方法。诸如b.i,b.j,b.f(),b.g()都是合法的。此时 b.f()是访问的B中的f()
A a = new B();
a虽然是用的B的构造函数，但经过upcast，成为父类对象的实例，不能访问子类的属性和方法。a.i,a.f()是合法的，而a.j,a.g()非 法。此时访问a.f()是访问B中的f()
==========================================================
A a = new B(); 这条语句，实际上有三个过程：
(1) A a;
将a声明为父类对象，只是一个引用，未分配空间
(2) B temp = new B();
通过B类的构造函数建立了一个B类对象的实例，也就是初始化
(3) a = (A)temp;
将子类对象temp转换为父类对象并赋给a，这就是上传(upcast)，是安全的。
经过以上3个过程，a就彻底成为了一个A类的实例。
子类往往比父类有更多的属性和方法，上传只是舍弃，是安全的；而下传(downcast)有时会增加，通常是不安全的。
*/



