$(function() {
    //清除本地数据
    $('#btnClear').click(function() {
        //删除数据
        delete localStorage.saveData;
        delete localStorage.saveSessionData;

    });

    $('#btnRefersh').click(function() {
        //刷新页面
        location.reload();
    });

    //读取本地存储中的数据
    var saveData = localStorage.saveData;
    saveData = saveData ? saveData : '';
    $('#txtStorage').val(saveData);

    //保存数据到本地存储,只能是字符串
    $('#btnSave').click(function() {
        localStorage.saveData = $('#txtStorage').val();
        $('#divInfo').html('保存数据完毕!');
    });

    //会话级的本地存储，关闭浏览器就会自动销毁，更安全可靠

    var saveSessionData = sessionStorage.saveData;
    saveSessionData = saveSessionData ? saveSessionData : '';
    $('#txtSessionStorage').val(saveSessionData);

    //保存数据到本地存储,只能是字符串
    $('#btnSaveSession').click(function() {
        sessionStorage.saveData = $('#txtSessionStorage').val();
        $('#divInfo').html('保存数据完毕!');
    });

    //json和字符串相互转换
    var json = {
        'id': 100,
        'name': '张三'
    };

    $('#btnJson').click(function() {
        var strJson = JSON.stringify(json);
        var objJson = JSON.parse(strJson);
        $('#divInfo').html(strJson + '<br>' + objJson.name);

    });

    //服务器数据交换
    $('#btnGet').click(function() {
        $('#divInfo').html('数据获取中。。。');
        $.post('http://127.0.0.1:13000/storage/get', {}, function(data) {

            if (data.success) {
                sessionStorage.myid = data.datas.myid;
                sessionStorage.goods = JSON.stringify(data.datas.goods);
                $('#divInfo').html(data.message + '<br>myid:' + data.datas.myid + '<br>goods:' + JSON.stringify(data.datas.goods));
                return;
            }
            $('#divInfo').html('数据获取失败:' + data.message);
        }, 'json');

    });

    $('#btnSend').click(function() {
        $('#divInfo').html('数据发送中。。。');

        var myid = sessionStorage.myid;
        var goods = sessionStorage.goods;
        if (goods) {
            goods = JSON.parse(goods);
        }

        $.post('http://127.0.0.1:13000/storage/send', {
            "uuid": myid,
            "goods.gname": goods.gname,
            "goods.gid": goods.gid
        }, function(data) {
            if (data.success) {
                sessionStorage.myid = data.datas.myid;
                sessionStorage.goods = JSON.stringify(data.datas.goods);
                $('#divInfo').html(data.message + '<br>myid:' + data.datas.myid + '<br>goods:' + JSON.stringify(data.datas.goods));
                return;
            }
            $('#divInfo').html('发送获取失败:' + data.message);
        }, 'json');

    });



});