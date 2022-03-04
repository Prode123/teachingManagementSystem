/*TMODJS:{"version":10,"md5":"5f67fef4acb9830541f768d78c9d8355"}*/
template('awardinfo',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <tr> <td>';
$out+=$escape($index + 1);
$out+='</td> <td>';
$out+=$escape($value.number);
$out+='</td> <td>';
$out+=$escape($value.pwinner);
$out+='</td> <td>';
$out+=$escape($value.category == 0? '单人赛' : '团体赛');
$out+='</td> <td>';
$out+=$escape($value.pname);
$out+='</td> <td>';
$out+=$escape($value.plevel);
$out+='</td> <td>';
$out+=$escape($value.title);
$out+='</td> <td>';
$out+=$escape($value.tname);
$out+='</td> <td> ';
if($value.status == 0){
$out+=' 待审核 ';
}else if($value.status == 1){
$out+=' 通过 ';
}else if($value.status == 2){
$out+=' 不通过 ';
}
$out+=' </td> <td><a href="';
$out+=$escape($value.path);
$out+='">';
$out+=$escape($value.status == 2 ? '重新上传' :'查看详情');
$out+='</a></td> </tr> ';
});
return new String($out);
});