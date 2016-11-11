/**
 * Created by Administrator on 2016/11/6.
 */
$(function(){
    var height = (document.documentElement.clientWidth || document.body.clientwidth)*2/3;
    $("#slider1").animate({"height":height});
},100);
var slider = mui("#slider1");
slider.slider({
    interval: 3000
});
$(function (){
    $("#text").addClass('bounceInUp animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
        $(this).removeClass();
    });
    var index = document.getElementById("index");
    index.addEventListener("tap",function(){
        $("#text").addClass('bounceInUp animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
            $(this).removeClass();
        });
    })
    var myself = document.getElementById("myself");
    myself.addEventListener("tap",function(){
        alert(base_path);
    })
})
