/*TMODJS:{"version":13,"md5":"a4e2539c33e1cdece224f674293c38f7"}*/
template('teaPersonneldoc',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,items=$data.items,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each(items,function($value,$index){
$out+=' <tr> <td>';
$out+=$escape($value.number);
$out+='</td> <td>';
$out+=$escape($value.institute);
$out+='</td> <td>';
$out+=$escape($value.major);
$out+='</td> <td>';
$out+=$escape($value.grade);
$out+='</td> <td>';
$out+=$escape($value.level == 0 ? '本科' : '专科');
$out+='</td> <td>';
$out+=$escape($value.status);
$out+='</td> <td> <a href="';
$out+=$escape($value.operation);
$out+='">';
$out+=$escape($value.operation == 0 ? '重新上传' :'查看详情');
$out+='</a> </td> </tr> ';
});
return new String($out);
});