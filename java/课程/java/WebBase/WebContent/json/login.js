$(function() {

  $('#btnReg').click(function() {
    location.href = 'reg.html';
  });

  $('#btnLogin').click(function() {
    var txtUsername = $('#txtUsername');
    var txtPassword = $('#txtPassword');

    var username = txtUsername.val();
    var password = txtPassword.val();

    var divError = $('#divError');
    divError.html('');
    if (username == '') {
      divError.html('用户名必须填写');
      txtUsername.focus();
      return;
    }
    if (password == '') {
      divError.html('密码必须填写');
      txtPassword.focus();
      return;
    }

    $.post('login.servlet', {
      'username': username,
      'password': password
    }, function(data) {
      console.log(data);
      if (data.message) {
        alert(data.message + '\r\n欢迎' + data.user.nickname);
        location.href = 'data.html';
      } else if (data.error) {
        $('#divError').html(data.error);
      } else {
        $('#divError').html(data);
      }
    }, 'json');

  });

  $('#txtUsername').focus();
});