/*TMODJS:{"version":51,"md5":"2f66d8ee9d6dc478abc42bb3224659b0"}*/
template('stuInfo',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,obj=$data.obj,$out='';$out+=' <div class="info-name"> <span class="twoFont">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span> <span>';
$out+=$escape(obj.name);
$out+='</span> </div> <div class="info-sex"> <span class="twoFont">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span> <span>';
$out+=$escape(obj.sex == 0 ? '男' : '女');
$out+=' </span> </div> <div class="info-idCard"> <span class="fourFont">身份证号:</span> <span>';
$out+=$escape(obj.idCard);
$out+='</span> </div> <div class="info-sid"> <span class="twoFont">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span> <span>';
$out+=$escape(obj.sid);
$out+='</span> </div> <div class="info-class"> <span class="twoFont">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</span> <span>';
$out+=$escape(obj.class);
$out+='</span> </div> <div class="info-dept"> <span class="twoFont">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span> <span>';
$out+=$escape(obj.dept);
$out+='</span> </div> <div class="info-phone"> <span class="threeFont">手&nbsp;&nbsp;机&nbsp;&nbsp;号:</span> <span>';
$out+=$escape(obj.phone);
$out+='</span> </div>';
return new String($out);
});