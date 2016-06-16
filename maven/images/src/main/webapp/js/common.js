/**
 * Created by a6541_000 on 2016/6/1.
 */


$(document).ready(function(){
    getUser();
    function getUser(){
        $.ajax({
            type:"post",
            dataType:"json",
            url:"../../loginController/getUser.htm",
            data: {},
            success:function(data){
                var m = eval(data);
                if(m!=""){
                    for(var i=0;i<m.length;i++){
                        $("#username").html(m[i].userName);
                        $("#usernamei").html(m[i].userName);
                        $("#email").html(m[i].email);
                        var time=m[i].timetamp;
                        $("#timetamp").html(time.substring(0,16));
                    }
                }
            }
        });
    }
})
