//jq的load函数一定会在页面加载完之后执行
$(function() {
  //alert(2);
  //json是最流行的数据传输格式，主流语言都提供支持
  //json和js可以无缝连接
  var j1 = {
    id: 100,
    name: "dfdf"
  }; //格式是{"字符串的key":值,...}
  //$("#值")是jq获取id为值的页面元素
  //.html是设置和获取元素到html内容,有参数就是设置，没有就是获取
  $("#divInfo").html(j1.id + "---->" + j1.name);
  //json和字符串快速的转换
  var j2 = '{"id":200,"name":"哈哈哈"}';
  console.log(j2.id); //转换前直接使用id不合法，字符串没这个功能
  //转换字符串到json格式
  var j3 = JSON.parse(j2);
  console.log(j3.id, "===>", j3.name);

  //jq添加单击事件处理,事件是标准事件去掉on
  $("#btnJson").click(function() {

    //jq获取或设置输入元素的值,有参数就是设置，没有就是获取
    var txtJson = $("#txtJson").val();
    console.log(txtJson);
    var j4 = JSON.parse(txtJson);
    console.log(j4);

  });

  //复杂的json
  var j5 = {
    "id": 201601,
    "name": "计算机201601班",
    "students": [{
      "sid": 1000,
      "name": "冯修远"
    }, {
      "sid": 1001,
      "name": "康帅"
    }]
  };

  //jq将json的一组数据添加到select元素中
  var selStudent = $("#selStudent");
  var students = j5.students; //学生列表
  //jq的循环,第一个参数是数组,第二是获取数据处理的函数，第一个参数是索引,第二个是值
  $.each(students, function(index, value) {
    console.log(index, "==>", value);
    //创建option
    var op = $(document.createElement("option"));
    op.attr("value", value.sid); //值是sid
    op.append(value.name); //显示文本是name
    selStudent.append(op);
  });

});
