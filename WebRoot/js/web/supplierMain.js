$(function () {
    gridinit();
})
function gridinit() {
    $.jgrid.ajaxOptions.type = 'post';
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";


    var parent_column = $(grid_selector).closest('[class*="col-"]');
    //resize to fit page size
    $(window).on('resize.jqGrid', function () {
        $(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
    })

    //resize on sidebar collapse/expand
    $(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
        if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
            //setTimeout is for webkit only to give time for DOM changes and then redraw!!!
            setTimeout(function() {
                $(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
            }, 20);
        }
    })

    //if your grid is inside another element, for example a tab pane, you should use its parent's width:
    /**
     $(window).on('resize.jqGrid', function () {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				})
     //and also set width when tab pane becomes visible
     $('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				  if($(e.target).attr('href') == '#mygrid') {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				  }
				})
     */





    jQuery(grid_selector).jqGrid({
        //subGridModel: [{ name : ['No','Item Name','Qty'], width : [55,200,80] }],

        //direction: "rtl",

        //subgrid options
        url:base_path+"web/getSupplierList",
        datatype: "json",
        type : "post",
        rownumbers :true,
        subGridOptions : {
            plusicon : "ace-icon fa fa-plus center bigger-110 blue",
            minusicon  : "ace-icon fa fa-minus center bigger-110 blue",
            openicon : "ace-icon fa fa-chevron-right center orange"
        },
        //for this example we are using local data

        height: 300,
        colNames:['id','用户名','昵称','密码'],
        colModel:[
            {name:'id',index:'id', width:60, sorttype:"int", editable: true},
            {name:'username',index:'username',width:90, editable:true,},
            {name:'nick',index:'nick',width:90, editable:true},
            {name:'password',index:'password', width:150,edittype: 'password' ,editable: true,formatter:function(cellvalue, options, rowObject){
        return '******'}}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager : pager_selector,
        altRows: true,
        jsonReader: {
            root:"row",                // 数据行（默认为：rows）
            page: "currPage",               // 当前页
            total: "totalPages",            // 总页数
            records: "totalCount",        // 总记录数
            repeatitems : false             // 设置成false，在后台设置值的时候，可以乱序。且并非每个值都得设
        },
        //toppager: true,

        multiselect: true,
        //multikey: "ctrlKey",
        multiboxonly: true,

        loadComplete : function() {
            var rowNum = parseInt($(this).getGridParam("records"), 10); if (rowNum <= 0) { layer.alert("没有符合条件的记录！"); }
            var table = this;
            setTimeout(function(){

                updatePagerIcons(table);
            }, 0);
        },
        caption: "供应商列表"

        //,autowidth: true,


        /**
         ,
         grouping:true,
         groupingView : {
						 groupField : ['name'],
						 groupDataSorted : true,
						 plusicon : 'fa fa-chevron-down bigger-110',
						 minusicon : 'fa fa-chevron-up bigger-110'
					},
         caption: "Grouping"
         */
    });
    $(window).triggerHandler('resize.jqGrid');
    $("#updata").click(function() {
        var gr = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
        if (gr != null)
            jQuery(grid_selector).jqGrid('editGridRow', gr, {
                url : base_path+"web/supplieredit",
                afterComplete : function (response, postdata, formid) {
                    var res = JSON.parse(response.responseText);
                    layer.msg(JSON.parse(response.responseText).msg,{icon:res.status==1?1:2});
                    $(".ui-jqdialog-titlebar-close").click();
                },
                reloadAfterSubmit : true
            });
        else
            layer.msg("请选择一条数据!",{icon:2});
    });
    $("#adddata").click(function() {
        jQuery(grid_selector).jqGrid('editGridRow', "new", {
            url : base_path+"web/supplieradd",
            afterComplete : function (response, postdata, formid) {
                var res = JSON.parse(response.responseText);
                layer.msg(JSON.parse(response.responseText).msg,{icon:res.status==1?1:2});
                $(".ui-jqdialog-titlebar-close").click();
            },
            reloadAfterSubmit : true
        });
    });
    $("#dedata").click(function() {
        var gr = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow')+"";
        if (gr != null)
            jQuery(grid_selector).jqGrid('delGridRow', gr, {
                url : base_path+"web/supplierdel",
                afterComplete : function(response, postdata) {
                    var res = JSON.parse(response.responseText);
                    layer.msg(JSON.parse(response.responseText).msg,{icon:res.status==1?1:2});
                    $(".ui-jqdialog-titlebar-close").click();
                },
                reloadAfterSubmit : true
            });
        else
            layer.msg("请选择一条数据!",{icon:2});
    });
}
function style_edit_form(form) {
    //enable datepicker on "sdate" field and switches for "stock" field
    form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})

    form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
    //don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
    //.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');


    //update buttons classes
    var buttons = form.next().find('.EditButton .fm-button');
    buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
    buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
    buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

    buttons = form.next().find('.navButton a');
    buttons.find('.ui-icon').hide();
    buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
    buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
}

function updatePagerIcons(table) {
    var replacement =
    {
        'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
        'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
        'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
        'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    })
}

function serch(){
    jQuery("#grid-table").jqGrid('setGridParam', {
        postData : {"name":$("#form-field-1").val()},
        page : 1
    }).trigger('reloadGrid');
}