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