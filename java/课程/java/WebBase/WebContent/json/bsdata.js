$(function() {
  console.log('bsdata.js init ...');

  function query() {
    //通过js获取后台数据
    $.post('query.servlet', {}, function(data) {
      console.log(data);
      $('#tbData').html(''); //清除原有数据

      var list = data.list;
      $.each(list, function(i, v) {
        var bsclass = (i % 2 == 0) ? 'bg-info' : 'bg-warning';
        var $tr = $(document.createElement('tr')); //创建tr
        $tr.attr('class', bsclass);
        var $td = $('<td></td>'); //创建td
        $td.append(v.nid);
        $tr.append($td);

        $td = $(document.createElement('td')); //创建td
        $td.append(v.title);
        $tr.append($td);

        $td = $(document.createElement('td')); //创建td
        $td.append(v.content);
        $tr.append($td);

        $td = $(document.createElement('td')); //创建td
        $td.append(v.created);
        $tr.append($td);

        $('#tbData').append($tr);
      });

    }, 'json');
  }



  $('#btnAdd').click(function() {
    $.post('add.servlet', {
      'title': $('#txtTitle').val(),
      'content': $('#txtContent').val()
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

  query();

});