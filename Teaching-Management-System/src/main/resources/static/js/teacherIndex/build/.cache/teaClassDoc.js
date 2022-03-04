/*TMODJS:{"version":10,"md5":"dfe8214ad4d909b199dc08e0df0350df"}*/
template('teaClassDoc',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <tr> <td>';
$out+=$escape($index + 1);
$out+='</td> <td>';
$out+=$escape($value.semester);
$out+='</td> <td>';
$out+=$escape($value.faculty);
$out+='</td> <td>';
$out+=$escape($value.major);
$out+='</td> <td>';
$out+=$escape($value.grade);
$out+='</td> <td>';
$out+=$escape($value.fileName);
$out+='</td> <td>';
$out+=$escape($value.level == 0 ? '专科' : '本科');
$out+='</td> <td>';
if($value.status == 0 ){
$out+=' 待审核 ';
}else if($value.status == 1){
$out+=' 通过 ';
}else if($value.status == 2){
$out+=' 不通过 ';
}
$out+=' </td> <td><a href="';
$out+=$escape($value.operation);
$out+='">';
$out+=$escape($value.operation == 0 ? '重新上传' :'查看详情');
$out+='</a></td> </tr> ';
});
return new String($out);
});