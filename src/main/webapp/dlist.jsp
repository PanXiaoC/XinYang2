<%--
  Created by IntelliJ IDEA.
  User: PanXi
  Date: 2021/1/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">


                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input"></div>

                        <button class="layui-btn" lay-submit lay-filter="search">
                            <i class="layui-icon">&#xe615;</i></button>

                    </form>
                </div>
                <script>form.on('submit(search)', function(data){
                    layer.msg(JSON.stringify(data.field));//表格数据序列化
                    var formData = data.field;
                    console.debug(formData);
                    var name = formData.name,
                        url=formData.url,
                        icon=formData.icon,
                        parent_id=formData.parent_id;
                    //数据表格重载
                    table.reload('tableReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {//这里传参  向后台
                            name: name,
                            url:url
                        }
                        , url: '/menu/page'//后端在这里改地址
                        , method: 'post'
                    });
                    return false;//false：阻止表单跳转  true：表单跳转
                });</script>.

                <div class="layui-card-body ">
                    <table class="layui-table" lay-data="{url:'./user.json',page:true,toolbar: '#toolbarDemo',id:'test'}" lay-filter="test">
                        <!--  上面这行的url填写数据地址 -->
                        <thead>
                        <tr>
                            <th lay-data="{type:'checkbox'}">ID</th>
                            <th lay-data="{field:'id', width:80, sort: true}">ID</th>
                            <th lay-data="{field:'username', width:120, sort: true, edit: 'text'}">用户名</th>
                            <th lay-data="{field:'truename', width:120,sort: true, edit: 'text'}">真实姓名</th>
                            <th lay-data="{field:'role', width:120,sort: true, edit: 'text'}">角色</th>
                            <th lay-data="{field:'email', edit: 'text', minWidth: 150}">邮箱</th>
                            <th lay-data="{field:'sex', width:80,templet: '#switchTpl'}">性别</th>
                            <th lay-data="{field:'tel', edit: 'text', minWidth: 100}">号码</th>
                            <th lay-data="{field:'memo', sort: true, edit: 'text'}">备注</th>
                            <th lay-data="{field:'right', width:200,toolbar:'#barDemo'}">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


<!--行内样式按钮   -->
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>



</script>




<script type="text/html" id="toolbarDemo">
    <div class = "layui-btn-container" >
        <button class = "layui-btn layui-btn-sm" lay-event = "getCheckData" > 获取选中行数据 </button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button >

    </div >
</script>
<script type="text/html" id="switchTpl">

    <input type = "checkbox" name = "sex" value = "{{d.id}}" lay-skin = "switch"lay-text = "女|男" lay-filter = "sexDemo" {{ d.id == 10003 ? 'checked': ''}} >
</script>

<script>layui.use('table',
    function() {
        var table = layui.table;

        //监听单元格编辑
        table.on('edit(test)',
            function(obj) {
                var value = obj.value //得到修改后的值
                    ,
                    data = obj.data //得到所在行所有键值
                    ,
                    field = obj.field; //得到字段
                layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
            });

        //头工具栏事件
        table.on('toolbar(test)',
            function(obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case 'getCheckData':
                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：' + data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
                        break;
                };
            });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除【'+data.realname+'】这个用户吗', function(index){
                    //向服务端发送删除指令
                    $.post("${ctx}/user/deleteUser.action",{userid:data.userid},function(res){
                        layer.msg(res.msg);
                        //刷新数据 表格
                        tableIns.reload();
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                openUpdateUser(data);
            }else if(layEvent==='resetUserPwd'){
                layer.confirm('真的重置【'+data.realname+'】这个用户的密码吗', function(index){
                    //向服务端发送删除指令
                    $.post("${ctx}/user/resetUserPwd.action",{userid:data.userid},function(res){
                        layer.msg(res.msg);
                    })
                });
            }else if(layEvent==='selectUserRole'){
                openselectUserRole(data);
            }
        });

        var url;
        var mainIndex;
        //打开添加页面
        function openAddUser(){
            mainIndex=layer.open({
                type:1,
                title:'添加用户',
                content:$("#saveOrUpdateDiv"),
                area:['800px','400px'],
                success:function(index){
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    url="${ctx}/user/addUser.action";
                }
            });
        }
        //打开修改页面
        function openUpdateUser(data){
            mainIndex=layer.open({
                type:1,
                title:'修改用户',
                content:$("#saveOrUpdateDiv"),
                area:['800px','400px'],
                success:function(index){
                    form.val("dataFrm",data);
                    url="./d-edit.html";
                }
            });
        }
        //保存
        form.on("submit(doSubmit)",function(obj){
            //序列化表单数据
            var params=$("#dataFrm").serialize();
            $.post(url,params,function(obj){
                layer.msg(obj.msg);
                //关闭弹出层
                layer.close(mainIndex)
                //刷新数据 表格
                tableIns.reload();
            })
        });




    });</script>


</html>