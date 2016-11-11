var mycooke =function (){
   return {
        getgoodskind : function (){
            if(mycooke.isEmptyObject(mycooke.goodskindlist.length))
            $.ajax({
                type: 'POST',
                url: base_path+"suplier/getGoodskindallList",
                data: "",
                success: function (res){
                    if(res.status==1){
                        for(var i = 0 ; i<res.rows.length;i++){
                            mycooke.goodskindlist[res.rows[i].id] = res.rows[i].name;
                        }
                    }
                },
                dataType: "json",
                async:false
            });
            return mycooke.goodskindlist;
        },
       goodskindlist : {},
       isEmptyObject : function (obj){
           for (var a in obj){
               return false
           }
           return true
       }
   }
}();