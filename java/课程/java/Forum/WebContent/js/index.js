$(function() {
  console.log('in index.js');

  $.post('getuser.servlet', {}, function(data) {
    if (data.user && data.user.username) { //用户存在到情况
      $('#spLogout').fadeIn('fast');
      $('#spUser').html('欢迎用户' + data.user.nickname + '(' + data.user.username + ')');
    } else {
      $('#spLogin').fadeIn('fast');
    }
  }, 'json');

  $('#btnLogout').click(function() {
    $.post('logout.servlet', {}, function(data) {
      alert(data.message);
      location.reload();
    }, 'json');

  });
});