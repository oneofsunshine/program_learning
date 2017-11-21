**输出** `,`连接两输出,位置补空格  
`print '100 + 200 =', 100 + 200`  
**输入** `var = raw_input('text');`  
`raw_input()`以字符串形式返回  
**转义字符**`\`  
允许`r''`表示`''`内部字符默认*不转义*  
**布尔值** `True` `False`  
**运算** `and` `or` `not`  
##### 分支 
```
if x:
    print 'True'
```
x 非零数值、非空字符串、非空list等，判断为`True`  
```
if age >= 18:
    print 'adult'
elfi age >= 6:
    print 'teenager'
else:
    print 'kid'
```
##### 循环  
Python的循环有两种，一种是`for...in`循环，依次把`list`或`tuple`中的每个元素迭代出来，example：
```
names = ['Michael', 'Bob', 'Tracy']
for name in names:
    print name
```
`range()`函数，可以生成一个整数序列，比如`range(5)`生成的序列是*从0开始小于5的整数*  
第二种循环是`while`循环，只要条件满足，就不断循环，条件不满足时退出循环。比如我们要计算100以内所有奇数之和，可以用while循环实现：  
```
sum = 0
n = 99
while n > 0:
    sum = sum + n
    n = n - 2
print sum
```
**空值** `None`  
通常用全部大写的变量表示常量 没有保证常量不被修改的机制  
`ord('char')` 字母转换为数字  
`chr(int)` 数字转换成字母  
`u'中'` `u'\u4e2d'`只能是**`Unicode`**编码  
把`u'xxx'`转换为`utf-8`编码 `u'中文'.encode('utf-8')`  
把`utf-8`编码表示的字符串转换为Unicode字符串 `'xxx'.decode('utf-8')`  
`len()`函数可以返回字符串长度  
##### 格式化
`%s` 表示字符串代替  
`%d` 表示整数代替  
`%f` 浮点数  
`%x` 十六进制整数  
**用法**  
```
'Hello, %s' % 'world'
'Hi, %s, you have $%d.' % ('Michael', 10000)
```
格式化整数和浮点数还可以指定是否补0和整数与小数的位数：  
```
'%2d-%02d' % (3, 1)
'%.2f' % 3.1415926
```
对于`Unicode`字符串，用法完全一样，但最好确保替换的字符串也是`Unicode`字符串:`u'Hi, %s' % u'Michael'`  
字符串里面的`%`是一个普通字符*需要转义*，用`%%`来表示一个`%`  
Python内置的一种数据类型是列表：`list`。list是一种有序的集合，可以随时添加和删除其中的元素。**索引**是从`0`开始，还可以用`-1`做索引，直接获取**最后一个元素**  
`classmates.append('Adam')` 可以往`list`中**追加**元素到末尾：
也可以把元素插入到指定的位置，比如索引号为1的位置：`classmates.insert(1, 'Jack')`  
要删除`list`末尾的元素，用`pop()`方法：`classmates.pop()`  
要删除指定位置的元素，用`pop(i)`方法，其中i是索引位置  
`list`元素也可以是另一个`list`  
另一种有序列表叫元组：`tuple`。tuple和list非常类似，但是tuple一旦初始化就不能修改  
只有一个元素的时候元素后加，`tuple`中的`list`内容可`pop`和`append`和修改值  
Python内置了字典：`dict`的支持，dict全称dictionary，在其他语言中也称为map，使用 **`键-值（key-value）`** 存储，具有极快的查找速度。  
```
>>> d = {'Michael': 95, 'Bob': 75, 'Tracy': 85}
>>> d['Michael']
95
```
添加元素 `d['Adam'] = 67` 先搜索， 没有的话插入  
两种方法判断`key`是否存在 'Thomas' in d `d.get('Thomas')`/`d.get('Thomas', -1)`  
*删除*一个`key`，对应的`value`也会删除 `d.pop('Bob')`  
`dict`的`key`必须是不可变对象 在Python中，*字符串*、*整数*等都是不可变的，因此，可以放心地作为`key`。而`list`是可变的，就不能作为key  
`set`和`dict`类似，也是一组`key`的集合，但*不存储*`value`。由于key不能重复，所以，在`set`中，*没有重复*的`key`。无序的  
要创建一个set，需要提供一个list作为输入集合：
```
>>> s = set([1, 2, 3])
>>> s
set([1, 2, 3])
```
==注意==，传入的参数`[1, 2, 3]`是一个`list`，而显示的`set([1, 2, 3])`只是告诉你这个`set`内部有`1`，`2`，`3`这3个元素，显示的`[]`*不表示*这是一个list。  
通过`add(key)`方法可以*添加元素*到`set`中，可以重复添加，但不会有效果：  
通过`remove(key)`方法可以*删除*元素：  
`set`可以看成数学意义上的无序和无重复元素的集合，因此，两个set可以做数学意义上的交集、并集等操作：  
```
>>> s1 = set([1, 2, 3])
>>> s2 = set([2, 3, 4])
>>> s1 & s2
set([2, 3])
>>> s1 | s2
set([1, 2, 3, 4])
```
用`sort`排序  
*比较*函数`cmp(x, y)`就需要两个参数，如果`x<y`，返回`-1`，如果`x==y`，返回`0`，如果`x>y`，返回`1`   
求*绝对值*的函数`abs`  
*数据类型转换* `int()`函数可以把其他数据类型转换为整数   
函数定义def  
`def my_abs(x):`  
`return None` 可以简写为`return`  
如果想定义一个什么事也不做的空函数，可以用`pass`语句：
```
def nop():
    pass
