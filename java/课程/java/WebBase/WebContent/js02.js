function trim(str) {
  if (str) {
    str = str.replace(/(^\s*)|(\s*$)/);
  }
  return str;
}

function load() {
  console.log('in load...');
  //通过id获取页面元素
  var divContainer = document.getElementById('divContainer');
  //追加文本到元素中
  divContainer.append('我是通过js追加的');
}

function addInfo() {
  console.log('in addInfo...');
  var divContainer = document.getElementById('divContainer');
  var txtAdd = document.getElementById('txtAdd');
  var info = txtAdd.value; //获取输入的值
  divContainer.append(info);
  txtAdd.value = ''; //设置输入的值
  txtAdd.focus(); //输入元素取得焦点
}

function btnConfirm() {
  console.log('in btnConfirm...');
  var txtInt = document.getElementById('txtInt');
  var txtFloat = document.getElementById('txtFloat');
  //判断是否为空
  if (trim(txtInt.value) == '') {
    alert('年龄必须填写');
    txtInt.focus();
    return;
  }
  //判断是否为数值
  if (isNaN(txtInt.value)) {
    alert('年龄必须是数');
    txtInt.focus();
    return;
  }
  //判断是否为整数
  if (parseInt(txtInt.value) != parseFloat(txtInt.value)) {
    alert('年龄必须是整数');
    txtInt.focus();
    return;
  }
  //作业一，添加月薪(可以是小数)的判断，年龄和月薪必须在一定范围
}

function loadSelect() {
  var selYear = document.getElementById('selYear');
  selYear.options.length = 0; //清除全部option
  var ystart = 1960;
  var yend = new Date().getFullYear();
  for (var i = ystart; i <= yend; i++) {
    //创建option元素
    var option = document.createElement('option');
    //设置option的值属性
    option.setAttribute('value', i);
    option.append(i + '年');
    selYear.append(option);
  }
  //设置默认选中中间的值
  selYear.selectedIndex = selYear.options.length / 2;
  //作业二，添加月份和日期的下拉选择
}

function showSelect() {
  var selYear = document.getElementById('selYear');
  if (selYear.options.length == 0) {
    alert('请初始化数据');
    return;
  }
  alert(selYear.value);
}
load();