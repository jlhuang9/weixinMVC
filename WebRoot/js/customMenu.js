/**
 * Created by Administrator on 2016/10/27.
 */
var weixin_menu =[];
function update(){
    $.ajax({
        type: "POST",
        url: base_path+"web/getlist",
        data: "",
        dataType: "json",
        success: function (res) {
            if(res.result==1){
                weixin_menu = res.data.menu.button;
                phone_update()
            }

        }
    })
}
function update_to_wx(){
    var data ={
        menu :JSON.stringify(weixin_menu)
    }
    $.ajax({
        type: "POST",
        url: base_path+"web/makelist",
        data: data,
        dataType: "json",
        success: function (res) {
            if(res.result==1){
                layer.msg("修改成功!",{icon:1});
            }
            if(res.result==2){
                layer.alert("errorCode:"+res.error+";errorMsg"+res.errorMsg,{icon:2});
            }
        }
    })
}
function phone_update(row1,row2){
    if(row1==NaN||row1==""||row1==null){
        row1=0
    }
    if(row2==NaN||row2==""||row2==null){
        row2=0
    }
    var str ="";
    var add = 100;
    var one = 100;
    if(weixin_menu.length>0){
        add = 20;
        one = (100-add)/weixin_menu.length;
        $.each(weixin_menu,function(d,b){
            var temp =""
            if(weixin_menu[d].sub_button){
                temp = "<div class=\"btn-group dropup\">\n" +
                    "  <button type=\"button\" onclick='item_clack("+d+")' class=\"btn btn-default \">"+b.name+"</button>\n" +
                    "  <button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                    "    <span class=\"caret\"></span>\n" +
                    "    <span class=\"sr-only\">Toggle Dropdown</span>\n" +
                    "  </button>\n" +
                    "  <ul class=\"dropdown-menu\" role=\"menu\">\n";
                if(weixin_menu[d].sub_button.length<5){
                    temp +="<li class=\"\">\n" +
                        "        <a>+</a></li>\n" +
                        "   <li>";
                }
                $.each(weixin_menu[d].sub_button,function(a,c){
                    temp +="<li class=\"\">\n" +
                        "        <a onclick=\"item_clack('"+d+"','"+a+"')\">"+c.name+"</a></li>\n" +
                        "   <li>";
                })

                temp += "    <!-- Dropdown menu links -->\n" +
                    "  </ul>\n" +
                    "</div>";
            }
            str+=temp;
        })
    }
    str+="<div class=\"btn btn-info\" style='height: 100%;width: "+add+"%'>+</div>";
    $("#btn_list").html(str);
    right_update(row1,row2);
}
function right_update(row1,row2){
    if(weixin_menu){
        var div = document.getElementById("tabbable_list");
        var tempui = document.createElement("ul");
        var tempdiv = document.createElement("div");
        tempdiv.setAttribute("class","tab-content")
        tempui.setAttribute("class","nav nav-tabs");
        if(weixin_menu.length>0){


            $.each(weixin_menu,function(d,b) {
                var bean = d == row1 ? true : false;
                var templi = document.createElement("li");
                if(bean){
                    templi.setAttribute("class","active");
                }
                var tempa = document.createElement("a");
                tempa.setAttribute("class", "btn_tab_list");
                tempa.setAttribute("data-toggle", "tab");
                tempa.setAttribute("aria-expanded", bean);
                tempa.setAttribute("href", "#home" + d);
                tempa.appendChild(document.createTextNode(b.name));
                var tempiup1=document.createElement("i");
                tempiup1.setAttribute("class","ace-icon glyphicon glyphicon-pencil");
                tempiup1.setAttribute("onclick","cha_name("+d+")");
                var tempi1=document.createElement("i");
                tempi1.setAttribute("class","ace-icon fa fa-times");
                tempi1.setAttribute("onclick","del_update("+d+")");

                tempa.appendChild(tempiup1);
                tempa.appendChild(tempi1);
                templi.appendChild(tempa);
                tempui.appendChild(templi);

                var tempdiv1 = document.createElement("div");
                if(bean){
                    tempdiv1.setAttribute("class", "tab-pane fade active in");
                }
                else{
                    tempdiv1.setAttribute("class", "tab-pane fade");
                }
                tempdiv1.setAttribute("id", "home" + d);
                if(weixin_menu[d].sub_button){
                }
                else{
                    var arr  = new Array;
                    weixin_menu[d].sub_button = arr;
                }
                if(weixin_menu[d].sub_button.length>0){
                    var tempul1 = document.createElement("ul");
                    tempul1.setAttribute("class","nav nav-tabs");
                    var tempdiv2 = document.createElement("div");
                    tempdiv2.setAttribute("class","tab-content");
                    $.each(weixin_menu[d].sub_button, function (a, c) {
                        var templi2 = document.createElement("li");
                        var div3 = document.createElement("div");
                        if(a==row2){
                            templi2.setAttribute("class","active");
                            div3.setAttribute("class","tab-pane fade active in");
                        }
                        else{
                            div3.setAttribute("class","tab-pane fade");
                        }

                        div3.setAttribute("id","home" + d+a);
                        var tempa2 = document.createElement("a");
                        tempa2.setAttribute("class", "btn_tab_list");
                        tempa2.setAttribute("data-toggle", "tab");
                        tempa2.setAttribute("aria-expanded", bean);
                        tempa2.setAttribute("href", "#home" + d+a);
                        tempa2.appendChild(document.createTextNode(c.name));
                        var tempi2=document.createElement("i");
                        tempi2.setAttribute("class","ace-icon fa fa-times");
                        tempi2.setAttribute("onclick","del_update('"+d+"','"+a+"')");

                        tempa2.appendChild(tempi2);
                        templi2.appendChild(tempa2);
                        div3.appendChild(makeform(c,d,a));

                        tempul1.appendChild(templi2);
                        tempdiv2.appendChild(div3);

                    });
                    if(weixin_menu[d].sub_button.length<5){
                        var templiadd2 = document.createElement("li");
                        var tempaadd2 = document.createElement("a");
                        tempaadd2.appendChild(document.createTextNode("+"));
                        tempaadd2.setAttribute("onclick","addtab_son("+d+")");
                        templiadd2.appendChild(tempaadd2);
                        tempul1.appendChild(templiadd2);
                    }
                    tempdiv1.appendChild(tempul1);
                    tempdiv1.appendChild(tempdiv2);
                }
                else{
                    tempdiv1.appendChild(makeform(b,d));
                }

                tempdiv.appendChild(tempdiv1);
            });
            if(weixin_menu.length<3){
                var templiadd2 = document.createElement("li");
                var tempaadd2 = document.createElement("a");
                tempaadd2.appendChild(document.createTextNode("+"));
                tempaadd2.setAttribute("onclick","addtab_fa()");
                templiadd2.appendChild(tempaadd2);
                tempui.appendChild(templiadd2);
            }

        }
        div.innerHTML="";//清空
        div.appendChild(tempui);
        div.appendChild(tempdiv);
    }
}
 var layer_temp_top;
