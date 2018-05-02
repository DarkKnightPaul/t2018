(function() {

  function formatJson(json) {
    // 缩进显示json字符串
    var result = JSON.stringify(JSON.parse(json), undefined, 4);
    return syntaxHighlight(result);
  }

  function syntaxHighlight(json) {
    // json语法高亮
    json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function(match) {
      var cls = 'number';
      if (/^"/.test(match)) {
        if (/:$/.test(match)) {
          cls = 'key';
        } else {
          cls = 'string';
        }
      } else if (/true|false/.test(match)) {
        cls = 'boolean';
      } else if (/null/.test(match)) {
        cls = 'null';
      }
      return '<span class="' + cls + '">' + match + '</span>';
    });
  }

  //转换json到querystring
  function parseParam(param, key) {
    var paramStr = "";
    if (param instanceof String || param instanceof Number || param instanceof Boolean) {
      paramStr += "&" + key + "=" + encodeURIComponent(param);
    } else {
      $.each(param, function(i) {
        var k = key == null ? i : key + (param instanceof Array ? "[" + i + "]" : "." + i);
        paramStr += '&' + parseParam(this, k);
      });
    }
    return paramStr.substr(1);
  };

  $(function() {
    var app = new Vue({
      el: "#divVue",
      data: {
        welcome: "欢迎使用ajax测试工具，测试的服务器必须支持跨域",
        servers: [
          "http://127.0.0.1:8080/Forum",
          "http://127.0.0.1:13000"
        ],
        selected: "http://127.0.0.1:8080/Forum",
        path: "",
        sendinfo: "{}",
        result: "",
        fresult: "",
        geturl: "",
        error: ""
      },
      methods: {
        send: function() {
          app.error = "";
          var url = this.selected + this.path;
          var sendData = JSON.parse(this.sendinfo);
          var querystr = parseParam(sendData);
          querystr = querystr == "" ? "" : "?" + querystr;
          this.geturl = "get提交的url：" + (url + querystr);
          $.post(url, sendData, function(data) {
            app.$data.result = data;
            app.$data.fresult = formatJson(JSON.stringify(data));
          }, "json").error(function(data) {
            console.log("错误:", data);
            app.error = "获取数据发生错误，请查看控制台";
          });

        }
      }
    });
  });

})();