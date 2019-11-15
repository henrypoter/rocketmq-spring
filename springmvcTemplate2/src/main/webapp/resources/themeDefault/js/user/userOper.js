/*!
 * imalex@163.com - v0.1 (2015-08-29 18:00:00 +0800)
 * Copyright 2015
 */
$(function() {

});

$('#dg').pagination({
    pageSize: 20,//每页显示的记录条数，默认为10 
    pageList: [20, 50, 100],//可以设置每页记录条数的列表 
});

function insert() {
    $('#dlg').dialog('open').dialog('setTitle', '新建用户');
    $('#fm').form('clear');
    url = ctx + '/v1/users';
    type = insert;
}

function edit() {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
        $('#dlg').dialog('open').dialog('setTitle', '编辑用户信息');
        $('#fm').form('load', row);
        //setCheckedValue(document.forms['fm'].elements['gender'], row['gender']);
        url = ctx + '/v1/users/' + row.id;
        type = edit;
    }
}

function save() {
    $('#fm').form('submit', {
        url : url,
        type:type,
        onSubmit : function(param) {
            if (type == edit) {
                //use put 
                param._method ='PUT';
            }
            param.createTime = new Date().Format("yyyy-MM-dd hh:mm:ss");
            param.loginTime = param.createTime;
            
            var ret = $(this).form('validate');
            return ret;
        },
        success : function(result) {
            var result = eval('(' + result + ')');
            if (result.errorMsg) {
                $.messager.show({
                    title : 'Error',
                    msg : result.errorMsg
                });
            } else {
                $('#dlg').dialog('close'); // close the dialog
                $('#dg').datagrid('reload'); // reload the user data
            }
        }
    });
}

function del() {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('确认', '请确认删除已选择用户?', function(r) {
            if (r) {
                $.post(ctx + '/v1/users/' + row.id, {
                    _method : 'DELETE'
                }, function(result) {
                    if (result.status != null) {
                        $('#dg').datagrid('reload'); // reload the user data
                    } else {
                        $.messager.show({ // show error message
                            title : 'Error',
                            msg : result.errorMsg
                        });
                    }
                }, 'json');
            }
        });
    }
}