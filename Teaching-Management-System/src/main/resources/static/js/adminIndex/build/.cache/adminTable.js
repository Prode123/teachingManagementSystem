/*TMODJS:{"version":29,"md5":"785c8a095411256b5e7deb0dab57338f"}*/
template('adminTable',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,items=$data.items,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each(items,function($value,$index){
$out+=' <tr> <td><input type="checkbox" name=""></td> <td>';
$out+=$escape($value.name);
$out+='</td> <td>';
$out+=$escape($value.sex == 0 ? '男' : '女');
$out+='</td> <td>';
$out+=$escape($value.idCard);
$out+='</td> <td>';
$out+=$escape($value.sid);
$out+='</td> <td>';
$out+=$escape('计算机与信息技术学院');
$out+='</td> <td>';
$out+=$escape($value.major);
$out+='</td> <td>';
$out+=$escape('专科');
$out+='</td> <td>';
$out+=$escape($value.clazz);
$out+='</td> <td>';
$out+=$escape($value.phone);
$out+='</td> <td>';
$out+=$escape('学生');
$out+='</td> <td><a class="modifileStudentInfo">修改</a><a href="javascript:;">删除</a><a href="javascript:;">查看详情</a></td> </tr> ';
});
return new String($out);
});