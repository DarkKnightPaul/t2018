function checkAllInterest() {
  var chkAll = document.getElementById('chkAll');
  var interest = document.getElementsByName('interest');
  for (var i = 0; i < interest.length; i++) {
    interest[i].checked = chkAll.checked;
  }
}

function reverseInterest() {
  var interest = document.getElementsByName('interest');
  for (var i = 0; i < interest.length; i++) {
    interest[i].checked = !interest[i].checked;
  }
}

function formatNow() {
  var date = new Date();
  var sdate = date.getFullYear() + '年';
  sdate += date.getMonth() + 1 + '月';
  sdate += date.getDate() + '日 ';
  sdate += date.getHours() + ':';
  sdate += date.getMinutes() + ':';
  sdate += date.getSeconds();
  return sdate;
}

function showTime() {
  var spTime = document.getElementById('spTime');
  spTime.innerHTML = formatNow();
}

showTime();
setInterval(showTime, 1000);

//公用方法
function trim(str) {
  if (str) {
    str = str.replace(/(^\s*)|(\s*$)/g, '');
    return str;
  }
  return '';
}

function isInt(str) {
  str = trim(str);
  return (str != '' && !isNaN(str) && parseInt(str) == parseFloat(str));
}

function isFloat(str) {
  str = trim(str);
  return (str != '' && !isNaN(str));
}

//dom模拟操作相关=============================================================
function addGoods() {
  console.log('addGoods...');
  //获取并判断数据
  var txtGname = document.getElementById('txtGname');
  var txtPrice = document.getElementById('txtPrice');
  var txtAmount = document.getElementById('txtAmount');
  var txtInfo = document.getElementById('txtInfo');
  console.log(trim(txtGname.value), trim(txtPrice.value), trim(txtAmount.value));
  //错误提示
  var divError = document.getElementById('divError');
  divError.innerHTML = '';
  if (trim(txtGname.value) == '') {
    divError.innerHTML = '商品名称必须填写';
    txtGname.focus();
    return;
  }
  if (!isFloat(txtPrice.value)) {
    divError.innerHTML = '商品单价必须填写且是数值';
    txtPrice.focus();
    return;
  }
  if (!isInt(txtAmount.value)) {
    divError.innerHTML = '商品数量必须填写且是整数';
    txtAmount.focus();
    return;
  }
  var gname = trim(txtGname.value);
  var price = parseFloat(trim(txtPrice.value));
  var amount = parseInt(trim(txtAmount.value));
  var info = trim(txtInfo.value);
  if (price < 0) {
    divError.innerHTML = '商品单价要大于0';
    txtPrice.focus();
    return;
  }
  if (amount < 0) {
    divError.innerHTML = '商品数量要大于0';
    txtAmount.focus();
    return;
  }
  //添加到表格中
  var tbData = document.getElementById('tbData');
  //创建tr（行）
  var tr = document.createElement('tr');
  //创建td（单元格）
  var td = document.createElement('td');
  td.append(gname);
  tr.append(td); //追加到行
  td = document.createElement('td');
  td.append(price);
  tr.append(td); //追加到行
  td = document.createElement('td');
  td.append(amount);
  tr.append(td); //追加到行
  td = document.createElement('td');
  td.append(price);
  tr.append(info); //追加到行

  tbData.append(tr); //行追加到表格

  resetForm(); //重置表单
}

//重置表单
function resetForm() {
  console.log('resetForm...');
  var txtGname = document.getElementById('txtGname');
  var txtPrice = document.getElementById('txtPrice');
  var txtAmount = document.getElementById('txtAmount');
  var txtInfo = document.getElementById('txtInfo');
  txtGname.value = '';
  txtPrice.value = '';
  txtAmount.value = '';
  txtInfo.value='';
  var divError = document.getElementById('divError');
  divError.innerHTML = '';
  txtGname.focus();
}

resetForm();