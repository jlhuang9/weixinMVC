mui.init({
    swipeBack: true //启用右滑关闭功能
});
var nowz_index = 100;
mui('.mui-scroll-wrapper').scroll();
mui('body').on('shown', '.mui-popover', function(e) {
    //console.log('shown', e.detail.id);//detail为当前popover元素
});
mui('body').on('hidden', '.mui-popover', function(e) {
    //console.log('hidden', e.detail.id);//detail为当前popover元素
});
$(function (){
    // $("#popover").css("width",$(window).width());
    init();


})
function leftformate(num) {
    var str  = ""
    $.each(list,function (b,c){
        var str1 = "style=\"background: #efeff4\"";
        if(b==num){
            str1 = "";
        }
        str+=" <li class=\"mui-table-view-cell\" data-id='"+c.id+"'"+str1+" >"+c.name+"</li>"
    });
    $("#ite_menu").html("");
    $("#ite_menu").html(str);
    $("#ite_menu .mui-table-view-cell").on("tap",function(){
        $("#ite_menu .mui-table-view-cell").attr("style","background: #efeff4");
        $(this).attr("style","");
        var top = $("#item"+$(this).data("id")).position().top;
        var top1 = $("#item"+listnow[0].ki_id).position().top;
        $("#ite_list").scrollTop(top-top1);
    });
}
function rightformate() {
    var temp =""
    var str ="";
    $.each(listnow,function (b,c) {
        var tempn = false;
        if(temp != c.ki_name){
            tempn = true;
            temp = c.ki_name;
            str +="<ul class=\"mui-table-view\"id='item"+c.ki_id+"'>\n" +temp;
        }
        str+="		<li class=\"mui-table-view-cell mui-media\">\n" +
            "				<a href=\"javascript:;\">\n" +
            "						<img class=\"mui-media-object mui-pull-left\" src=\"../images/shuijiao.jpg\">\n" +
            "						<div class=\"mui-media-body\">\n" +c.name+
            "								<div class=\"mui-row\">\n" +
            "										<div class=\"mui-col-xs-6\">\n" +
            "												<em>¥"+c.price+"</em>\n" +
            "										</div>\n" +
            "										<div class=\"mui-col-xs-6\">\n" +
            "<div class=\"mui-numbox\" data-numbox-min=\"0\" data-numbox-max=\"20\" style=\"width: 100%;height: 24px\">\n" +
            "		<button class=\"mui-btn mui-btn-numbox-minus\" type=\"button\" style=\"width:25px\" disabled=\"\">-</button>\n" +
            "		<input  id= \"itemipt"+b+"\" data-row="+b+" class=\"mui-input-numbox mytext\" type=\"number\" value=\"0\">\n" +
            "		<button class=\"mui-btn mui-btn-numbox-plus\" type=\"button\" style=\"width:25px\">+</button>\n" +
            "</div>\n"+
            "										</div>\n" +
            "								</div>\n" +
            "						</div>\n" +
            "				</a>\n" +
            "		</li>\n";
        if(tempn){
            str+="</ul>"
        }
    })
    $("#ite_list").html("");
    $("#ite_list").html(str);
    mui('.mui-numbox').numbox();
    $(".mytext").change(function(){
        //操作商品
        buycar[$(this).data("row")] = this.value;

        if(this.value==0){
            delete buycar[$(this).data("row")];
        }
        buycarlistup();
        if(objectisnul(buycar)){
            $("#foot").hide();
            $("#foot1").show();
        }
        else {
            $("#foot1").hide();
            $("#foot").show();
        }

    })
}
//购物车刷新
function buycarlistup(){
    var str = "";
    if(objectisnul(buycar)){
    }
    else
    {
        var pricetitle = 0;
        var titlenum = 0;
        for(var i in buycar){
            var price = listnow[i].price*buycar[i];
            pricetitle=(pricetitle*100+price*100)/100;
            titlenum = titlenum+parseInt(buycar[i]);
            str+="		<li class=\"mui-table-view-cell mui-media\">\n" +
                "<div class=\"mui-row\">\n" +
                "										<div class=\"mui-col-xs-4\">\n" +
                "												<em>"+listnow[i].name+"</em>\n" +
                "										</div>\n" +
                "										<div class=\"mui-col-xs-4\">\n" +
                "												<em>¥"+price+"</em>\n" +
                "										</div>\n" +
                "										<div class=\"mui-col-xs-4\">\n" +
                "<div class=\"mui-numbox\" data-numbox-min=\"0\" data-numbox-max=\"20\" style=\"width: 100%;height: 24px\">\n" +
                "		<button class=\"mui-btn mui-btn-numbox-minus\" type=\"button\" style=\"width:25px\" disabled=\"\">-</button>\n" +
                "		<input  data-row=\""+i+"\" class=\"mui-input-numbox mytext1\" type=\"number\" value=\""+buycar[i]+"\" style=\" background-color: #732c2c\">\n" +
                "		<button class=\"mui-btn mui-btn-numbox-plus\" type=\"button\" style=\"width:25px\">+</button>\n" +
                "</div>\n" +
                "										</div>\n" +
                "								</div>" +
                "		</li>\n";
        }
        $("#pricetitle").html(pricetitle);
        $("#titlenum").html(titlenum);
    }

    $("#popover ul").html(str);

    mui('.mui-numbox').numbox();
    $(".mytext1").change(function(){
        //操作商品
        buycar[$(this).data("row")] = this.value;
        $("#itemipt"+$(this).data("row"))[0].value = this.value;
        if(this.value==0){
            delete buycar[$(this).data("row")];
            mui('#popover').popover('toggle');
            if(objectisnul(buycar)){

            }else{
                mui('#popover').popover('toggle');
            }
        }
        buycarlistup();
        if(objectisnul(buycar)){
            $("#foot").hide();
            $("#foot1").show();
        }
        else {
            $("#foot1").hide();
            $("#foot").show();
        }
    })
}
function objectisnul(obj){
    for(var i in obj){

        return false;
    }
    return true;
}
var buycar = {};
function  init() {
    leftformate(0);
    rightformate();
}
