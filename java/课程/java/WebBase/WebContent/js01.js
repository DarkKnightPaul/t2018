/* js01.js */
/* 
  js是一门编程语言,早期是内嵌在浏览器中的脚本语言
  由于node的出现,js也可以脱离浏览器,编写服务器端应用,成为全功能编程语言
 */
function test() {
  //js通过function定义代码块,等同于java里面方法
  var a = 100; //var是声明变量,js是弱类型,所以全部类型都是var
  document.write(a + '<br />'); //document是js内置对象,表示html元素

  a = new Date(); //弱类型意味着变量可以指向任何类型的数据,Date是日期类型
  document.write(a.getFullYear() + '年<br />');

  //下面的程序员专用测试功能,旧版本ie不支持
  console.log('百度的社会招聘就是通过这个发布,通过控制台才能发现');
  console.error('错误信息...');

  //操作符
  var x = 10;
  var y = 101;
  document.write((x + y) + '<br />');
  document.write((x - y) + '<br />');
  document.write((x * y) + '<br />');
  document.write((x / y) + '<br />');
  document.write((y % x) + '<br />'); //取模运算,表示整除不尽的余数
  //任何小的数取模大数结果都是小数 7%8  =7
  //除尽的情况都是0 100%2=0
  //103%10=3
  //103 1,0,3
  //3 3 8 8 =24
  //逻辑运算
  document.write((x > y) + '<br />'); //flase
  var z = '101';
  document.write((y == z) + '<br />'); //==是判断值是否相等 true
  document.write((y === z) + '<br />'); //===是判断值和类型都必须相等 false
  document.write((x < y) + '<br />'); //true

  document.write((!(x > y)) + '<br />'); //取反 not
  document.write((x > y || y == z) + '<br />'); //a或者b or
  document.write((x > y && y == z) + '<br />'); //a和b and

  //作业题一,判断今年是否是闰年

  //流程控制
  for (var i = 0; i < 10; i++) {
    if (i % 2 == 0) {
      document.write('<h1>循环' + i + '</h1>');
    } else {
      document.write('<h2>循环' + i + '</h2>');
    }
  }

  //作业二,循环生成100个div,里面的内容都是一样的,但是要求三种不同颜色轮换
  for (var i = 0; i < 100; i++) {
    if (i % 3 == 0) {
        document.write('<div style="color:red;">js处理页面</div>');
    }else  if (i % 3 == 1) {
        document.write('<div style="color:green;">js处理页面</div>');
    }else  if (i % 3 == 2) {
        document.write('<div style="color:yellow;">js处理页面</div>');
    }
  }


}

//调用方法
test();