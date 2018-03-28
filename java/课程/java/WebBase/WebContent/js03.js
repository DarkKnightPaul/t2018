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