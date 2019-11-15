<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 下面两个必须引用 -->
<script type="text/javascript"
    src="../resources/jsExt/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript"
    src="../resources//jsExt/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<!-- 国际化文件 -->
<script type="text/javascript"
    src="../resources//jsExt/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<!-- 默认样式 -->
<link rel="stylesheet"
    href="../resources/jsExt/jquery-easyui-1.5.2/themes/default/easyui.css">
<!-- 图标 -->
<link rel="stylesheet"
    href="../resources/jsExt/jquery-easyui-1.5.2/themes/icon.css">
<!-- 自定义js -->
<script type="text/javascript" src="../resources/js/teacherFormatter.js"></script>
<!-- 自定义的js脚本 -->
<script type="text/javascript" src="../resources/js/commons.js"></script>
<script type="text/javascript" src="../resources/js/user/userOper.js"></script>
<link rel="stylesheet" href="../resources/css/user.css">

</head>
<body>
    <div id="tt" class="easyui-layout" style="margin: 20px 20px 20px 20px;">
        <table id="dg" class="easyui-datagrid" title="用户列表"
            style="width: 100%; height: 400px;pagination-num{width:200px}"
            data-options="rownumbers:true,striped:true,fitColumns:true,singleSelect:true,autoRowHeight:true,pagination:true,
                pageSize:12,pageList:[12,100,200,300],url:'${pageContext.request.contextPath}/v1/getUsers',method:'get',toolbar:'#toolbar'">
            <thead>
                <tr>
                    <th data-options="field:'id',width:100">ID</th>
                    <th data-options="field:'name',width:100">name</th>
                    <th data-options="field:'age',width:100">Age</th>
                    <th data-options="field:'gender',width:60">Gender</th>
                    <th data-options="field:'email',width:150">Email</th>
                    <th data-options="field:'createTime',width:150">Create Time</th>
                    <th data-options="field:'loginTime',width:150">Login Time</th>
                    <th data-options="field:'teacher',width:100"
                        formatter="teacherFormatter">Teacher Name</th>
                </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="#" class="easyui-linkbutton"
                data-options="iconCls:'icon-add'" onclick="insert()">添加</a> <a
                href="#" class="easyui-linkbutton"
                data-options="iconCls:'icon-edit'" onclick="edit()">编辑</a> <a
                href="#" class="easyui-linkbutton"
                data-options="iconCls:'icon-remove'" onclick="del()">删除</a>
        </div>
    </div>

    <!-- create user dialog -->
    <div id="dlg" class="easyui-dialog"
        data-options="iconCls:'icon-save',resizable:true,modal:true"
        style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
        buttons="#dlg-buttons">
        <div class="ftitle">用户信息</div>
        <form id="fm" method="post">
            <div class="fitem">
                <label for="name">用户名:</label> <input name="name"
                    class="easyui-validatebox" type="text" data-options="required:true">
            </div>
            <div class="fitem">
                <label for="age">年 龄:</label> <input name="age"
                    class="easyui-numberbox" type="text"
                    data-options="required:true,validType:'number'">
            </div>
            <div class="fitem">
                <label for="gender">性 别:</label> <input id="state1" name="gender"
                    value="男" type="radio" checked="true" />男 <input id="state2"
                    name="gender" value="女" type="radio" />女
            </div>
            <div class="fitem">
                <label for="email">Email:</label> <input name="email"
                    class="easyui-validatebox" type="text"
                    data-options="required:true,validType:'email'">
            </div>
            <div class="fitem">
                <label for="teacherId">教 师:</label> <input id="cc"
                    class="easyui-combobox" name="teacherId"
                    data-options="valueField:'id',textField:'name',panelHeight:80,editable:false,method:'get',url:'${pageContext.request.contextPath}/v1/getTeacherComboData'">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
            onclick="save()">Save</a> <a href="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-cancel'"
            onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
</body>
</html>