/*TMODJS:{"version":2,"md5":"6f1c0dfac4eacc58ac37d644a1a64445"}*/
template('stuPersonneldoc',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,$value=$data.$value,$out='';$out+='<a href="';
$out+=$escape($value.detailsLink);
$out+='" class="stu-view-a">点击此处查看详情</a>';
return new String($out);
});