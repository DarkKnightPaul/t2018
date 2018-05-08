$(function() {
  console.log('商品管理...');

  $('#addDialog').on('shown.bs.modal', function(e) {
    resetAdd();
  });

  $('#btnShowAdd').click(function() {
    $('#addDialog').modal('show');
  });

  $('#btnAdd').click(function() {
    $.post('http://127.0.0.1:13000/goods/add', {
      'gname': $('#txtGname').val(),
      'ginfo': $('#txtGinfo').val(),
      'price': $('#txtPrice').val(),
      'amount': $('#txtAmount').val(),
      'sellprice': $('#txtSellprice').val()
    }, function(data) {
      alert(data.message);
      if (data.success) {
        $('#addDialog').modal('hide');
        query();
      }
    }, 'json');
  });

  function resetAdd() {
    $('#txtGname').val('');
    $('#txtGinfo').val('');
    $('#txtPrice').val('');
    $('#txtAmount').val('');
    $('#txtSellprice').val('');
    $('#txtGname').focus();
  }

  function query() {
    $.post('http://127.0.0.1:13000/goods/queryAll', {}, function(data) {
      if (data.success) {
        console.log(data.datas.list);
        var tbData = $('#tdData');
        tbData.html('');
        $.each(data.datas.list, function(i, v) {
          var tr = $(document.createElement('tr'));
          i % 2 == 0 ? tr.attr('class', 'bg-info') : tr.attr('class', 'bg-danger');
          var td = $(document.createElement('td'));
          td.append(v.gid);
          tr.append(td);
          td = $(document.createElement('td'));
          td.append(v.gname);
          tr.append(td);
          td = $(document.createElement('td'));
          td.append(v.ginfo);
          tr.append(td);
          td = $(document.createElement('td'));
          td.append(v.price);
          tr.append(td);
          td = $(document.createElement('td'));
          td.append(v.amount);
          tr.append(td);
          td = $(document.createElement('td'));
          td.append(v.sellprice);
          tr.append(td);
          td = $(document.createElement('td'));
          td.attr('class', 'text-center');
          var span = $(document.createElement('span'));
          span.append('修改');
          span.attr('class', 'btn btn-primary');
          td.append(span);
          span = $(document.createElement('span'));
          span.append('删除');
          span.attr('class', 'btn btn-danger');
          td.append(span);
          tr.append(td);
          tbData.append(tr);
          console.log(tbData.html());
        });
      } else {
        alert(data.message);
      }
    }, 'json');
  }


  query();
});