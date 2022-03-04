/*TMODJS:{"version":18,"md5":"54fb10170e65ea0933ca7298017cc7e8"}*/
template('stuTable',function($data,$filename
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
$out+=$escape($value.faculty);
$out+='</td> <td>';
$out+=$escape($value.major);
$out+='</td> <td>';
$out+=$escape($value.level == 0 ? '专科' : '本科');
$out+='</td> <td>';
$out+=$escape($value.clazz);
$out+='</td> <td>';
$out+=$escape($value.phoneNumber);
$out+='</td> <td>';
$out+=$escape('学生');
$out+='</td> <td> <a href="';
$out+=$escape($value.changeLink);
$out+='">修改</a> <button value="0">删除</button> <a href="';
$out+=$escape($value.path);
$out+='">查看详情</a> </td> </tr> ';
});
return new String($out);
});