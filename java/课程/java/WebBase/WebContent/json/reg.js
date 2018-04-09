$(function() {
  $('#btnReg').click(function() {
    var txtUsername = $('#txtUsername');
    var txtPassword = $('#txtPassword');
    var txtPassword1 = $('#txtPassword1');
    var txtNickname = $('#txtNickname');

    var username = txtUsername.val();
    var password = txtPassword.val();
    var password1 = txtPassword1.val();
    var nickname = txtNickname.val();

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
    if (password1 != password) {
      divError.html('密码和确认密码不一致');
      txtPassword1.focus();
      return;
    }
    if (nickname == '') {
      divError.html('昵称必须填写');
      txtNickname.focus();
      return;
    }

    $.post('reg.servlet', {
      'username': username,
      'password': password,
      'nickname': nickname
    }, function(data) {
      console.log(data);
      if (data.message) {
        alert(data.message);
        query();
      } else if (data.error) {
        $('#divError').html(data.error);
      } else {
        $('#divError').html(data);
      }

    }, 'json');

  });

  $('#txtUsername').focus();
});