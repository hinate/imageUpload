/**
 * Created by a6541_000 on 2016/5/29.
 */
//$(document).ready(function(){
        function Check() { // 验证表单数据有效性
            var flag=false;
            var username=$("#username").val();
            if (username=="") {
                $("#username_error").html("请填写用户名");
                return flag;
            }else{
                $("#username_error").html("");
            }
            var password=$("#password").val();
            if (password=="")
            {
                $("#password_error").html("请输入密码!");
                return flag;
            }else if(password.length<6){
                $("#password_error").html("密码过短!");
                return flag;
            }else{
                $("#password_error").html("");
            }
            var chkpwd=$("#chkpwd").val();
            if (password!= chkpwd)
            {
                $("#chkpwd_error").html("确密码不一致!");
                return flag;
            }else{
                $("#chkpwd_error").html("");
            }
            var email=$("#email").val();
            if (email=="")
            {
                $("#email_error").html("请输入Email!");
                return flag;
            }else{
                $("#email_error").html("");
            }
            var patternEmail=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
            if(!patternEmail.test(email)) {
                $("#email_error").html('请输入有效的email地址!');
                return flag;
            }else{
                $("#email_errorl").html("");
            }
            return true;
        }
        $("#submitReg").click(function(){
            var flag=Check();
            var form_data = {
                userName: $("#username").val(),
                password: $("#password").val(),
                email: $("#email").val()
            };
            if(flag) {
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    cache: false,
                    url: "registerController/register.htm",
                    data: form_data,
                    success: function (datamap) {
                        if (datamap == "success") {
                            window.location.href = 'login.html';
                        }
                    }
                });
                return false;
            }
            return false;
        });
//});