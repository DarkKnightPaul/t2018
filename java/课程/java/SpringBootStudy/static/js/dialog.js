$(function() {
    $('#btnDialog1').click(function() {
        mydialog.showWait('几秒后自动消失', '等待对话框1');
        setTimeout(function() {
            mydialog.hideWait();
        }, 2000);
    });

    $('#btnDialog2').click(function() {
        mydialog.showWait('几秒后自动消失', '等待对话框2', function() {
            alert('等待对话框消失');
        });
        setTimeout(function() {
            mydialog.hideWait();
        }, 2000);
    });

    $('#btnDialog3').click(function() {
        mydialog.showAlert('显示一个信息', '信息对话框1');
    });

    $('#btnDialog4').click(function() {
        mydialog.showAlert('显示另一个信息', '信息对话框2', function() {
            mydialog.showAlert('信息对话框关闭', '信息对话框3');
        });
    });

    $('#btnDialog5').click(function() {
        var isClose = false;
        mydialog.showAlert('用户不操作，等几秒自动关闭', '信息对话框', function() {
            isClose = true;
        });
        setTimeout(function() {
            if (!isClose) {
                mydialog.hideAlert();
            }
        }, 3000);
    });

    $('#btnDialog6').click(function() {
        mydialog.showConfirm('请选择', '确认对话框1', function() {
            mydialog.showAlert('选择了是！', '信息对话框');
        }, function() {
            mydialog.showAlert('选择了否！', '信息对话框');
        });
    });

    $('#btnDialog7').click(function() {
        var isClose = false;
        mydialog.showConfirm('请选择(等几秒会自动关闭，且不会有任何动作)', '确认对话框2', function() {
            isClose = true;
            mydialog.showAlert('选择是！', '信息对话框');
        }, function() {
            isClose = true;
            mydialog.showAlert('选择否！', '信息对话框');
        });
        setTimeout(function() {
            if (!isClose) {
                mydialog.hideConfirm();
            }
        }, 3000);
    });

});