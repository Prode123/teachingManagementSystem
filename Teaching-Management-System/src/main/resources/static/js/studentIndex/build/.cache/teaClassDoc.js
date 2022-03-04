/*TMODJS:{"version":55,"md5":"e30efabc211e32b21860f1ffd87fb6af"}*/
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
$out+=$escape($value.status);
$out+='">';
$out+=$escape($value.status == 2 ? '重新上传' :'查看详情');
$out+='</a></td> </tr> ';
});
return new String($out);
});