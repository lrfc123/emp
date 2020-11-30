<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>

    <!--bootstrap核心样式-->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <!--jqgrid核心样式-->
    <link rel="stylesheet" href="./grid/ui.jqgrid-bootstrap.css">
    <!--jquery核心js-->
    <script src="./js/jquery-3.5.1.min.js"></script>
    <!--bootstrap的js 下拉菜单  collapse  ....-->
    <script src="./js/bootstrap.min.js"></script>
    <!--引入jqgrid数据表格的核心js-->
    <script src="./grid/jquery.jqGrid.min.js"></script>
    <!--引入jqgrid数据表格国际js文件-->
    <script src="./grid/grid.locale-cn.js"></script>


    <script>
        $(function () {
            $("#emp").jqGrid({
                styleUI: "Bootstrap",//创建一个bootstrap风格表格
                url: "${pageContext.request.contextPath}/emp/findAll2",
                datatype: "json",
                colNames: ["编号", "姓名", "年龄", "性别", "工资", "部门"],
                colModel: [
                    {name: "id"},
                    {name: "name",editable:true},
                    {name: "age",editable:true,search:false},
                    {name: "sex",editable:true,edittype:'select',editoptions:{value:"男:男;女:女"},search:false},
                    {name: "salary",editable:true,search:false},
                    {name: "dept.id",editable:true,edittype:'select',editoptions:{dataUrl:"${pageContext.request.contextPath}/dept/findAll"},
                            formatter:function(value,option,row){
                                //console.log(value);
                                //console.log(option);
                                // console.log(row);
                                return row.dept.name;
                            }
                    }
                ],
                pager:"#pager",
                page:1,
                rowNum:5,
                viewrecords:true,
                autowidth:true,
                caption:"员工表",
                editurl:"${pageContext.request.contextPath}/emp/edit",//用来处理修改时url路径  String oper参数  add 添加  edit 修改  del 删除

           }).navGrid("#pager",
                {add:true,edit:true,del:true,search:true,refresh:true},//对展示的增删改按钮配置
                {
                    closeAfterEdit: true,  //关闭面板
                    reloadAfterSubmit: true,
                },//对编辑配置
                {
                    closeAfterAdd: true,
                    reloadAfterSubmit: true,
                },//对添加配置
                {
                    closeAfterAdd: true,
                    reloadAfterSubmit: true,
                },//对删除配置
                {
                    sopt : ['cn','eq'],//用来展示那些搜索的运算符
                });//对搜索配置
        });
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <!--用户列表-->
            <table id="emp"></table>
        </div>
    </div>

    <!--分页工具栏-->
    <div id="pager"></div>

</div>
</body>
</html>
