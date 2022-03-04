/*TMODJS:{"version":13,"md5":"6c366cf1b56b4b1885dc414d9a52fab2"}*/
template('awardTable',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,$value=$data.$value,$index=$data.$index,$escape=$utils.$escape,$out='';$each($data,function($value,$index){
$out+=' <tr> <td><input type="checkbox" class="td-checkbox" name="td-checkbox"></td> <td>';
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
$out+=$escape($value.level);
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
$out+=' </td> <td> <button>删除</button> <a href="';
$out+=$escape($value.path);
$out+='" target="_blank">查看详情</a> </td> </tr> ';
});
return new String($out);
});