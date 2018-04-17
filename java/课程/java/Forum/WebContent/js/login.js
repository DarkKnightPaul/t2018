$(function() {
  console.log('in login.js');

  $('#btnReset').click(function() {
    $('#txtUsername').val('');
    $('#txtPassword').val('');
    $('#txtUsername').focus();
  });


  $('#btnLogin').click(function() {
    var txtUsername = $('#txtUsername');
    var txtPassword = $('#txtPassword');

    $.post('../login.servlet', {
      'username': txtUsername.val(),
      'password': txtPassword.val()
    }, function(data) {
      if (data.error) {
        alert(data.error);
        return;
      }
      alert('欢迎:' + data.user.nickname);
      location = "../index.html";
    }, 'json');

  });

  $('#btnReset').trigger('click');

});