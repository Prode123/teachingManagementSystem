/*TMODJS:{"version":14,"md5":"ea98e2c689b771ed8bc85b3ce8c3b5c7"}*/
template('teaTable',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <tr> <td><input type="checkbox" name="td-checkbox"></td> <td>';
$out+=$escape($value.username);
$out+='</td> <td>';
$out+=$escape($value.sex == 0 ? '男' : '女');
$out+='</td> <td>';
$out+=$escape($value.identifyCard);
$out+='</td> <td>';
$out+=$escape($value.number);
$out+='</td> <td>';
$out+=$escape($value.major);
$out+='</td> <td>';
$out+=$escape($value.title);
$out+='</td> <td>';
$out+=$escape($value.teachingResearch);
$out+='</td> <td>';
$out+=$escape($value.phoneNumber);
$out+='</td> <td> ';
if($value.roleId == 1){
$out+=' 普通教师 ';
}else if($value.roleId == 2){
$out+=' 课程负责人 ';
}else if($value.roleId == 3){
$out+=' 教研室主任 ';
}
$out+=' </td> <td> <a href="';
$out+=$escape($value.changeLink);
$out+='">修改</a> <button value="0">删除</button> <a href="';
$out+=$escape($value.detailsLink);
$out+='">查看详情</a> </td> </tr> ';
});
return new String($out);
});