$(function() {
  $("#imgCode").click(function() {
    $("#imgCode").attr("src", "http://127.0.0.1:13000/util/code.jpg?ts=" + new Date().getTime());
  });
  $("#achange").click(function() {
    $("#imgCode").attr("src", "http://127.0.0.1:13000/util/code.jpg?ts=" + new Date().getTime());
  });
});