```
`pass`可以用来作为*占位符*，比如现在还没想好怎么写函数的代码，就可以先放一个pass，让代码能运行起来  
##### 参数检查  
调用函数时，如果*参数个数不对*，Python解释器会自动检查出来，并抛出`TypeError`  
但是如果*参数类型不对*，Python解释器就*无法检查*   
函数可以返回多个值 返回值是一个`tuple`可以*省略括号*  
默认参数*缺省*值  
*必选*参数*在前*，*默认*参数*在后*，*否则*Python的解释器*会报错*    
当函数有多个参数时，把*变化大的参数放前面*，*变化小的参数放后面*。++变化小的参数就可以作为默认参数++  
当不按顺序提供部分默认参数时，需要把参数名写上。比如调用enroll('Adam', 'M', city='Tianjin')
定义默认参数要牢记一点：默认参数必须指向不变对象！
可变参数就是传入的参数个数是可变的
可以把参数作为一个list或tuple传进来
把函数的参数改为可变参数：
```
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum
```
在函数内部，参数`numbers`接收到的是一个`tuple`  
允许在`list`或`tuple`前面加一个`*`号，把`list`或`tuple`的元素变成*可变参数*传进去：  
关键字参数 传入`0`个或*任意个*含参数名的参数 在函数内部自动组装为一个`dict`  
```
def person(name, age, **kw):
    print 'name:', name, 'age:', age, 'other:', kw
>>> person('Bob', 35, city='Beijing')
name: Bob age: 35 other: {'city': 'Beijing'}
>>> person('Adam', 45, gender='M', job='Engineer')
name: Adam age: 45 other: {'gender': 'M', 'job': 'Engineer'}
```
参数定义的顺序必须是：*必选参数*、*默认参数*、*可变参数*和*关键字参数* `def func(a, b, c=0, *args, **kw):`  
pip 安装第三方模块
[pip](https://pypi.python.org) 搜索包的名字  
面向对象特性  
*类*以*大写字母*开头 类名的*括号*里是*继承的类名*  
特殊方法：`__str__` `__len__` `__cmp__`  `__call__`  `__add__`  `__sub__`  `__mul__`  
定义在类中 不需要直接调用  
python的某些函数回自动调用对应的特殊方法  
只需要编写用到的特殊方法  
有关联的特殊方法都必须实现  
`__getattr__` `__setattr__` `__delattr__`  

**斐波那契数列**  
```
a, b, L = 0, 1, []
for x in range(10):
    L.append(a)
    a, b = b, a + b
```
**求公因数**  
```
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
```