function cha_name(d){
    layer_temp_top = d;
    layer.prompt({
        formType: 0,
        value: '',
        title: '请输入名称'
    }, function(value, index, elem){
        weixin_menu[layer_temp_top].name = value;
        phone_update();
        layer.close(index);
    });
}
function addtab_fa(){
    layer.prompt({
        formType: 0,
        value: '',
        title: '请输入名称'
    }, function(value, index, elem){
        weixin_menu.push({name:value});
        phone_update(weixin_menu.length-1);
        layer.close(index);
    });
}
var layer_temp;
function addtab_son(num){
    layer_temp= num;
    layer.prompt({
        formType: 0,
        value: '',
        title: '输入name'
    }, function(value, index, elem){

        weixin_menu[layer_temp].sub_button.push({name:value});
        phone_update(layer_temp,weixin_menu[layer_temp].sub_button.length-1);
        layer.close(index);
    });
}
function del_update(d,a){
    if(a!=NaN&&a!=null){
        weixin_menu[d].sub_button.splice(a,1);
    }
    else {
        weixin_menu.splice(d,1);
    }
    right_update(0,0);
}
function makeform(obj,d,a){
    var form = document.createElement("form");
    var div = document.createElement("div");
    form.setAttribute("class","form-horizontal");
    form.setAttribute("role","form");
    var num = "";
    if(a!=NaN&&a!=null){
        num =""+d+a;
    }
    else{

        div.setAttribute("class","text-right col-sm-6");
        var tema1 = document.createElement("a");
        tema1.setAttribute("class","btn btn-warning btn-xlg");
        tema1.setAttribute("onclick","addtab_son("+d+")");
        var icon1 = document.createElement("i");
        icon1.setAttribute("class","ace-icon fa fa-refresh green");
        tema1.appendChild(icon1);
        tema1.appendChild(document.createTextNode("添加子菜单"));
        div.appendChild(tema1);
        num = ""+d;
    }
    var name = makeform_group("name",obj.name?obj.name:"",num);
    var key = makeform_group("key",obj.key?obj.key:"",num);
    var type = makeform_group("type",obj.type?obj.type:"",num);
    var url = makeform_group("url",obj.url?obj.url:"",num);
    var media_id = makeform_group("media_id",obj.media_id?obj.media_id:"",num);
    form.appendChild(name);
    form.appendChild(key);
    form.appendChild(type);
    form.appendChild(url);
    form.appendChild(media_id);
    //保存按钮
    var form_group = document.createElement("div");
    form_group.setAttribute("class","form-group");
    div.setAttribute("class","text-right col-sm-6");
    var tema = document.createElement("a");
    tema.setAttribute("class","btn btn-warning btn-xlg");
    var icon = document.createElement("i");
    icon.setAttribute("class","ace-icon fa fa-refresh green");
    tema.appendChild(icon);
    tema.appendChild(document.createTextNode("保存"));
    if(a!=NaN&&a!=null){
        tema.setAttribute("onclick","form_update('"+d+"','"+a+"')");
    }
    else {
        tema.setAttribute("onclick","form_update('"+d+"')");
    }
    div.appendChild(tema);
    form_group.appendChild(div);
    form.appendChild(form_group);
    return form;
}
function form_update(d,a) {
    var num ="";
    if(a!=NaN&&a!=null){
        num =""+d+a;
    }
    else{
        num = ""+d;
    }
    var temp = new Object;
    temp["name"]=$("#name_input"+num).val();
    temp["key"]=$("#key_input"+num).val();
    temp["type"]=$("#type_input"+num).val();
    temp["url"]=$("#url_input"+num).val();
    temp["media_id"]=$("#media_id_input"+num).val();
    if(a!=NaN&&a!=null){
        weixin_menu[d].sub_button[a] = temp;
    }
    else{
        weixin_menu[d] = temp;
    }

    phone_update();
}
function makeform_group(key,value,num) {
    var form_group = document.createElement("div");
    form_group.setAttribute("class","form-group");
    var label = document.createElement("label");
    label.setAttribute("class","col-sm-3 control-label no-padding-right");
    label.appendChild(document.createTextNode(key));


    var div = document.createElement("div");
    div.setAttribute("class","col-sm-9");
    var input = document.createElement("input");
    input.setAttribute("type","text");
    input.setAttribute("class","col-xs-10 col-sm-5");
    input.setAttribute("id",key+"_input"+num);
    input.value= value;
    div.appendChild(input);

    form_group.appendChild(label);
    form_group.appendChild(div);



    return form_group;
}

function havesun(obj){
    if(obj.sub_button){
        if(obj.sub_button.length==0){
            return false;
        }
        else{
            return true;
        }
    }
    return false;
}
function item_clack(row,rol){
    if(rol){
        var temp = weixin_menu[row].sub_button[rol];
        if(temp.type="click"){
            $(".btn_tab_list:eq(3)").trigger("click")
        }
        else{
            $(".btn_tab_list:eq(2)").trigger("click")
        }
    }
    else{

    }
}