$(function() {
  console.log('商品管理...');

  $('#addDialog').on('shown.bs.modal', function(e) {
    $('#txtGname').focus();
  });

  $('#addDialog').on('hidden.bs.modal', function(e) {
    resetAdd();
  });

  $('#btnShowAdd').click(function() {
    $('#addTitle').html('商品信息添加');
    $('#addDialog').modal('show');
  });

  $('#btnAdd').click(function() {
    $('#waitInfo').html('商品信息处理中，请稍候。。。');
    $('#waitDialog').modal('show');
    var gid = $('#txtGid').val();
    var url = 'http://127.0.0.1:13000/goods/add';
    var params = {
      'gname': $('#txtGname').val(),
      'ginfo': $('#txtGinfo').val(),
      'price': $('#txtPrice').val(),
      'amount': $('#txtAmount').val(),
      'sellprice': $('#txtSellprice').val()
    };
    if (gid && gid != '') {
      url = 'http://127.0.0.1:13000/goods/modify';
      params.gid = gid;
    }
    console.log(url, '-', gid);

    $.post(url, params, function(data) {
      $('#waitDialog').modal('hide');
      alert(data.message);
      if (data.success) {
        $('#addDialog').modal('hide');
        query();
      }
    }, 'json');
  });

  function resetAdd() {
    $('#txtGid').val('');
    $('#txtGname').val('');
    $('#txtGinfo').val('');
    $('#txtPrice').val('');
    $('#txtAmount').val('');
    $('#txtSellprice').val('');
  }

  function query() {
    $('#waitInfo').html('查询商品信息中，请稍候。。。');
    $('#waitDialog').modal('show');
    $.post('http://127.0.0.1:13000/goods/queryAll', {}, function(data) {
      if (data.success) {
        $('#waitDialog').modal('hide');
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
          //修改事件处理
          span.click(function() {
            modifyGoods(v);
          });
          td.append(span);

          span = $(document.createElement('span'));
          span.append('删除');
          span.attr('class', 'btn btn-danger');
          //删除事件处理
          span.click(function() {
            deleteGoods(v);
          });
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

  function modifyGoods(g) {
    $('#txtGid').val(g.gid);
    $('#txtGname').val(g.gname);
    $('#txtGinfo').val(g.ginfo);
    $('#txtPrice').val(g.price);
    $('#txtAmount').val(g.amount);
    $('#txtSellprice').val(g.sellprice);
    $('#addTitle').html('商品信息修改');
    $('#addDialog').modal('show');
  }



  function deleteGoods(g) {
    console.log(g);
    $('#deleteId').val(g.gid);
    $('#deleteInfo').html('是否删除商品：' + g.gname + '(' + g.gid + ')?');
    $('#deleteDialog').modal('show');
  }

  $('#btnDelete').click(function() {
    $('#deleteDialog').modal('hide');
    $('#waitInfo').html('删除商品信息中，请稍候。。。');
    $('#waitDialog').modal('show');
    $.post('http://127.0.0.1:13000/goods/delete', {
      'gid': $('#deleteId').val()
    }, function(data) {
      $('#waitDialog').modal('hide');
      alert(data.message);
      query();
    }, 'json');

  });

  query();
});