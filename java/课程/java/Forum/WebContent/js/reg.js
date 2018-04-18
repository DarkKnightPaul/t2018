$(function() {
  console.log('in login.js');

  $('#btnReset').click(function() {
    $('#txtUsername').val('');
    $('#txtPassword').val('');
    $('#txtNickname').val('');
    $('#txtUsername').focus();
  });


  $('#btnLogin').click(function() {
    var txtUsername = $('#txtUsername');
    var txtPassword = $('#txtPassword');
    var txtNickname = $('#txtNickname');

    $.post('../reg.servlet', {
      'username': txtUsername.val(),
      'password': txtPassword.val(),
      'nickname': txtNickname.val()
    }, function(data) {
      if (data.error) {
        alert(data.error);
        return;
      }
      alert(data.message);
      location = "../index.html";
    }, 'json');
  });

  $('#btnReset').trigger('click');

});