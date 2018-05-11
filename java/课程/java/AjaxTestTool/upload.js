(function() {
  var server = "http://127.0.0.1:10000";
  var url = server + "/demo/upload";


  $("#btnUpload").click(function() {
    var formData = new FormData();
    formData.append("file", $("#uploadfile")[0].files[0]);
    formData.append("test.tid", 10);
    $.ajax({
      url: url,
      type: "POST",
      data: formData,
      async: false,
      cache: false,
      contentType: false,
      processData: false,
      success: function(data) {
        console.log("success:", data);
        $('#divResult').html(JSON.stringify(data));
      },
      error: function(data) {
        console.log("error:", data);
        $('#divResult').html(JSON.stringify(data));
      }
    });

  });

})();